package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class Activity6 {
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
        driver.findElement(By.xpath("//a[@href=\"#login\"]")).click();

        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//a[@href=\"#login\"]"))));
        //Alert alert=driver.switchTo().alert();
        String newhandle=driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());
        driver.switchTo().window(newhandle);
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ld-section-heading > h3"))));
        Assert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"display-name\"])[1]")).getText(),"root","Verify root is logged in");
    }
    @AfterClass
    public void tearDown(){
        driver.close();

    }
}
