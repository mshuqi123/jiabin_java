package com.comics.jiabin.testcases;

import com.comics.jiabin.awutils.AwUtils;
import com.comics.jiabin.awutils.SetupDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.comics.jiabin.BaseUtil.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
//import java.time.Duration;
import java.util.List;

import javax.print.DocFlavor;

@Listeners({com.comics.jiabin.awutils.GenerateReporter.class})
public class WuyongTest extends SetupDriver{
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        setup();
        System.out.println("selenium");

    }
    @Test(description = "首次启动百度搜索页",priority = 1)
    public void defaulUi() throws InterruptedException{
//        driver.get("https://www.baidu.com/");
//        driver.findElement(By.id("kw")).clear();
//        driver.findElement(By.id("kw")).sendKeys("马树起3");
        findElementByIdAndClearSendkeys("kw","kw","woshiyigeren");
        findElementByIdAndClick("su");
        Thread.sleep(5000);
//        driver.close();
    }
    @Test(description = "书架-追漫默认页",priority = 2)
    public void addPages() throws InterruptedException{
//        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("马树起");
//        driver.findElement(By.id("su")).click();
        findElementByIdAndClick("su");
        Thread.sleep(5000);
    }

    @Test(description = "书架-历史默认页",priority = 3)
    public void historyPages() throws InterruptedException {
//        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("马树起2");
        driver.findElement(By.id("su")).click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void teardown() throws IOException {
        if (null != driver) {
            driver.quit();
        }
    }

}