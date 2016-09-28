package com.jh.seleniumpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jh.seleniumpom.utility.*;

public class LoginSuccessPage {
 private WebDriver driver;
     
	 public LoginSuccessPage(WebDriver driver) {	         
	        this.driver = driver;
	        if(!driver.getTitle().equals("Dashboard [Jenkins]") && CommonLib.IsElementDisplayed(driver, By.partialLinkText("/joc/user/"))){
	        	Assert.assertTrue(false, "This is not Login Success Page!"); 
	        	//throw new IllegalStateException("This is not Login Success Page!");
	        }
	    }
	 
	 public void Logout() throws Exception{
		 System.out.println("log out user...");
		 Log.INFO("Log out user...");
		 WebElement eleHeader=driver.findElement(By.id("header"));
		 eleHeader.findElement(By.xpath("//a[@href='/joc/logout']")).click();		 
		 /*if(!CommonLib.HasElement(driver, By.linkText("/joc/logout"))){
			 System.out.println("log out successfull!");
		 }*/
		 Assert.assertFalse(CommonLib.HasElement(driver, By.linkText("/joc/logout")), "log out successfull!");
	 }
}
