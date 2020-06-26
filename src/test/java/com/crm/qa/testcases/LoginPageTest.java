package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;

public class LoginPageTest extends TestBase{
	
	// login page object
	LoginPage loginPage;
	HomePage homePage;
	
	// constructor
	public LoginPageTest(){
		// super will call super class of base class
		super();
	}
	
	@BeforeTest
	public void setup(){
		intilialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority=2)
	public void validatePlayStoreIconTest(){
	   loginPage.validatePlayStoreIcon();
	   Assert.assertTrue(true);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
		
	}
	
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		
	}

}
