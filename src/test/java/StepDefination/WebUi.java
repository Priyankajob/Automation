package StepDefination;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.asserts.SoftAssert;
//import org.openqa.selenium.screenshot.Screenshot;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebUi {

    WebDriver driver = new ChromeDriver();



    @Given("Open URL")
    public void openURL()
    {
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("First time Browser Login");

    }

    @When("Login with Credentials")
    public void Login()
    {   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name ='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @name ='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit' and @class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        String Logintext = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
        Assert.assertEquals(Logintext,"Dashboard");

    }




}
