package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
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
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelePhone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtComfirmPassword;
	
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfiramtion;
	@FindBy(xpath="//input[@name='agree']") WebElement btnPrivacyPolicy;
	
	public void enterFirstName(String firstname)
	{
		txtFirstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		txtLastName.sendKeys(lastname);
	}
	
	public void enterMailID(String mailid)
	{
		txtEmail.sendKeys(mailid);
	}
	public void enterTelePhoneNumber(String telepPhoneNumber)
	{
		txtTelePhone.sendKeys(telepPhoneNumber);
	}
	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public void enterConfirmPassword(String password)
	{
		txtComfirmPassword.sendKeys(password);
	}
	
	public void clickOnPrivacyPolicy()
	{
		//btnPrivacyPolicy.click();
		//org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element is not clickable at point (1038, 765)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnPrivacyPolicy);
	}
	
	public void clickOnContinueButton()
	{
		//btnContinue.click();
		//org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element is not clickable at point (1038, 765)
		
		//If in case click action doesn't work for some reason then we can use following solutions.
		
		//solution 2 - Using submit button
		//btnContinue.submit();
		
		//solution 3 - using java script executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnContinue);
		
		//solution 4 - using Action class
		//Actions action = new Actions(driver);
		//action.moveToElement(btnContinue).click().perform();
		
		//solution 5 - using sendKeys method with return key
		//btnContinue.sendKeys(Keys.RETURN);
		
		//solution 6 - using explicit wait
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();;
	}
	
	public String getConfirmationMessage()
	{
		try
		{
			return msgConfiramtion.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	
}
