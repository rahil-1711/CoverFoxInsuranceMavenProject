package coverFoxPOMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
	
	//webElement (data member)
	@FindBy(xpath = "//div[text()='Male']")private WebElement maleButton;
	
	
	//Constructor
	public CoverFoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Method
	public void clickOnGendrButton()
	{
		Reporter.log("clicking on next button",true);
		maleButton.click();
	}
	

}
