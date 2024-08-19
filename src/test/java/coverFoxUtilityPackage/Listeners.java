package coverFoxUtilityPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxBasePackage.BaseClass;

public class Listeners extends BaseClass implements ITestListener
{
	// extended to Baseclass because we want driver from from that class
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" this test case is started",true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("test case "+result.getName()+" is failed",true);
		try {
			Utility3.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
