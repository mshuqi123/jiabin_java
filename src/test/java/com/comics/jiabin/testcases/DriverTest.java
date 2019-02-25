package com.comics.jiabin.testcases;

import com.comics.jiabin.BaseUtil.ConfigManagerUtil;
import com.comics.jiabin.awutils.AwUtils;
import com.comics.jiabin.awutils.DriverBase;
import io.github.bonigarcia.wdm.WebDriverManager;
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
public class DriverTest{
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
    @Test(groups = {"qidongUi","BaseTest"},description = "首次启动163邮箱",priority = 1)
    public void qidongUi() throws InterruptedException{
        base.findByidsend(driver,"kw","马树起");
        base.findByidClick(driver,"su");
        Thread.sleep(5000);
    }
    @Test(groups = {"shuruTest","BaseTest"},description = "输入地址",priority = 2)
    public void shuruTest() throws InterruptedException{
        base.findByidsend(driver,"kw","张艳虹");
        base.findByidClick(driver,"su");
        Thread.sleep(5000);
//        driver.close();
    }
    @AfterMethod
    public void teardown() throws IOException {
        if (null != driver) {
            driver.quit();
        }
    }
}