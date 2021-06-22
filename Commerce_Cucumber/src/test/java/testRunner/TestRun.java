package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
	(
			features = ".//Features/Costumers.feature",
			glue = {"stepDefinitions", "MyHooks"},
			dryRun = false,
			monochrome=true,
			stepNotifications = true,
			publish = true,
			plugin = {"pretty", "html:test-output"}
			)

public class TestRun {

}
