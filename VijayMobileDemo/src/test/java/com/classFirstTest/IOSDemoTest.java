package com.classFirstTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class IOSDemoTest {
	
	
	public static AppiumDriver<IOSElement> mdriver;
	
	@Test
	public static void SampleIOSDemo() throws MalformedURLException, InterruptedException {
		
	      DesiredCapabilities caps = new DesiredCapabilities();
	      
	      // Set your access credentials
	      caps.setCapability("browserstack.user", "sathishkumar93");
	      caps.setCapability("browserstack.key", "s14LDSWxcnzPK3LqoHzs");
	      caps.setCapability("autoAcceptAlerts", true);
	      
	      // Set URL of the application under test
	      caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");
	      
	      // Specify device and os_version for testing
	      caps.setCapability("device", "iPhone 11 Pro");
	      caps.setCapability("os_version", "13");
	        
	      // Set other BrowserStack capabilities
	      caps.setCapability("project", "First Java Project");
	      caps.setCapability("build", "Java iOS");
	      caps.setCapability("name", "Second_test");
	      
	      
	      // Initialise the remote Webdriver using BrowserStack remote URL
	      // and desired capabilities defined above
	        mdriver = new IOSDriver<IOSElement>(
	            new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);
	        
	        // Test case for the BrowserStack sample iOS app. 
	        // If you have uploaded your app, update the test case here. 
	        IOSElement textButton = (IOSElement) new WebDriverWait(mdriver, 30).until(
	    
	            ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
	        textButton.click();
	        
	        
	        
	        
	        
	        IOSElement textInput = (IOSElement) new WebDriverWait(mdriver, 30).until(
	            ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
	        textInput.sendKeys("hello@browserstack.com");
	        Thread.sleep(5000);
//	        IOSElement textOutput = (IOSElement) new WebDriverWait(mdriver, 30).until(
//	                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Output")));
//	        if(textOutput != null && textOutput.getText().equals("hello@browserstack.com"))
//	            assert(true);
//	        else
//	            assert(false);  
//	    
	        
	        mdriver.quit();
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        


		
		
	}
	
	

}
