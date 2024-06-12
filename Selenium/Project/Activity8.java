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

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test(testName = "start", groups = "fill form")
    public void check() {
        Assert.assertEquals(driver.getTitle(), "Alchemy LMS – An LMS Application", "To check Title of the page");
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/contact/\"]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class=\"uagb-ifb-title\"]"))));
    }

    @Test(dependsOnMethods = "check", groups = "fill form")
    public void fillForm() {
        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Nikhil Patil");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("nikhipat@in.ibm.com");
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Testing");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Added all details");
        driver.findElement(By.id("wpforms-submit-8")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("wpforms-confirmation-8"))));

        Assert.assertEquals(driver.findElement(By.id("wpforms-confirmation-8")).getText(), "Thanks for contacting us! We will be in touch with you shortly.", "verify form is submitted");
        System.out.println("Confirmation message is: "+driver.findElement(By.id("wpforms-confirmation-8")).getText());
    }

    @AfterClass
    public void tearDown() {
        driver.close();

    }
}
