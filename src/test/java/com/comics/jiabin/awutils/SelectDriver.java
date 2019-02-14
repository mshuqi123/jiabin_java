package com.comics.jiabin.awutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//选择浏览器类型的类
public class SelectDriver {

    public WebDriver driverName() {
        return new ChromeDriver();
    }
}
