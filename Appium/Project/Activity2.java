package Projects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set calculator app details from inspectAPp command lines
        UiAutomator2Options caps=new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.google.android.keep")
                .setAppActivity(".activities.BrowseActivity")
                .noReset();
        //Set Server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        //Initialize Android driver
        driver=new AndroidDriver(serverURL,caps);
        wait=new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    @Test
    public void keepTest(){
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Pin")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("check1");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("check");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New text note")));

        Assert.assertEquals(driver.findElements(AppiumBy.className("android.widget.LinearLayout")).size(),27);
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\" and @text=\"check1\"]")).isDisplayed(),true);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
