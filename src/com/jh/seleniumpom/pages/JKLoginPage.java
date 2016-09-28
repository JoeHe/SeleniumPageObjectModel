package com.jh.seleniumpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.jh.seleniumpom.utility.*;

public class JKLoginPage {
	 private WebDriver driver;
	 
	 private final String userNameID="j_username";
	 private final String passWordName="j_password";
	 private final String loginBtnID="yui-gen1-button";
     
	 public JKLoginPage(WebDriver driver) {	         
	        this.driver = driver;
	        if(!driver.getTitle().equals("Jenkins")){
	        	driver.get("https://jenkins.cloud.autodesk.com/joc/login");
	        }
	    }	     	  
	 
	 public JKErrLoginPage loginError() throws Exception{
		 Log.INFO("Input UserName...");
		 CommonLib.SendKey(driver, By.id(userNameID), "hejin");
		 Log.INFO("Input PWD...");
		 CommonLib.SendKey(driver, By.name(passWordName), "hejin");
		 Log.INFO("Click Login Button...");
		 CommonLib.ClickElement(driver, By.id(loginBtnID));
		 return new JKErrLoginPage(driver);
	 }
	 
	 public LoginSuccessPage loginSuccess() throws Exception{
		 Log.INFO("Input UserName...");
		 CommonLib.SendKey(driver, By.id(userNameID), "mapuser");
		 Log.INFO("Input PWD...");
		 CommonLib.SendKey(driver, By.name(passWordName), "01gisqa!");
		 Log.INFO("Click Login Button...");
		 CommonLib.ClickElement(driver, By.id(loginBtnID));
		 return new LoginSuccessPage(driver);
	 }
	 
}
