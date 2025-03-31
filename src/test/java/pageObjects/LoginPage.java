package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * We are following 
	 * lnk - links elements
	 * btn - button elements
	 * txt - text fields
	 * chkbx - checkbox
	 * rdbtn - radio button
	 * msg - message
	 */
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtLoginEmailAddress;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtLoginPassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	
	public void enterLoginMailAddress(String email)
	{
		txtLoginEmailAddress.sendKeys(email);
	}
	
	public void enterLoginPassword(String loginpassword)
	{
		txtLoginPassword.sendKeys(loginpassword);
	}
	
	public void clcickOnLoginButton()
	{
		btnLogin.click();
	}

}
