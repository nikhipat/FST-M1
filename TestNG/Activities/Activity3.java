package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        Reporter.log("Open the Webpage");
    }

    @Test
    public void tasks(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("action-confirmation")).getText(),"Welcome Back, admin","login confirmation");
        Reporter.log("User logged in");
    }

    @AfterClass
    public void Clean() {
        driver.close();
        Reporter.log("Close the browser");
    }
}
