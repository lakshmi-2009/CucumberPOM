package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/salesforceFeature.feature"},
		glue = {"com.automation.steps"},
		monochrome = true,
		dryRun = false
			
			)
	public class SalesforceRunner extends AbstractTestNGCucumberTests {
		
		
}
