package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Activity17 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title of the page is: "+driver.getTitle());
        WebElement dropdowncheck = driver.findElement(By.id("single-select"));
        Select dropdown = new Select(dropdowncheck);

        dropdown.selectByVisibleText("Option 2");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("4");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        for (WebElement option : dropdown.getOptions()) {
            System.out.println(option.getText());
        }

        driver.close();
    }
}
