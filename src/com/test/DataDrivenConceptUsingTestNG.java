package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testutil.TestUtil;
import testutil.TestUtil1;

public class DataDrivenConceptUsingTestNG  {
	
	   
	public static WebDriver driver;
	@BeforeMethod
     public void setUp() throws InterruptedException
     {
		// Setting the path and property of chrome driver
		System.setProperty("webdriver.chrome.driver","D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
		
		// Creating instance of webdriver 
		driver = new ChromeDriver();
		
		//Maximizing the browser
		
		driver.manage().window().maximize();
		
		// clearing the browser cookies
		
		driver.manage().deleteAllCookies();
		
		//Setting the page load timeout for the web page 
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//Syntax for implicit wait
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.kiposcollective.com/#/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='col-lg-4 col-xl-4 col-md-5 col-sm-4 col-8 sign-right order-aline-2 ng-scope']//span[@class='btn btn-sign'][contains(text(),'Login')]")).click();
		Thread.sleep(5000);
     }
	  
	
	@DataProvider
	  public Iterator<Object[]> getData()
	  {
		ArrayList <Object[]> testdata = TestUtil1.getLoginDetailsFromExcel();
		
		return testdata.iterator();
	  }
	
	
	
	@Test(dataProvider="getData")
	 public void halfEbayRegistration(String email, String password) throws InterruptedException
	 {
		
		//driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
          Thread.sleep(4000);

        
         // driver.findElement(By.xpath("//input[@id='password_login']")).clear();
            driver.findElement(By.xpath("//input[@id='password_login']")).sendKeys(password);
              Thread.sleep(4000);
    
	 }

	
	
}
