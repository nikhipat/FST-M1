package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        driver=new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.get("https://alchemy.hguy.co/lms/");
    }
    @Test
    public void check(){
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/my-account/\"]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href=\"#login\"]"))));
        System.out.println("My Account home page Title is: "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"My Account – Alchemy LMS","Verify My Account page title");
    }
    @AfterClass
    public void tearDown(){
        driver.close();

    }
}
