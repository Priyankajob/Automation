package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Hook {

    @Before
    public void setUpTestNG(@NotNull Scenario scenario) {
        System.out.println("This runs before each scenario: " + scenario.getName());
    }

    @After
    public void tearDownTestNG(@NotNull Scenario scenario) {
        System.out.println("This runs after each scenario: " + scenario.getName());
    }
}