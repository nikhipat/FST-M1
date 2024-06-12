package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        Actions builder=new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println(driver.getTitle());

        WebElement ball=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement box1=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
        builder.dragAndDrop(ball,box1).build().perform();
        WebElement check=driver.findElement(By.cssSelector("#droppable"));
        System.out.println(check.getCssValue("background-color"));

        WebElement box2=driver.findElement(By.xpath("//*[@id=\"dropzone2\"]"));
        builder.dragAndDrop(ball,box2).build().perform();
        String check2=driver.findElement(By.cssSelector("#dropzone2 > p:nth-child(1)")).getText();
        System.out.println(check2);
        if (check2.equals("Dropped!")){
            System.out.println("Ball is dropped to box2");
        }

        driver.close();
    }
}
