package com.jh.seleniumpom.testcases;

import com.jh.seleniumpom.utility.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.jh.seleniumpom.pages.*;

public class JenkinsTestLogin extends DriverBase {

	private final String loginUrl="https://jenkins.cloud.autodesk.com/joc/login"; 
	
    @Test
    public void JenkinsTestErrLogin() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit jenkins
        driver.get(loginUrl);
       
        JKLoginPage loginPage=new JKLoginPage(driver);
        loginPage.loginError();   
    }
    
    @Test
    public void JenkinsTestMapuserLogin() throws Exception {
        WebDriver driver = getDriver();
        driver.get(loginUrl);       
        JKLoginPage loginPage=new JKLoginPage(driver);
        LoginSuccessPage userPage= loginPage.loginSuccess();
        userPage.Logout();    
    }
 
}