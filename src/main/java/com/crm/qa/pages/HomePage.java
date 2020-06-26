package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLabel;
	
	//@FindBy(xpath="//div[@id='main-nav']/a/span[contains(text(),'Contacts')]")
	@FindBy(xpath=" //div[@id='main-nav']/a[3]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//div[contains(text(),'Contacts activity stream')]")
	WebElement contactActivityStream;
	
	@FindBy(xpath=" //div[@class='header item']")
	WebElement homePageLogo;
	
	@FindBy(xpath="//div[@id='main-nav']/a[3]")
	WebElement contactLabel;
	
	//constructor
	public void HomePage(){
		
		// intialize page objects
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions:
	
		// verify home page title
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		
		// verify correct user name
		public boolean verifyCorrectUserName(){
			return userNameLabel.isDisplayed();
		}
		
		// click on contact link
		public ContactsPage clickOnContactsLink() throws InterruptedException{
			contactsLink.click();
			driver.wait(50);
			return new ContactsPage();
		}
		
		// click on deals link
		public DealsPage clickOnDealsLink(){
			dealsLink.click();
			return new DealsPage();
		}
		
		// click on tasks link
		public TasksPage clickOnTasksLink(){
			tasksLink.click();
			return new TasksPage();
		}

		// verify contact activity stream
		public void verifyContactActivityStream(){
			String contactText = contactActivityStream.getText();
			System.out.println(contactText);
		}
		
		// verify homePageLogo
		public void verifyHomePageLogo(){
			homePageLogo.isDisplayed();
		}
		
		// click on Contacts Page
		public void verifyContactsLabel(){
			contactLabel.click();
		}
}
