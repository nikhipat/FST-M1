package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title of the page is: "+driver.getTitle());

        List<WebElement> table2col = driver.findElements(By.xpath("//table[@id=\"sortableTable\"]/thead/tr/th"));
        System.out.println("Table2 column size is: "+table2col.size());
        List<WebElement> table2row = driver.findElements(By.xpath("//table[@id=\"sortableTable\"]/tbody/tr"));
        System.out.println("Table2 column size is: "+table2row.size());
        System.out.println("Value of cell2 is: "+driver.findElement(By.xpath("//table[@id=\"sortableTable\"]/tbody/tr[2]/td[2]")).getText());
        driver.findElement(By.xpath("//table[@id=\"sortableTable\"]/thead/tr/th[1]")).click();
        System.out.println("Sorted Value of cell2 is: "+driver.findElement(By.xpath("//table[@id=\"sortableTable\"]/tbody/tr[2]/td[2]")).getText());
        System.out.println("Table2 footer values are: ");
        List<WebElement> footer=driver.findElements(By.xpath("//table[@id=\"sortableTable\"]/tfoot/tr/th"));
        for(WebElement footervalues:footer){
            System.out.println(footervalues.getText());
        }

        driver.close();

    }
}
