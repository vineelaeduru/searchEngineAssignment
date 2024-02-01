package com.myassignment.testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/cucumberFeatureFiles/validateSearch.feature", glue = "com.myassignment.stepDefinitions", tags = "@SearchTest", plugin = {
		"pretty", "html:target/testReport.html" }, monochrome = true)
public class validateSearchTestRunner {

}
