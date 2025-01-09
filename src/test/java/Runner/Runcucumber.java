package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Test.feature",  // Path to the feature files
        glue = "StepDefination",  // Path to the step definition package
        plugin = {"pretty", "html:target/cucumber-reports.html"},  // Optional plugins for report generation
        tags = "@Test",  // Optional tag to filter scenarios
        monochrome = true   // Set to true for more readable console output
)
public class Runcucumber extends AbstractTestNGCucumberTests {
    // This class is used to link TestNG and Cucumber together for running the tests
}
