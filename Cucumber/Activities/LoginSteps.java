package stepDefinations;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps extends BaseClass{
    @BeforeAll
    public static void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("the user is on the login page")
    public void openPage(){
        driver.get("https://v1.training-support.net/selenium/login-form");

        Assertions.assertEquals("Login Form",driver.getTitle(),"Get title of the page after login");

    }
    @When("the use enters the username and password")
    public void getCredentials(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

    }
    @When("the use enters the {string} and {string}")
    public void getuserCredentials(String username,String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

    }
    @And("the user clicks on submit button")
    public void clickSubmit(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Then("Verify the login message")
    public void verifyLoginMsg(){

        Assertions.assertEquals("Welcome Back, admin",driver.findElement(By.id("action-confirmation")).getText(),"assert to check login verification msg");
    }
    @Then("Verify the login message as {string}")
    public void verifyuserLoginMsg(String msg){

        Assertions.assertEquals(msg,driver.findElement(By.id("action-confirmation")).getText(),"assert to check login verification msg");
    }
    @AfterAll
    public static void closeTheBrowser(){
        driver.quit();
    }


}
