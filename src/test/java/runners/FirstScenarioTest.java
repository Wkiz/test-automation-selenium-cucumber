package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
	
@RunWith(Cucumber.class) 
@CucumberOptions(
	plugin = {"pretty"},
	features = "src/test/resources/features/google_homepage_search.feature",
	glue = {"Definitions"},
	tags = "@FirstScenario",
	monochrome = true)
public class FirstScenarioTest {}