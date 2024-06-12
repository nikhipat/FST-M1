package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println(driver.getTitle());

        String check1=driver.findElement(By.xpath("//*[@id=\"third-header\"]")).getText();
        System.out.println("3rd Header text is: "+check1);

        String check2=driver.findElement(By.xpath("//*[@class=\"ui green header\"]")).getCssValue("color");
        System.out.println("5th Header color is:"+check2);

        String check3=driver.findElement(By.cssSelector(".violet")).getAttribute("Class");
        System.out.println("All classes names are: "+check3);

        String check4=driver.findElement(By.cssSelector(".grey")).getText();
        System.out.println("Grey button text is: "+check4);

        driver.close();
    }
}
