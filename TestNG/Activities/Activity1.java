package Activities;

import jdk.jfr.Enabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @Test
    public void tasks() {
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Target Practice");
        Reporter.log("verified title");
    }

    @Test
    public void task2() {
        Assert.assertEquals(driver.findElement(By.cssSelector(".black")).getText(), "expected");
    }

    @Test(enabled = false)
    public void task3() {
        Assert.assertEquals(driver.findElement(By.cssSelector(".black")).getText(), "expected");
    }
    @Test
    public void task4() {
        throw new RuntimeException("This test case is skipped");
    }

    @BeforeClass
    public void SetUp() {
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        Reporter.log("Open the Webpage");
    }

    @AfterClass
    public void Clean() {
        driver.close();
        Reporter.log("Close the browser");
    }

}
