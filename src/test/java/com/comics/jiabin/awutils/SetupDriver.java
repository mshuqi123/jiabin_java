package com.comics.jiabin.awutils;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import com.comics.jiabin.awutils.WebDriverManager;
public class SetupDriver{
    WebDriver driver;
    public SetupDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\moxiu\\his_test_case_pom\\tools\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.baidu.com");
        //窗口最大化
        driver.manage().window().maximize();
    }
}