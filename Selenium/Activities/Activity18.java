package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity18 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title of the page is: "+driver.getTitle());
        WebElement multi=driver.findElement(By.id("multi-select"));

        Select dropdown=new Select(multi);
        dropdown.selectByVisibleText("Javascript");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByIndex(4);
        dropdown.selectByIndex(5);
        dropdown.selectByIndex(6);
        dropdown.selectByValue("node");
        dropdown.deselectByIndex(5);

        List<WebElement> options=dropdown.getAllSelectedOptions();
        System.out.println("All selections are: ");

        for(WebElement values:options){
            System.out.println(values.getText());
        }

        driver.close();

    }
}
