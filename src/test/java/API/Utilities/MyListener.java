package API.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListener implements ITestListener {

	ExtentReports extentreporter;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		extentreporter = ExtentReport.generateExtentReport();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentreporter.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName()+ "Started Executing");
		System.out.println("Started Executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName()+" got Successfully executed");
		System.out.println("Got Successfully Executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.log(Status.FAIL, result.getName()+" Got Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.SKIP, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" Got skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentreporter.flush();
		System.out.println(" Got Finished");
	}
}
