package com.comics.jiabin.testcases;

import com.comics.jiabin.awutils.AwUtils;
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
public class BaseTest{
    private WebDriver driver;
    ConfigManagerUtil config = new ConfigManagerUtil();
    String str  = config.get("testurl");
    private AwUtils base = new AwUtils();
    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.get(str);
        driver.manage().window().maximize();
        System.out.println("selenium");

    }
    @Test(description = "首次启动百度搜索页",priority = 1)
    public void defaultUi() throws InterruptedException{
//        driver.findElement(By.id("kw")).sendKeys("selenium java");
//        driver.findElement(By.id("su")).click();
        base.findByidsend(driver,"kw","selenium java");
        base.findByidClick(driver,"su");
        Thread.sleep(5000);
//        driver.close();
    }
    @Test(description = "书架-追漫默认页",priority = 2)
    public void addPage() throws InterruptedException{
        base.findByidsend(driver,"kw","java");
        base.findByidClick(driver,"su");
        Thread.sleep(5000);
    }

    @Test(description = "书架-历史默认页",priority = 3)
    public void historyPage() throws InterruptedException {
        base.findByidsend(driver,"kw","selenium");
        base.findByidClick(driver,"su");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void teardown() throws IOException {
        if (null != driver) {
            driver.quit();
        }
    }

}