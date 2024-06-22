package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1_ {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set calculator app details from inspectAPp command lines
        UiAutomator2Options caps=new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.vivo.calculator")
                .setAppActivity(".Calculator")
                .noReset();
        //Set Server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        //Initialize Android driver
        driver=new AndroidDriver(serverURL,caps);
    }

    @Test
    public void multiplytest(){
        driver.findElement(AppiumBy.id("com.vivo.calculator:id/digit_7")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiply")).click();
        driver.findElement(AppiumBy.id("com.vivo.calculator:id/digit_6")).click();
        driver.findElement(AppiumBy.id("com.vivo.calculator:id/eq")).click();

        Assert.assertEquals(driver.findElement(AppiumBy.id("com.vivo.calculator:id/formula")).getText(),"42");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
