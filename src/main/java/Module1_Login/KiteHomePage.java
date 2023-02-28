package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 
{
	@FindBy(xpath = "//span[@class='user-id']")private WebElement UserID;
	@FindBy(xpath = "//a[text()=' Logout']")private WebElement logOut;
	
	public KiteHomePage(WebDriver driverr)
	{
		PageFactory.initElements(driverr, this);
	}
	public String getKiteHomePageUserID()
	{
		String actualUserID = UserID.getText();
		return actualUserID;
	}
	public void logoutKiteHomePageLogOut(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(UserID).click().perform();
		logOut.click();
	}
}
