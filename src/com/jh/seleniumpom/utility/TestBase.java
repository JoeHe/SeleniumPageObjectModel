package com.jh.seleniumpom.utility;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.Capabilities;

public class TestBase {
	  
	  private static WebUICommonTestHelper testHelper;
	  
	  protected static WebUICommonTestHelper GetTestHelper()
    {        
		  testHelper= new WebUICommonTestHelper("",2,"",10);
		  return testHelper;
    }
		
	  @BeforeClass
	  public void beforeClass() {
		  GetTestHelper().ConstructDriver();
	  }

	  @AfterClass
	  public void afterClass() {
		  GetTestHelper().DestroyDriver();
	  }
	 
	  @BeforeSuite
	  public void beforeSuite(){
		  
	  }

	  @AfterSuite
	  public void afterSuite() {
		 
	  }
	  
}

