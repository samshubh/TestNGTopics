package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testutil.TestUtil;

public class TestNGBasics {
	  
	WebDriver driver;
	Properties prop;
	
	
	@BeforeMethod
	 public void setUp() throws IOException
	 {
		
	      prop = new Properties();
	      
	      FileInputStream ip = new FileInputStream("C:\\Users\\subham\\eclipse-workspace\\NuqiQATesting\\config.properties");
	      
	       prop.load(ip);
	      
		    System.setProperty("webdriver.chrome.driver","D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
		 
		      driver = new ChromeDriver();
		   
		    driver.manage().window().maximize();
		     
		    driver.manage().deleteAllCookies();
		    
		    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		   
		     driver.get(prop.getProperty("url"));
		     
	 }
	
	
	     @Test
	       public void getTestData(String firstName, String lastName, String addressField, String cityName, String stateName, String pinCode ) throws InterruptedException
	       {
	    	  driver.findElement(By.id("firstname")).clear();
	    	    Thread.sleep(3000);
	    	   driver.findElement(By.id("firstname")).sendKeys(firstName);
	    	   
	    	   driver.findElement(By.id("lastname")).clear();
	    	    Thread.sleep(3000);
	    	   driver.findElement(By.id("lastname")).sendKeys(lastName); 
	    	   
	    	   driver.findElement(By.id("address1")).clear();
	    	    Thread.sleep(3000);
	    	   driver.findElement(By.id("address1")).sendKeys(addressField);
	    	   
	    	   driver.findElement(By.id("city")).clear();
	    	    Thread.sleep(3000);
	    	   driver.findElement(By.id("city")).sendKeys(cityName);
	    	   
	    	  Select state = new Select(driver.findElement(By.id("state")));
	    	    state.selectByVisibleText("stateName");
	    	      Thread.sleep(3000);
	    	      driver.findElement(By.id("zip")).clear();
		    	    Thread.sleep(3000);
		    	   driver.findElement(By.id("zip")).sendKeys(pinCode);
	    	   
	       }
	     
	     
	     @AfterMethod
	       public void tearDown()
	       {
	    	 driver.quit();
	       }

}

