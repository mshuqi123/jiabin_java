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
public class youxTest extends AwUtils{
//    private WebDriver driver;
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
//        getDrive();
        System.out.println("selenium");
    }
    @Test(groups = {"qidongUi","BaseTest"},description = "首次启动163邮箱",priority = 1)
    public void qidongUi() throws InterruptedException{
//        driver.findElement(By.id("kw")).sendKeys("selenium java");
        findElementByIdAndClearSendkeys("fromStationText","北京");
        findElementByXpathAndClick("//*[@id='citem_2']");
        Thread.sleep(5000);
//        driver.close();
    }
    @Test(groups = {"shuruTest","BaseTest"},description = "输入地址",priority = 2)
    public void shuruTest() throws InterruptedException{
        findElementByIdAndClearSendkeys("fromStationText","上海");
        findElementByXpathAndClick("//*[@id='citem_2']");
        Thread.sleep(5000);
        driver.close();
    }
//    @AfterMethod
//    public void teardown() throws IOException {
//        if (null != driver) {
//            driver.quit();
//        }
//    }
}