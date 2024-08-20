package coverFoxTestPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import coverFoxBasePackage.BaseClass;
import coverFoxPOMPackage.CoverFoxAddressDetailsPage;
import coverFoxPOMPackage.CoverFoxHealthPlanPage;
import coverFoxPOMPackage.CoverFoxHomePage;
import coverFoxPOMPackage.CoverFoxInsuranceResultPage;
import coverFoxPOMPackage.CoverFoxMemberDetailsPage;
import coverFoxUtilityPackage.Utility3;

@Listeners(coverFoxUtilityPackage.Listeners.class)
public class TestExecutionUsingTestNg1 extends BaseClass{
	
	
	
	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxAddressDetailsPage addressDetailsPage;
	CoverFoxMemberDetailsPage memberDetailsPage;
	CoverFoxInsuranceResultPage resultPage;
	String filePath;
	public static Logger logger;
	
	@BeforeTest
	public void launchBrowser()
	{
		logger=Logger.getLogger("CoverFoxInsurance");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("opening browser");
		openBrowser();
		homePage= new CoverFoxHomePage(driver);
		healthPlanPage= new CoverFoxHealthPlanPage(driver);
		addressDetailsPage= new CoverFoxAddressDetailsPage(driver);
		memberDetailsPage= new CoverFoxMemberDetailsPage(driver);
		resultPage=new CoverFoxInsuranceResultPage(driver);
		filePath = System.getProperty("user.dir")+"\\New XLSX Worksheet.xlsx";
		
	}
	
	@BeforeClass
	public void preConditions() throws InterruptedException, EncryptedDocumentException, IOException
	{
		homePage.clickOnGendrButton();
		logger.info("clicking on gender button");
		
		Thread.sleep(1000);
		healthPlanPage.clickOnNextButton();
		logger.info("clicking on next button");
		Thread.sleep(1000);
		memberDetailsPage.handlePageDropDown(Utility3.readExcel(filePath, "Sheet5", 0, 0));
		logger.warn("enter age between 20-30 years");
		logger.info("handeling age drop down");
		memberDetailsPage.nextButton();
		logger.info("clicking on next button");
		Thread.sleep(1000);
		addressDetailsPage.sendPincode(Utility3.readExcel(filePath,"Sheet5", 0, 1));
		logger.warn("please enter valid pincode");
		logger.info("entering pin code");
		addressDetailsPage.sendMobileNO(Utility3.readExcel(filePath, "Sheet5", 0, 2));
		logger.warn("please enter valid mobile number");
		logger.info("entering mobile number");
		addressDetailsPage.clickOnContinue();
		logger.info("clicking on continue button");
		
	}
	
	
  @Test
  public void validateBanners() throws InterruptedException 
  
  {	
	//  Assert.fail();
	  Thread.sleep(4000);
	int stringPlanNum = resultPage.getPlanNumberFromString();	
	int bannerPlanNum = resultPage.getPlanNumberFromBanners();
	logger.info("validating banners");
	Assert.assertEquals(stringPlanNum, bannerPlanNum, "both are not matching , tc fails");
	  
  }
  
  @Test
  public void validateSortFilter() throws IOException, InterruptedException
  {
	  Thread.sleep(4000);
	  boolean sortFilterIsDisplayed = resultPage.sortPlanDisplayed();
	  logger.info("validating sort filter");
	  Assert.assertTrue(sortFilterIsDisplayed, " sort filter is not displayed , tc fails");
	 // Utility3.takeScreenShot(driver, "validateSortFilter");
	  //(I (Manisha)  just commented the above screenshot line,please check and confirm)
	  //...
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException
  {
	  logger.info("closing browser");
	  browserClose();
  }
  
  
  
}
