package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(
		features = "/Users/urielflores/Documents/BenchPrepTech/PuppyAdoptionAgencyFramework/src/main/java/Features"
		,glue = {"StepDefinitions"}
		//format= {"pretty", "html:test-outout"}
		)

	public class TestRunner {
	
	}
