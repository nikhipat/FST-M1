package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the page is: "+driver.getTitle());

        boolean before=driver.findElement(By.id("input-text")).isEnabled();
        System.out.println("Is checkbox enabled?: "+before);
        driver.findElement(By.id("toggleInput")).click();
        boolean after=driver.findElement(By.id("input-text")).isEnabled();
        System.out.println("Is checkbox enabled?: "+after);

        driver.close();
    }
}
