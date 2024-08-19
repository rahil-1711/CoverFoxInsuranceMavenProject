package coverFoxUtilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility3 {
	
	
	
	//TAKE SCREEN SHOT
	
	public static void takeScreenShot(WebDriver driver, String filename) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Reporter.log("taking screenshot",true);
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File destFile=new File(	System.getProperty("user.dir")+"\\screenshots\\"+filename+timeStamp+".jpg");
		FileHandler.copy(src, destFile);
		Reporter.log("saving file at location"+destFile,true);
	}
	
	// READ EXCEL SHEET DATA SIMULTANEOUSLY USING SENDKEYS
	
	public static String readExcel(String filepath, String Sheetname,int rowNo,int cellNO) throws EncryptedDocumentException, IOException
	{
		FileInputStream myfile= new FileInputStream(filepath);
		Reporter.log("reading data from excel file",true);
		String value = WorkbookFactory.create(myfile).getSheet(Sheetname).getRow(rowNo).getCell(cellNO).getStringCellValue();
		return value;
		}
	
	// for using properties file we need to create static method
	
		public static String readExcelDataFromPropertiesFile(String key) throws IOException
		{
			String filePath = System.getProperty("user.dir")+"//FbTest.properties";
			FileInputStream myFile= new FileInputStream(filePath);
			Properties prop= new Properties();
			prop.load(myFile);
			Reporter.log("reading data from properties file"+key,true);
			String value = prop.getProperty(key);
			return value;
			
		}

}
