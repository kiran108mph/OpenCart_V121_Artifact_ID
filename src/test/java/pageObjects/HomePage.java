package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//Invoked the parent class constructor , to invoke parent class constructor we need super key word.
	public HomePage(WebDriver driver) {
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

	@FindBy(xpath = "//div[@class='dropdown']//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lnkLoogin;
	
	public void clickOnMyAccountDropDown()
	{
		lnkMyAccount.click();
	}
	
	public void clickOnRegisterOptionFromMyAccoutDropDown()
	{
		lnkRegister.click();
	}
	
	public void clickOnLoginOptionFromMyAccountDropdown()
	{
		lnkLoogin.click();
	}
}
