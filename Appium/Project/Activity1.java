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

public class Activity1 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set calculator app details from inspectAPp command lines
        UiAutomator2Options caps=new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.google.android.apps.tasks")
                .setAppActivity(".ui.TaskListsActivity")
                .noReset();
        //Set Server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        //Initialize Android driver
        driver=new AndroidDriver(serverURL,caps);
    }

    @Test
    public void tasksTest(){
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        Assert.assertEquals(driver.findElements(AppiumBy.className("android.widget.TextView")).size(),7);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
