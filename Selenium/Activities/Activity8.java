package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());

        WebElement check=driver.findElement(By.xpath("//*[@class=\"willDisappear\"]"));
        check.click();
        WebElement box=driver.findElement(By.id("toggleCheckbox"));
        box.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        box.click();
        check.click();

        //System.out.println(check);

        driver.close();
    }
}
