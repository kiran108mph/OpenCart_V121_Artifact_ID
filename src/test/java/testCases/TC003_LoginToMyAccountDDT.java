package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import testUtilities.DataProviders;

public class TC003_LoginToMyAccountDDT extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"dataDriven","master"})
	public void loginToMyAccountDDT(String emailIds, String password, String validations) throws InterruptedException
	{
		logger.info("<------TC003_LoginToMyAccountDDT Test case is started ------>");
		try
		{
			HomePage home = new HomePage(driver);
			logger.info("Click on My account dropdown");
			home.clickOnMyAccountDropDown();
			logger.info("Select Log In button");
			home.clickOnLoginOptionFromMyAccountDropdown();
			
			LoginPage login = new LoginPage(driver);
			logger.info("Enter Login mail id");
			login.enterLoginMailAddress(emailIds);
			logger.info("Enter Login Password");
			login.enterLoginPassword(password);
			logger.info("Click on Log in Button");
			login.clcickOnLoginButton();
					
			MyAccountPage myAccount = new MyAccountPage(driver);
			logger.info("Validate My account page");
			boolean accountExists = myAccount.isMayAccountExist();
			System.out.println("Is it valid / Invalid Credentials? -> "+validations+" Credentials");
			System.out.println("Is my account Exist ? -> "+accountExists);
			
			/*
			 If Valid data - Try Login - if its successful to login - logout - My test is passed
			 			   - Try Login - if its failed to login - My test is failed
		   If InValid data - Try Login - if its successful to log in - logout - My test is failed
			 			   - Try Login - if its failed to log in - My test is passed
			 */
			
			if(validations.equalsIgnoreCase("valid"))
			{
				if(accountExists==true)
				{
					logger.info("The login succesfull with "+validations+" data. So the test case is Passed");
					myAccount.clickOnLogOut();
					Assert.assertTrue(true);
				}
				else
				{
					logger.info("The login is unsuccesfull with "+validations+" data. So the test case is Failed");
					Assert.assertTrue(false);
				}
				
			}
			
			if(validations.equalsIgnoreCase("invalid"))
			{
				if(accountExists==true)
				{
					logger.info("The login succesfull with "+validations+" data. So the test case is Failed");
					myAccount.clickOnLogOut();
					Assert.assertTrue(false);
				}
				else
				{
					logger.info("The login is unsuccesfull with "+validations+" data. So the test case is Passed");
					Assert.assertTrue(true);
				}
				
			}
			
		}
			
			catch(Exception e)
			{
				e.getMessage();
				logger.info("<------TC003_LoginToMyAccountDDT Test case got some exception and Its failed------>");
				logger.info("The Exception is ---> "+e.getMessage());
				Assert.assertTrue(false);
			}
			
		Thread.sleep(3000);
			logger.info("<------TC003_LoginToMyAccountDDT Test case is Completed ------>");	
		}
		
	}
