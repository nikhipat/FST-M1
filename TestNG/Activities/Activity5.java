package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity5 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://v1.training-support.net/selenium/target-practice");

    }

    @Test(groups = {"HeaderTests","ButtonTests"})
    public void verifyTitle() {
        Assert.assertEquals(driver.getTitle(), "Target Practice", "verify title of home page");
        Reporter.log("Title of page is: Target Practice");
    }

    @Test(groups = {"HeaderTests"}, dependsOnMethods = {"verifyTitle"})
    public void HeaderCheck() {

        Assert.assertEquals(driver.findElement(By.id("third-header")).getText(), "Third header", "verify third Header text");
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.ui")).getCssValue("color"), "rgb(33, 186, 69)", "this is green color");

    }

    @Test(groups = {"ButtonTests"}, dependsOnMethods = {"verifyTitle"})
    public void ButtonCheck() {
        Assert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,'olive')]")).getText(), "Olive", "verify button is olive");
        Assert.assertEquals(driver.findElement(By.xpath("//button[contains(@class,'brown')]")).getCssValue("color"), "rgb(255, 255, 255)", "verify color is brown");

    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.close();

    }
}
