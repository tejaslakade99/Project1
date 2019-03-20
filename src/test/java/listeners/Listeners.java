/**
 * 
 */
package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import automation.Practise_Project1.TestBase;
import stepDefinition.StepDefinition_QAClick;

/**
 * @author Pratik
 *
 */
public class Listeners implements ITestListener {

	//TestBase tb = new TestBase();
	
	//For Cucumber
	StepDefinition_QAClick sdQ = new StepDefinition_QAClick();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// call getScreenshot

		//tb.getScreenshot(result.getName());
		//sdQ.getScreenshot();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// call getScreenshot

	//	tb.getScreenshot(result.getName());
		//sdQ.getScreenshot();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
