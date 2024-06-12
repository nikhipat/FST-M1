package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity21 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://v1.training-support.net/selenium/tab-opener");
        System.out.println("Title of the page is: "+driver.getTitle());

        driver.findElement(By.id("launcher")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("All window handles are: "+driver.getWindowHandles());

        for (String newtab:driver.getWindowHandles()){
            driver.switchTo().window(newtab);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        System.out.println("New tab title is: "+driver.getTitle());
        System.out.println("New tab opened: "+driver.findElement(By.xpath("//div[contains(@class,\"sub\")]")).getText());
        driver.findElement(By.id("actionButton")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        System.out.println("All window handles are: "+driver.getWindowHandles());

        for (String newtab:driver.getWindowHandles()){
            driver.switchTo().window(newtab);
        }
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class=\"sub header\"]"),"You've successfully opened another new Tab!"));
        System.out.println("New tab title is: "+driver.getTitle());
        System.out.println("New tab opened: "+driver.findElement(By.xpath("//div[contains(@class,\"sub\")]")).getText());

        //driver.switchTo().parentFrame().close();
        //driver.switchTo().defaultContent().close();
        //System.out.println(driver.getWindowHandle());
        //driver.switchTo().

        driver.close();

    }
}
