package Projects;

import Activities.W3CActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;

import static Activities.W3CActionsBase.doSwipe;

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set calculator app details from inspectAPp command lines
        UiAutomator2Options caps=new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main")
                .noReset();
        //Set Server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        //Initialize Android driver
        driver=new AndroidDriver(serverURL,caps);
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://v1.training-support.net/selenium");
    }
    @Test
    public void formTest(){
        Dimension dims=driver.manage().window().getSize();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

        Point start=new Point((int)(dims.getWidth()*0.5), (int)(dims.getHeight()*0.8));
        Point end=new Point((int)(dims.getWidth()*0.5), (int)(dims.getHeight()*0.3));

        doSwipe(driver,start,end,200);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Log in']")));

        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Welcome Back, admin']")).getText(),"Welcome Back, admin");

        //android.widget.EditText[@text="admin"]
        //android.widget.EditText[@text="password"]

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='admin']")).clear();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='password']")).clear();

        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")).sendKeys("passwo");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Invalid Credentials']")).getText(),"Invalid Credentials");

    }
}
