package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import LibraryFiles.Baseclass;
import LibraryFiles.UtilityClass;
import Module1_Login.KiteHomePage;
import Module1_Login.KiteLogin1Page;
import Module1_Login.KiteLogin2Page;

public class KiteLoginTest extends Baseclass
{
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	KiteHomePage Home;
	int TCID;
	
	@Parameters("browserName")
	@BeforeClass
	public void openBrowser(String browswerName) throws EncryptedDocumentException, IOException
	{				
		initializeBrowser(browswerName);
		
		login1=new KiteLogin1Page(driver); 
		login2=new KiteLogin2Page(driver);
		Home=new KiteHomePage(driver);
		
	}
	
	@BeforeMethod
	public void loginToApp() throws EncryptedDocumentException, IOException
	{
		login1.inpKiteLogin1PageUserName(UtilityClass.getPFdata("UN"));
		login1.inpKiteLogin1PagePassword(UtilityClass.getPFdata("PWD"));
		login1.clickKiteLogin1PageLoginBtn();
		
		login2.inpKiteLogin2PagePin(UtilityClass.getPFdata("PIN"));
		login2.clickKitelogin2PageCntBtn();
	}
	
	@Test
	public void verifyUserID() throws EncryptedDocumentException, IOException
	{
		TCID=101;
		String actualUserID = Home.getKiteHomePageUserID();
		String expUserID = UtilityClass.getTD(0, 3);
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualUserID, expUserID,"Failed: both results are diff ");
				
		//Assert.assertEquals(actualUserID, expUserID,"Failed: both results are diff ");
	}
	
	@AfterMethod
	public void logOut(ITestResult result) throws InterruptedException, IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.CaptureSS(driver, TCID);
		}
		
		Thread.sleep(3000);
		Home.logoutKiteHomePageLogOut(driver);
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
}
