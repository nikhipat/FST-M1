package Activities;

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

import java.time.Duration;
import java.util.List;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        driver=new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.get("https://alchemy.hguy.co/lms/");
    }
    @Test(groups = "course", testName = "start")
    public void check(){
        Assert.assertEquals(driver.getTitle(),"Alchemy LMS – An LMS Application","To check Title of the page");
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/all-courses/\"]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class=\"uagb-ifb-title\"]"))));
        driver.findElement(By.xpath("(//a[@class=\"btn btn-primary\"])[1]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href=\"#login\"]"))));

    }
    @Test(groups = "course", dependsOnMethods = "check")
    public void logIn(){
        driver.findElement(By.xpath("//a[@href=\"#login\"]")).click();
        String newhandle=driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());
        driver.switchTo().window(newhandle);
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
    }
    @Test(groups = "course",dependsOnMethods = "logIn")
    public void fullCourse(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ld-section-heading > h2"))));
        driver.findElement(By.xpath("(//span[@class=\"ld-text ld-primary-color\"])[1]")).click();

        System.out.println("Course status is: "+driver.findElement(By.xpath("(//span[@class=\"ld-lesson-list-progress\"])[1]")).getText());
        driver.findElement(By.xpath("//div[@id=\"ld-table-list-item-175\"]")).click();
        wait.until(ExpectedConditions.urlContains("topic/this-is-the-first-topic/"));
        Assert.assertEquals(driver.getTitle(),"This is the First Topic – Alchemy LMS","Verify Course page title");

        System.out.println("Course status is: "+driver.findElement(By.xpath("//div[@class=\"ld-status ld-status-complete ld-secondary-background\"]")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"ld-status ld-status-complete ld-secondary-background\"]")).getText(),"COMPLETE");
    }
    @AfterClass
    public void tearDown(){
        driver.close();

    }
}
