package activities;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title fo the page is: "+driver.getTitle());
        System.out.println("Checkbox status is: "+driver.findElement(By.id("dynamicCheckbox")).isSelected());
        driver.findElement(By.id("dynamicCheckbox")).click();
        System.out.println("Checkbox status after click is: "+driver.findElement(By.id("dynamicCheckbox")).isSelected());

        driver.close();
    }

}
