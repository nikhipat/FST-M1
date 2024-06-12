package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of the page is: "+driver.getTitle());
        driver.findElement(By.xpath("//input[contains(@class,\"-username\")]")).sendKeys("Nikhil");
        driver.findElement(By.xpath("//input[contains(@class,\"-password\")]")).sendKeys("Password");
        driver.findElement(By.xpath("//label[text()=\"Confirm Password\"]/following-sibling::input")).sendKeys("Password");
        driver.findElement(By.xpath("//input[starts-with(@class,\"email-\")]")).sendKeys("nikhil@gmail.com");
        driver.findElement(By.xpath("//button[@onclick=\"signUp()\"]")).click();

        System.out.println("Sign up confirmation message is: "+driver.findElement(By.id("action-confirmation")).getText());
        driver.close();
    }
}
