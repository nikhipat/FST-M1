package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity19 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Title of the page is: "+driver.getTitle());

        driver.findElement(By.id("confirm")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        System.out.println("Alert text before accept is: "+alert.getText());
        alert.accept();

        driver.findElement(By.id("confirm")).click();

        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert2=driver.switchTo().alert();
        System.out.println("Alert text before dismiss is: "+alert.getText());
        alert.dismiss();

        driver.close();
    }
}
