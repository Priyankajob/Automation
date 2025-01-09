package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Hook {

    WebDriver driver;
    public static String apiVersion;

    @Before
    public void setUpTestNG(@NotNull Scenario scenario) {
        apiVersion = "/api";
        System.out.println("This runs before each scenario: " + scenario.getName());
    }

    @After
    public void tearDownTestNG(@NotNull Scenario scenario) {
        System.out.println("This runs after each scenario: " + scenario.getName());
    }

    @AfterMethod
    public void Takes_Screenshot() {
        File Src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(Src, new File("C:/Users/user/IdeaProjects/RestBDDFramework/error.png"));
            System.out.println("Screenshotsaved");

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}