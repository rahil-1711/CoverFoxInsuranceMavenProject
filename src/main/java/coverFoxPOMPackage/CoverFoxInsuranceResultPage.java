package coverFoxPOMPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxInsuranceResultPage {

	//webElement
	@FindBy(xpath= "//div[contains(text(),'Health Insurance Plans')]")   private WebElement matchingPlans;
	@FindBy(className = "plan-card-container")  private List<WebElement> banners;
	@FindBy(xpath = "//div[text()='Sort Plans']")private WebElement sortPlan;
	
	
	//constructor
	public CoverFoxInsuranceResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void resultOutput()
	{
		String mytext = matchingPlans.getText();
		System.out.println(mytext);
		String ar[]=mytext.split(" ");
		String str = ar[0];					//result is '50' but it is in string we need to convert it into interger
		int mystring=Integer.parseInt(str);		// convert string into integer
		int noOfContainer=banners.size();		// no of banners
		
		//optimization of above code
		
	//	 String ar1[]=matchingPlans.getText().split(" ");
	 //  	 int result = Integer.parseInt(ar1[0]);
	   	 
		//if (result==banners.size()) 
		
		
		
		if(mystring==noOfContainer)
		{
			System.out.println("Test case is passed");
		}
		else
		{
			System.out.println("Test case is failed");
		}
		
		
	}
	
	public int getPlanNumberFromString()
	{
		String ar[]=matchingPlans.getText().split(" ");
		int result = Integer.parseInt(ar[0]);
		Reporter.log("getting plans in string",true);
		return result;
	}
	
	public int getPlanNumberFromBanners()
	{
		int bannerSize = banners.size();
		Reporter.log("getting banner size",true);
		return bannerSize;
	}
	
	public boolean sortPlanDisplayed()
	{
		boolean displaySort = sortPlan.isDisplayed();
		Reporter.log("validating sort button",true);
		return displaySort;
	}
	
	
}
