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

public class Activity7 {
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
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/all-courses/\"]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class=\"uagb-ifb-title\"]"))));
        List<WebElement> courses=driver.findElements(By.xpath("//h3[@class=\"entry-title\"]"));
        System.out.println("Total number of courses are: "+courses.size());

        for (WebElement courseitems:courses){
            System.out.println("Course name is: "+courseitems.getText());
        }
    }
    @AfterClass
    public void tearDown(){
        driver.close();

    }
}
