package activities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Activity6 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println(driver.getTitle());

        builder.sendKeys("N").build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        driver.close();
    }
}
