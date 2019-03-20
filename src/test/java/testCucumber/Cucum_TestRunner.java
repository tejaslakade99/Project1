/**
 * 
 */
package testCucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author Pratik
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinition",
		//dryRun = true, // just checks if all steps are defined as per scenario or
		// not. nothing to execute.
		monochrome = true, // console output in readable format
		strict = true, // fails the script if any steps are pending or undefined
		plugin = { "pretty", "html:logs" }, // to format the output - console out - pretty format; html report output
		junit = "--step-notifications" // step status notification in junit tests

)
public class Cucum_TestRunner extends AbstractTestNGCucumberTests {

}
