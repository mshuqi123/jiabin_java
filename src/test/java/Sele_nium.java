import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
public class Sele_nium {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("selenium");
//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("kw")).sendKeys("selenium java");
        driver.findElement(By.id("su")).click();
        Thread.sleep(5000);
        driver.close();
    }
}
