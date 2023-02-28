package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin1Page 
{
	@FindBy(xpath = "//input[@id='userid']")private WebElement UN;
	@FindBy(xpath = "//input[@id='password']")private WebElement PWD;
	@FindBy(xpath = "//button[text()='Login ']")private WebElement loginBtn;
	
	public KiteLogin1Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpKiteLogin1PageUserName (String UserName)
	{
		UN.sendKeys(UserName);
	}
	public void inpKiteLogin1PagePassword (String Password) 
	{
		PWD.sendKeys(Password);
	}
	public void clickKiteLogin1PageLoginBtn() 
	{
		loginBtn.click();
	}
	
	
}
