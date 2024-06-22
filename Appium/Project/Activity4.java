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

public class Activity4 {
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
    public void gestureTest(){
        Dimension dims=driver.manage().window().getSize();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

        Point start=new Point((int)(dims.getWidth()*0.5), (int)(dims.getHeight()*0.8));
        Point end=new Point((int)(dims.getWidth()*0.5), (int)(dims.getHeight()*0.5));

        doSwipe(driver,start,end,80);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")));
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//        for (String newTab:driver.getWindowHandles()){
//            driver.switchTo().window(newTab);
//        }

        //System.out.println("Total open tabs are: "+driver.getWindowHandles());

        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Task1");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Task2");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        Assert.assertEquals(driver.findElements(AppiumBy.className("android.widget.EditText")).size(),2);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Task1']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Task2']")).click();

        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Todo List']/android.view.View/android.view.View/android.view.View[3]")).click();

    }
}
