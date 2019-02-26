package com.comics.jiabin.awutils;
import com.comics.jiabin.BaseUtil.ConfigManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//浏览器的基类
public class BaseDriver {
    public static WebDriver driver;
    //启动并打开指定测试网页
    public static void setup(){
        ConfigManagerUtil config = new ConfigManagerUtil();
        String url  = config.get("testurl");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    //关闭浏览器驱动方法
    public void stopDriver() {
        System.out.println("Stop Driver!");
        driver.close();
    }


    /*
     * 封装Element方法
     *
     * */
    public WebElement findElement(By by) {
        WebElement element=driver.findElement(by);
        return element;
    }

    /*
     * get封装
     * */
    public void get(String url) {
        driver.get(url);
    }
    public void findElementByIdAndClick(String id) {
        driver.findElement(By.id(id)).click();
    }
    public void findElementByIdAndClearSendkeys(String id1 , String id2, String text) {
        driver.findElement(By.id(id1)).clear();
        driver.findElement(By.id(id2)).sendKeys(text);
    }
}