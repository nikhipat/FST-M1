package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {
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
        Assert.assertEquals(driver.getTitle(),"Alchemy LMS – An LMS Application","To check Title of the page");

    }
    @AfterClass
    public void tearDown(){
        driver.close();

    }
}