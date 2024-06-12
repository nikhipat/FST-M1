package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity13 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title of the page is: "+driver.getTitle());
        List<WebElement> cols = driver.findElements(By.xpath("//table[@class=\"ui celled striped table\"]/tbody/tr/td"));
        System.out.println("Number of columns: " + cols.size());
        List<WebElement> row = driver.findElements(By.xpath("//table[@class=\"ui celled striped table\"]/tbody/tr"));
        System.out.println("Number of rows: " + row.size());

        List<WebElement> row3 = driver.findElements(By.xpath("//table[@class=\"ui celled striped table\"]/tbody/tr[3]/td"));
        System.out.println("Row3 elements are: ");
        for (WebElement values:row3){
            System.out.println(values.getText());
        }

        System.out.println("value of second row second column is: "+driver.findElement(By.xpath("//table[@class=\"ui celled striped table\"]/tbody/tr[2]/td[2]")).getText());

        driver.close();
    }
}
