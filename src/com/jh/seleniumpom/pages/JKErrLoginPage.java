package com.jh.seleniumpom.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JKErrLoginPage {
	private WebDriver driver;
     
	public JKErrLoginPage(WebDriver driver) {	         
	        this.driver = driver;
	       /* if(!driver.getTitle().equals("Login Error [Jenkins]")){
	        	 throw new IllegalStateException("This is not Error Login Page!");
	        }*/
	        Assert.assertTrue(driver.getTitle().equals("Login Error [Jenkins]"), "This is Error Login Page!");
	        
	}	     	  
	     	
}
