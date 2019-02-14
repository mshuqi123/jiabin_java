package com.comics.jiabin.awutils;

import net.bytebuddy.asm.Advice;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.Executor;
import org.apache.commons.io.FileUtils;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.util.concurrent.TimeUnit;
import com.comics.jiabin.BaseUtil.*;
import javax.imageio.ImageIO;

public class AwUtils {
    WebElement webElement;
    public static WebDriver driver = getDrive();
//    private WebDriver driver;
    public static WebDriver getDrive() {
        ConfigManagerUtil config = new ConfigManagerUtil();
		WebDriver driver = new ChromeDriver();
        String str  = config.get("testurl");
        driver.get(str);
        driver.manage().window().maximize();//设置窗口大小
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//设置页面加载超时
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置查询组件等待时间
        return driver;
    }
    public void findByidClick(String str) {
        webElement = driver.findElement(By.id(str));
//        Assert.assertEquals(webElement.getText(), str);
        webElement.click();
    }
    public void findByidsend(String str,String text) {
        webElement = driver.findElement(By.id(str));
//        Assert.assertEquals(webElement.getText(), str);
        webElement.sendKeys(text);
    }
    //截图命名为当前时间保存桌面
//    public void takeScreenshotByNow() throws IOException {
//        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        String file = "C:\\Users\\fankaiqiang\\Desktop\\888\\picture\\321\\"+getNow()+".png";
//        FileUtils.copyFile(srcFile,new File(file));
//    }
    //截图重命名保存至桌面
    public void takeScreenshotByName(String name) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String file = "C:\\Users\\fankaiqiang\\Desktop\\888\\picture\\321\\"+name+".png";
        FileUtils.copyFile(srcFile,new File(file));
    }
    //通过id获取元素并点击
    public void findElementByIdAndClick(String id) {
        driver.findElement(By.id(id)).click();
    }
    public void findElementByNameAndClick(String name) {
        findElementByName(name).click();
    }
    //根据文本获取元素并点击
    public void findElementByTextAndClick(String text) {
        driver.findElement(By.linkText(text)).click();
    }
    //根据文本模糊查找
    public void findElementByPartiaTextAndClick(String text) {
        driver.findElement(By.partialLinkText(text)).click();
    }
    //根据xpath获取元素
    public WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
    public WebElement findElementByTag(String tag) {
        return driver.findElement(By.tagName(tag));
    }
    //根据id获取元素
    public WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }
    //根据id获取元素清除文本写入文本
    public void findElementByIdAndClearSendkeys(String id1 , String id2, String text) {
        driver.findElement(By.id(id1)).clear();
        driver.findElement(By.id(id2)).sendKeys(text);
    }
    public void findElementByIdAndClearSendkeys(String id, String text) {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(text);
    }
    public void findElementByIdAndClearSendkeys(String id, int num) {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(num+"");
    }
    public void findElementByNameAndClearSendkeys(String name, String text) {
        findElementByName(name).clear();
        findElementByName(name).sendKeys(text);
    }
    public void findElementByNameAndClearSendkeys(String name, int num) {
        findElementByName(name).clear();
        findElementByName(name).sendKeys(num+"");
    }
    //通过xpath获取元素点击
    public void findElementByXpathAndClick(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }
    //通过class获取元素并点击
    public void findElementByClassNameAndClick(String name) {
        driver.findElement(By.className(name)).click();
    }
    public WebElement findElementByClassName(String name){
        return driver.findElement(By.className(name));
    }
    //获取一组元素
    public List<WebElement> findElementsByClassName(String className) {
        return driver.findElements(By.className(className));
    }
    //根据text获取一组页面元素
    public List<WebElement> findElementsByText(String text) {
        return driver.findElements(By.linkText(text));
    }
    public List<WebElement> findElementsByPartialText(String text) {
        return driver.findElements(By.partialLinkText(text));
    }
    //根据id获取一组页面元素
    public List<WebElement> findElementsById(String id) {
        return driver.findElements(By.id(id));
    }
    //根据tagName获取一组页面元素
    public List<WebElement> findElementsByTag(String tag) {
        return driver.findElements(By.tagName(tag));
    }
    public WebElement findElementByText(String text){
        return driver.findElement(By.linkText(text));
    }
    public WebElement findElementByPartialText(String text){
        return driver.findElement(By.partialLinkText(text));
    }
    public WebElement findElementByName(String name) {
        return driver.findElement(By.name(name));
    }
    //输出cookies信息
    public void outputCookie() {
        Set<Cookie> cookie = driver.manage().getCookies();
        System.out.println(cookie);
//		Cookie abc = new Cookie("", "");
//		driver.manage().addCookie(abc);
    }
    public void addCookie(Map<String, String> args) {
        Set<String> keys = args.keySet();
        for(String key : keys){
            driver.manage().addCookie(new Cookie(key, args.get(key)));
        }
    }

    //判断元素是否存在
    public boolean exists(By selector) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//设置查询组件等待时间
        try {
            driver.findElement(selector);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置查询组件等待时间
            return true;
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置查询组件等待时间
            return false;
        }
    }
    //通过js点击
    public void clickByJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        //第二种点击方法
//		((JavascriptExecutor) driver).executeScript("arguments[0].click()", question);
    }
    //通过xpath获取元素用js点击
    public void clickByJsByXpath(String xpath) {
        clickByJs(driver.findElement(By.xpath(xpath)));
    }
    public void clickByJsByText(String text) {
        clickByJs(findElementByText(text));
    }
    public void clickByJsById(String id) {
        clickByJs(findElementById(id));
    }
    public void clickByJsByClassName(String name) {
        clickByJs(findElementByClassName(name));
    }
    public void clickByJsByName(String name) {
        clickByJs(findElementByName(name));
    }
    //按物理按键
    public void pressKeyEvent(int keycode) throws AWTException {
        Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);//按下enter键
        robot.keyPress(keycode);
    }
    //通过xpath获取元素清除文本并写入
    public void findElementByXpathAndClearSendkeys(String xpath, String text) {
        findElementByXpath(xpath).clear();
        findElementByXpath(xpath).sendKeys(text);
    }
    public void findElementByXpathAndClearSendkeys(String xpath, int num) {
        findElementByXpath(xpath).clear();
        findElementByXpath(xpath).sendKeys(num+"");
    }
    //判断是否有警告框
    public boolean judgeAlert(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            System.out.println("没有发现警告框！");
            return false;
        }
    }
    //获取文本
    public String getTextByXpath(String xpath) {
        return findElementByXpath(xpath).getText();
    }
    public String getTextByClassName(String name) {
        return findElementByClassName(name).getText();
    }
    public String getTextById(String id) {
        return findElementById(id).getText();
    }
    public String getTextByName(String name) {
        return findElementByName(name).getText();
    }
    //通过xpath获取classname
    public String getClassNameByXpath(String xpath) {
        return findElementByXpath(xpath).getAttribute("class");
    }
    //通过id获取classname
    public String getClassNameById(String id) {
        return findElementById(id).getAttribute("class");
    }
    //强制刷新
    public void refresh() {
        Actions ctrl = new Actions(driver);
        ctrl.keyDown(Keys.CONTROL).perform();
        try {
            pressKeyEvent(KeyEvent.VK_F5);
        } catch (AWTException e) {
//            System.out.println(sad+getNow());
            e.printStackTrace();
        }
        ctrl.keyUp(Keys.CONTROL).perform();
//		driver.navigate().refresh();
    }
//	//显式等待
//	public void waitForWebElementByXpathAndClick(String xpath) {
//		new WebDriverWait(5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//		findElementByXpathAndClick(xpath);
//	}

    //等待元素可用再点击
    public void waitForEnabledByXpathAndClick(String xpath) throws InterruptedException {
        boolean key = true;
        while(key){
            if (findElementByXpath(xpath).isEnabled() && findElementByXpath(xpath).isDisplayed()) {
                System.out.println(123);
                clickByJsByXpath(xpath);
//				findElementByXpathAndClick(xpath);
                key = false;
            }else{
                Thread.sleep(3000);
            }
        }
    }
    //右键点击
    public void	RightClickWebElement(String id) {
        Actions actions = new Actions(driver);
        actions.contextClick(findElementById(id)).perform();;
    }
    //根据classname获取元素清除并输入内容
    public void findElementByClassnameAndClearSendkeys(String classname, String text) {
        driver.findElement(By.className(classname)).clear();
        driver.findElement(By.className(classname)).sendKeys(text);
    }
    public void findElementByClassnameAndClearSendkeys(String classname, int num) {
        driver.findElement(By.className(classname)).clear();
        driver.findElement(By.className(classname)).sendKeys(num+"");
    }
    //根据id获取下拉框，根据index选择选项
    public void findSelectByIdAndSelectByIndex(String id, int index) {
        Select select = new Select(findElementById(id));
        select.selectByIndex(index);
    }
    //根据id获取下拉框，根据value选择选项
    public void findSelectByIdAndSelectByValue(String id, String value) {
        Select select = new Select(findElementById(id));
        select.selectByValue(value);
    }
    //根据id获取下拉框，根据text选择选项
    public void findSelectByIdAndSelectByText(String id, String text) {
        Select select = new Select(findElementById(id));
        select.selectByVisibleText(text);;
    }

    //根据classname获取下拉框，根据text选择选项
    public void findSelectByClassNameAndSelectByText(String name, String text) {
        Select select = new Select(findElementByClassName(name));
        select.selectByVisibleText(text);
    }
    //根据classname获取下拉框，根据Value选择选项
    public void findSelectByClassNameAndSelectByValue(String name, String value) {
        Select select = new Select(findElementByClassName(name));
        select.selectByValue(value);
    }
    //根据classname获取下拉框，根据index选择选项
    public void findSelectByClassNameAndSelectByIndex(String name, int index) {
        Select select = new Select(findElementByClassName(name));
        select.selectByIndex(index);
    }
    //根据name获取下拉框，根据text选择选项
    public void findSelectByNameAndSelectByText(String name, String text) {
        Select select = new Select(findElementByName(name));
        select.selectByVisibleText(text);
    }
    //根据name获取下拉框，根据Value选择选项
    public void findSelectByNameAndSelectByValue(String name, String value) {
        Select select = new Select(findElementByName(name));
        select.selectByValue(value);
    }
    //根据name获取下拉框，根据index选择选项
    public void findSelectByNameAndSelectByIndex(String name, int index) {
        Select select = new Select(findElementByName(name));
        select.selectByIndex(index);
    }
    //鼠标悬停
    public void moveToElementById(String id) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElementById(id));
    }
    public void moveToElementByClassName(String name) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElementByClassName(name));
    }
    //滚动到最上方
    public void scrollToTop() {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0,0);");
    }
    //滚动到页面底部
    public void scrollToBottom(String id) {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,10000);");
    }
    //滚动到某个元素
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    //js滚动页面内div
    public void scrollToBottomById(String id) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTo(0, 3000);", findElementById(id));
    }
    //使用js使元素隐藏元素显示
    public void makeDisplayById(String id) {
        JavascriptExecutor  js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById(id).style.display='block';");
    }
    public void makeElementDisplay(WebElement element) {
        JavascriptExecutor  js = (JavascriptExecutor)driver;
//		WebElement element = driver.findElement(By.xxx);
        js.executeScript("arguments[0].style=arguments[1]", element, "display: block;");
    }
    //js输入文本
    public void inputTextByJsById(String text, String id) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=\"2016-08-20\"",driver.findElement(By.id(id)));
    }
    //js输入文本
    public void inputTextByJs(String text, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=" + text + "\"", element);
    }
    //返回
    public void BrowserBack() {
        driver.navigate().back();
    }
    //前进
    public void BrowserForward() {
        driver.navigate().forward();
    }

}
