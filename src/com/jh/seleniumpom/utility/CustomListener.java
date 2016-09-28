package com.jh.seleniumpom.utility;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter{
    private int m_count = 0;
	 
    @Override
    public void onTestFailure(ITestResult tr) {
        log("Failed: Test method ["+tr.getName()+ "]\n");
    }
	 
    @Override
    public void onTestSkipped(ITestResult tr) {
        log("Skipped: Test method ["+tr.getName()+ "]\n");
    }
	 
    @Override
    public void onTestSuccess(ITestResult tr) {
        log("Passed: Test method ["+tr.getName()+ "]\n");
    }
	 
    private void log(String string) {
        System.out.print(string);
        if (++m_count % 40 == 0) {
	    System.out.println("");
        }
    }

}
