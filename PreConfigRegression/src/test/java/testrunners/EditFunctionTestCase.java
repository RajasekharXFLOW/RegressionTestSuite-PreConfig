package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="featurefiles/editfunction.feature",glue="stepdefinitions",dryRun=true,
plugin={"com.cucumber.listener.ExtentCucumberFormatter:reports/editfunctionresults.html"})
public class EditFunctionTestCase 
{
	
}
