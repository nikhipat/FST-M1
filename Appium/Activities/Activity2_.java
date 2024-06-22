package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2_ {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set calculator app details from inspectAPp command lines
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.chrome");
        caps.setAppActivity("com.google.android.apps.chrome.Main");
        caps.noReset();
        //Set Server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        //Initialize Android driver
        driver=new AndroidDriver(serverURL,caps);
    }

    @Test
    public void browserTest(){
        driver.get("https://v1.training-support.net/");
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Training Support\"]")).getText(),"Training Support");
        driver.findElement(AppiumBy.id("00000000-0000-0198-0000-00060000005e")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).getText();
    }

//    @AfterClass
//    public void tearDown(){
//       driver.quit();
//    }
}
