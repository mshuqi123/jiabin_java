package com.comics.jiabin.testcases;

import com.comics.jiabin.awutils.AwUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
//import java.time.Duration;
import java.util.List;

import javax.print.DocFlavor;

@Listeners({com.comics.jiabin.awutils.GenerateReporter.class})
public class BaseTest extends AwUtils{
    private WebDriver driver;
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.manage().window().maximize();
        System.out.println("selenium");

    }
    @Test(description = "首次启动百度搜索页",priority = 1)
    public void defaultUi() throws InterruptedException{
        driver.findElement(By.id("kw")).sendKeys("selenium java");
        driver.findElement(By.id("su")).click();
//        findByidsend("kw","selenium java");
//        findByidClick("su");
        Thread.sleep(5000);
//        driver.close();
    }
//    @Test(description = "书架-追漫默认页",priority = 2)
//    public void addPage() {
//        waitForVisible(driver, By.id(BOOKSHELF),5);
//        findByIdClick(BOOKSHELF,true);
//        screenshotcompare((TakesScreenshot) driver,"add",0.8,true);
//    }
//
//    @Test(description = "书架-历史默认页",priority = 3)
//    public void historyPage() throws InterruptedException {
//        findByNameClick("历史",true);
//        screenshotcompare((TakesScreenshot) driver,"history",0.8,true);
//    }

    @AfterMethod
    public void teardown() throws IOException {
        if (null != driver) {
            driver.quit();
        }
    }

}