package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	
	//Author Name= Nitish
	//This method is use to get the test data from excel sheet
	//Need to pass 2 inputs: 1:rowIndex  2:colIndex
	public static String getTD(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\30AprMumSeleniumMaven\\TestData\\sampleSheet.xlsx");
		
		Sheet Sh = WorkbookFactory.create(file).getSheet("DDF");
		String value = Sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}
	
	public static void CaptureSS(WebDriver driver, int TCID) throws IOException
	{
		File Src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\Users\\LENOVO\\eclipse-workspace\\30AprMumSeleniumMaven\\Screenshots\\testCaseID"+TCID+".jpg");
		FileHandler.copy(Src, Dest);
		
	}
	
	public static String getPFdata(String key) throws IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\30AprMumSeleniumMaven\\propertyFile.properties");
		Properties P= new Properties();
		P.load(file);
		String value = P.getProperty(key);
		return value;
	}
	
	
	
	
	
	
	
	
	
	
}
