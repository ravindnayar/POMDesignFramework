package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Driver\\chrome driver 83.0.4103.39\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.get("https://www.freecrm.com/");
	
	   driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click();
	   
	   
	   driver.findElement(By.xpath("//input[@name='email']")).sendKeys("iamurs28@gmail.com");
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Times@123");
	   
	   driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	   
	   //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   System.out.println("login succesfull page");
	 //span[@class="user-display"]
	   //driver.navigate().to("https://ui.freecrm.com/"); 
	   String value=driver.findElement(By.xpath("//div[contains(text(),'Beta')]")).getText();
	   System.out.println("The  Value will be :" +value);
	   if(value.equalsIgnoreCase("Beta"))
	   {
		   System.out.println("Home page");
	   }
	   System.out.println("Now going to click on contach page");
	   System.out.println("Link to click :" +driver.findElement(By.xpath("//div[@id='main-nav']/a[3]")).getText());
	   
	   driver.findElement(By.xpath("//div[@id='main-nav']/a[3]")).click();
	   
	   //driver.findElement(By.xpath("//div[contains(text(),'Contacts')]")).click();
	  
	   //System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Contacts')]")));
	   System.out.println("success");
	}
}

