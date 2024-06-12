package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println(driver.findElement(By.id("dynamicCheckbox")).isDisplayed());
        driver.findElement(By.id("dynamicCheckbox")).click();
        driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println(driver.findElement(By.id("dynamicCheckbox")).isDisplayed());

        driver.close();
    }
}
