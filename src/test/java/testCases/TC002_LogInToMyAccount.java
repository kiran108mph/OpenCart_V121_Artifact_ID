package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LogInToMyAccount extends BaseClass{
	
	
		@Test(groups = {"regression","master"})
		public void loginIntoMyAccount() throws InterruptedException
		{
			logger.info("<------TC002_LogInToMyAccount Test case is started ------>");
		try
		{
			HomePage home = new HomePage(driver);
			logger.info("Click on My account dropdown");
			home.clickOnMyAccountDropDown();
			logger.info("Select Log In button");
			home.clickOnLoginOptionFromMyAccountDropdown();
			
			LoginPage login = new LoginPage(driver);
			logger.info("Enter Login mail id");
			login.enterLoginMailAddress(property.getProperty("mialId"));
			logger.info("Enter Login Password");
			login.enterLoginPassword(property.getProperty("password"));
			logger.info("Click on Log in Button");
			login.clcickOnLoginButton();
					
			/*
			//Trouble shoot purpose
			logger.info("Load differnet URL");
			driver.get("https://github.com/pavanoltraining/OpencartV121");
			Thread.sleep(5000);
			*/
			
			MyAccountPage myAccount = new MyAccountPage(driver);
			boolean accountExists = myAccount.isMayAccountExist();
			System.out.println("Is my account Exist ? -> "+accountExists);
			logger.info("Validate My account page");
			if(accountExists==true)
			{
				logger.info("Validated My account page");
				Assert.assertTrue(accountExists);
				myAccount.clickOnLogOut();
			}
			else
			{
				logger.info("My account page is not validated");
				logger.info("Invalid Credentials");
				Assert.assertTrue(false);
			}
		}
			
			catch(Exception e)
			{
				e.getMessage();
				logger.info("<------TC002_LogInToMyAccount Test case is Failed ------>");
				Assert.assertTrue(false);
			}
			
		logger.info("<------TC002_LogInToMyAccount Test case is Completed ------>");	
		}
			
}
