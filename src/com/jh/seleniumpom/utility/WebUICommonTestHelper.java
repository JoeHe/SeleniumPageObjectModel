package com.jh.seleniumpom.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.*;

//import java.util.*;
import java.util.function.Function;



public class WebUICommonTestHelper {
	public WebDriver driver;
    public WebDriver getDriver() {
		return driver;
	}

	protected String baseURL;
    protected WebDriverWait waiter;
    protected int browserType;

    /// <summary>
    /// This filed indicate a folder which contains the browser drivers (like chromedriver.exe, IEDriverServer.exe...), 
    /// as we will put the drivers with the test assembly under bin, so we will use ".\" as default, unless you want to point to a default driver location
    /// </summary>
    protected String browserDriverFolder;
    protected int waitTime = 0;

    public WebUICommonTestHelper(String baseURL, int type, String driverFolder, int defaultWaitSeconds)
    {
        this.baseURL = baseURL;
        this.browserType = type;
        this.browserDriverFolder = driverFolder;
        this.waitTime = defaultWaitSeconds;

        //ConstructDriver(type);
    }

    public void ConstructDriver(){
    	ConstructDriver(this.browserType);
    }
    
    private void ConstructDriver(int typedriver)
    {
        switch (typedriver)
        {             
            case 2:
                ConstructChromeDriver();
                break;
            case 3:
                ConstructFirefoxDriver();
                break;           
        }
        this.driver.manage().window().maximize();
        this.waiter = new WebDriverWait(driver, this.waitTime);
    }
	  

    private void ConstructChromeDriver()
    {
    	System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        this.driver =  new ChromeDriver(options);
       
    }

    private void ConstructFirefoxDriver()
    {
        if (this.driver == null)
        {
            this.driver = new FirefoxDriver();
        }
    }
    
    public void DestroyDriver(){
    	if(this.driver != null){
    		driver.close();
    	}
    }

    public int ElementCount(By locator)
    {
        return driver.findElements(locator).size();
    }
    
    public boolean IsElementDisplayed(By locator){
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
    
    public void SmartWaitForElementDisplay(By locator) throws Exception{
    	SmartWaitForElementDisplay(locator, 10);
    }
    
    public void SmartWaitForElementDisplay(By locator, int timeout) throws Exception{
    	int time =timeout;
    	while(time>=0){
    		if(this.IsElementDisplayed(locator)){
    			break;
    		}
    		time -= 1;
    	} 
    	if(time<0){
    		throw new Exception("ERROR: can't find "+locator.toString()+"in "+timeout +"s timeout!");
    	}    	   	
    }
    
   public boolean ElementDisplayed(By locator){
    	//return this.waiter.until(CommonLib.ElementIsDisabled(driver, locator));
	   return this.waiter.until(new ExpectedCondition<Boolean>() {
           public Boolean apply(WebDriver d) {
               return d.findElement(locator).isEnabled();
           }
       });
	   
	   
    }
         
}
