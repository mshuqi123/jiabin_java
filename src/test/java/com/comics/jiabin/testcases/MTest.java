package com.comics.jiabin.testcases;

//import static org.hamcrest.CoreMatchers.containsString;
//import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

/**
 * Test with TestNG in parallel.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class MTest {
    private WebDriver driver;
    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void testChrome() {
        driver = new ChromeDriver();
        driver.get("https://www.12306.cn/index/");
//        assertThat(System.getProperty("webdriver.chrome.driver"),
//                containsString("chromedriver"));
    }
    @AfterMethod
    public void teardown() throws IOException {
        if (null != driver) {
            driver.quit();
        }
    }

}
