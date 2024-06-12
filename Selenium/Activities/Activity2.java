package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Activity2 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"password\" and @type=\"password\"]")).sendKeys("password");
        driver.findElement(By.xpath("//*[@onclick=\"signIn()\" and @type=\"submit\"]")).click();

        System.out.println(driver.getTitle());

        driver.close();
    }
}
