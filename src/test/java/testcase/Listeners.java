package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.Base;
import resource.ExtentReporterNG;


public class Listeners extends Base implements ITestListener {
	static ExtentTest test;

	ExtentReports extent = ExtentReporterNG.getReportObject();
       ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;
		
		
		
		extentTest.get().fail(result.getThrowable());
		
		
		
		String testcaseName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}
		try {extentTest.get().addScreenCaptureFromPath(getScreenshotpath(testcaseName, driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.get().log(Status.PASS, "test got passed");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();
		// TODO Auto-generated method stub
	}

}