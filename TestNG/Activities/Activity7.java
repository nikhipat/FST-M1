package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver=new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @DataProvider(name ="dataSetup")
    public Object [][] credentials(){
        return new Object[][]{
                {"admin","password","Welcome Back, admin"},
                {"admin1","password12","Invalid Credentials"}
        };
    }
    @Test(testName ="title")
    public void check(){
        System.out.println(driver.getTitle());

    }
    @Test(dataProvider="dataSetup")
    public void login(String username,String password,String msg){
        WebElement Fieldusername=driver.findElement(By.id("username"));
        WebElement Fieldpassword=driver.findElement(By.id("password"));
        WebElement Fieldlogin=driver.findElement(By.xpath("//button[@onclick=\"signIn()\"]"));
        WebElement verifymsg=driver.findElement(By.id("action-confirmation"));

        Fieldusername.clear();
        Fieldpassword.clear();

        Fieldusername.sendKeys(username);
        Fieldpassword.sendKeys(password);
        Fieldlogin.click();

        Reporter.log("Entered username and password");

        Assert.assertEquals(verifymsg.getText(),msg,"Assertions to verify msg");

    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
