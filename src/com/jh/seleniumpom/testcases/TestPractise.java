package com.jh.seleniumpom.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.AfterClass;
import org.testng.log4testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jh.seleniumpom.utility.*;

public class TestPractise extends TestBase{
	
  private static final Logger LOGGER = Logger.getLogger(TestPractise.class.getName());
  
  @Test
  public void f() {
	  LOGGER.log(Level.INFO, "In test case");
	   //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	   //WebDriver driver= new FirefoxDriver(capabilities);	 
//	   System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//	   WebDriver driver= new ChromeDriver();
//	   driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   //driver.get("http://www.google.com/");//http://www.example.com/
	   
	   //WebDriver driver2= new ChromeDriver();
	   // And now use this to visit Google
       //driver.get("http://www.bing.com");
       // Alternatively the same thing can be done like this
	   GetTestHelper().driver.navigate().to("http://www.google.com");
	   WebElement element =GetTestHelper().driver.findElement(By.name("q"));
       // Find the text input element by its name
       //WebElement element = driver.findElement(By.name("q"));

       // Enter something to search for
       element.sendKeys("Cheese!");

       // Now submit the form. WebDriver will find the form for us from the element
       element.submit();

       // Check the title of the page
       System.out.println("Page title is: " + GetTestHelper().getDriver().getTitle());
       
       // Google's search is rendered dynamically with JavaScript.
       // Wait for the page to load, timeout after 10 seconds
//       (new WebDriverWait(GetTestHelper().getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
//           public Boolean apply(WebDriver d) {
//               return d.getTitle().toLowerCase().startsWith("cheese!");
//           }
//       });

       // Should see: "cheese! - Google Search"
       System.out.println("Page title is: " + GetTestHelper().getDriver().getTitle());
  }
  
//  @BeforeClass
//  public void beforeClass() {
//	  LOGGER.log(Level.INFO, "In Before Class");
//	  
//  }
//
//  @AfterClass
//  public void afterClass() {
//	  LOGGER.log(Level.INFO, "In After Class");
//  }

}
