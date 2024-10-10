package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "resource/features/",
		glue = "StepDefiniations",
		plugin = {"pretty","html:target/cucumberReport.html","json:cucumber.json"},
		monochrome = true
		)
public class LoginRunner extends AbstractTestNGCucumberTests {

}
