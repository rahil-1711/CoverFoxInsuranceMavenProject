package coverFoxPOMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {

	// webElement
	@FindBy(className = "mp-input-text")
	private WebElement pincodeField;
	@FindBy(id = "want-expert")
	private WebElement mobileNoField;
	@FindBy(className = "next-btn")
	private WebElement next_button;

	// constructor
	public CoverFoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// methods
	public void sendPincode(String pincode) {
		Reporter.log("entering pincode",true);
		pincodeField.sendKeys(pincode);
	}

	public void sendMobileNO(String mobileNo) {
		Reporter.log("entering mobile no",true);
		mobileNoField.sendKeys(mobileNo);
	}

	public void clickOnContinue() {
		Reporter.log("clicking on next button",true);
		next_button.click();
	}

}
