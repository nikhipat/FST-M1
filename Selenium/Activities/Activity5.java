package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Activity5 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println(driver.getTitle());

        WebElement first=driver.findElement(By.className("active"));
        first.click();
        System.out.println("First click: "+driver.findElement(By.className("active")).getText());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        builder.doubleClick(first).build().perform();
        System.out.println("After double click: "+first.getText());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        builder.contextClick(first).build().perform();
        System.out.println("After right click: "+first.getText());

        driver.close();
    }
}
