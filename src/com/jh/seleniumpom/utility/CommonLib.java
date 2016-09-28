package com.jh.seleniumpom.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLib {

	  public static boolean HasElement(WebDriver driver, By by)
      {
          try
          {
              driver.findElement(by);
          }
          catch (NoSuchElementException e)
          {
              return false;
          }

          return true;
      }
	  
	  
	  public static boolean IsElementDisplayed(WebDriver driver, By locator){
	    	try
	        {
	    		return driver.findElement(locator).isDisplayed();
	        }
	        catch (StaleElementReferenceException e)
	        { }
	        catch (NoSuchElementException e)
	        { }
	    	
	    	return false;      
	  }
	  
	  public static void SmartWaitForElementDisplay(WebDriver driver, By locator) throws Exception{
	    	SmartWaitForElementDisplay(driver, locator, 10);
	    }
	    
	  public static void SmartWaitForElementDisplay(WebDriver driver, By locator, int timeout) throws Exception{
	    	int time =timeout;
	    	while(time>=0){
	    		if(IsElementDisplayed(driver, locator)){
	    			break;
	    		}
	    		time -= 1;
	    	} 
	    	if(time<0){
	    		throw new Exception("ERROR: can't find "+locator.toString()+"in "+timeout +"s timeout!");
	    	}    	   	
	    }
	    
	  public static boolean ElementDisplayed(WebDriverWait waiter, By locator){
	    	//return this.waiter.until(CommonLib.ElementIsDisabled(driver, locator));
		   return waiter.until(new ExpectedCondition<Boolean>() {
	           public Boolean apply(WebDriver dr) {
	               return dr.findElement(locator).isEnabled();
	           }
	       });		   		   
	    }
	  
	  public static void ClickElement(WebDriver driver, By locator) throws Exception{
		  SmartWaitForElementDisplay(driver, locator);
		  driver.findElement(locator).click();
	  }
	  
	  public static void SendKey(WebDriver driver, By locator, String keys) throws Exception{
		  SmartWaitForElementDisplay(driver, locator);
		  driver.findElement(locator).sendKeys(keys);		 
	  }
	  
}
