package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//button[@class=\"ui violet button\"]")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        String text=driver.findElement(By.xpath("//div[@id=\"ajax-content\"]/h1")).getText();
        System.out.println(text);
        String text2=driver.findElement(By.xpath("//div[@id=\"ajax-content\"]/h3")).getText();
        System.out.println("Before wait text is: "+text2);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"),"I'm late!"));
        String text3=driver.findElement(By.xpath("//div[@id=\"ajax-content\"]/h3")).getText();
        System.out.println("After wait text is: "+text3);

        driver.close();
    }
}
