package coverFoxBasePackage;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

public class BaseClass {

	 static protected WebDriver driver;
	public void openBrowser()
	{
		FirefoxOptions opt= new FirefoxOptions();			// it can chromeoptions 
		opt.addArguments("--disable-notifications");
		driver= new FirefoxDriver(opt);						// driver should be chrome driver
		driver.manage().window().maximize();
		driver.get("https://www.coverfox.com/");
		Reporter.log("launching browser",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		Reporter.log("waiting.....",true);
		
		
	}
	
	public void browserClose() throws InterruptedException
	{	Reporter.log("closing browser",true);
		Thread.sleep(1000);
		driver.close();
	}
	
	
	
	
}
