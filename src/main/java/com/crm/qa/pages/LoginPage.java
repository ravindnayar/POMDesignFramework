package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	
		// Page Factory or Object Repository
		@FindBy(xpath=".//*[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
		WebElement loginTab;
		
		@FindBy(name="email")
		WebElement emailAddress;
		
		@FindBy(name="password")
		WebElement pwd;
		
		@FindBy(xpath=".//*[@class='ui fluid large blue submit button']")
		WebElement loginBtn;
		
		@FindBy(xpath="//img[@src='/images/Android.png']")
		WebElement playStoreIcon;
	
		
		// constructor // initializing Page Objects
		public LoginPage(){
			// initializing Page Objects
			PageFactory.initElements(driver, this);
		}
		
		// Actions:
		// Verify page title
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		// Verify play store icon
		public boolean validatePlayStoreIcon(){
			return playStoreIcon.isDisplayed();
		}
		
		// Login functionality
		public HomePage login(String emailaddress, String password){
			
			loginTab.click();
			System.out.println("Login Tab successfully clicked");
			emailAddress.sendKeys(emailaddress);
			pwd.sendKeys(password);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			loginBtn.click();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			System.out.println("User got looged in successfully");			
			 			
			return new HomePage();
			
		}
}
