package com.crm.qa.testcases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage  homePage;
	TestUtil testUtil;

	// constructor
	public HomePageTest(){
		super();
	}
	
	
	@BeforeTest
	public void setup(){
		intilialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
	}
	
	// verify page title test
	@Test(priority=1)
	public void verifyPageTitleTest(){
		String pageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(pageTitle, "Cogmento CRM");
		System.out.println("Verification of Home Page Title - DONE");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String value=driver.findElement(By.xpath("//div[contains(text(),'Beta')]")).getText();
		 
		System.out.println("The  Value will be :" +value);
	}
	
	
	// verify contacts label test
	@Test(priority=2)
	public ContactsPage verifyContactsLabelTest(){
		
		String value=driver.findElement(By.xpath("//div[contains(text(),'Beta')]")).getText();
		 
		 System.out.println("The  Value will be :" +value);
		   
		if(value.equalsIgnoreCase("Beta"))
		   {
			   System.out.println("Home page");
		   }
		   System.out.println("Now going to click on contach page");
		   System.out.println("Link to click :" +driver.findElement(By.xpath("//div[@id='main-nav']/a[3]")).getText());
		   homePage.verifyContactsLabel();
		   return new ContactsPage();
	}
	
	//@Test(priority=2)
	public void verifyCorrectUserNameTest(){
		 homePage.verifyCorrectUserName();
		 Assert.assertTrue(true);
		 
		
	}
	
	//@Test(priority=3)
	public void clickOnContactsLinkTest() throws InterruptedException{
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.wait(4000);
		homePage.clickOnContactsLink();
	}
	
//	@Test(priority=4)
	public void clickOnDealsLinkTest(){
		homePage.clickOnDealsLink();
	}
	
	//@Test(priority=5)
	public void clickOnTasksLinkTest(){
		homePage.clickOnTasksLink();
	}
	
//	@Test(priority=6)
	public void verifyContactsActivityStreamTest(){
		homePage.verifyContactActivityStream();
	}
	
	//@Test(priority=7)
	public void verifyHomePageLogoTest() throws InterruptedException{
		driver.wait(4000);
		homePage.verifyHomePageLogo();
	}
	


	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
