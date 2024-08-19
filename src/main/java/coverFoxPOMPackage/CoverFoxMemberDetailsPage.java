package coverFoxPOMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPage {

	//webElement
	@FindBy(id = "Age-You")private WebElement AgeDropDown;
	@FindBy(className = "next-btn")  private WebElement next_Button;
	
	//constructor
	public CoverFoxMemberDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//method
	
	public void handlePageDropDown(String age)
	{
		Select s= new Select(AgeDropDown);
		Reporter.log("handling age dropdown",true);
		s.selectByValue(age+"y");
	}
	public void nextButton()
	{
		Reporter.log("clicking on next button",true);
		next_Button.click();
	}
}
