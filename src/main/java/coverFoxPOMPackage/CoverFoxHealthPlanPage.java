package coverFoxPOMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {

	//webElement
	@FindBy(className = "next-btn") private WebElement next_Button;
	
	
	//constructor
	public CoverFoxHealthPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//method
	public void clickOnNextButton()
	{
		Reporter.log("clicking on next button",true);
		next_Button.click();
	}
	
	
	

}
