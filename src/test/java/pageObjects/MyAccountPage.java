package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myAccountHeading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnkLogOut;
	
	public boolean isMayAccountExist()
	{
		try
		{
			boolean accountDisplayed = myAccountHeading.isDisplayed();
			return accountDisplayed;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickOnLogOut()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lnkLogOut);
		//lnkLogOut.click();
	}

}
