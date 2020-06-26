package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	// login page object
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	// constructor
	public ContactsPageTest(){
		// super will call super class of base class
		super();
	}
	
	@BeforeTest
	public void setup(){
		intilialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
				
	}
	
	
}
