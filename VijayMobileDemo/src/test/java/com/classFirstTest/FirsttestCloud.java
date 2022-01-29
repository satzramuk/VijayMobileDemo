package com.classFirstTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FirsttestCloud {
	
	@Test
	public static void myFirstCloudTest() throws MalformedURLException {
		
	      DesiredCapabilities caps = new DesiredCapabilities();
	      
	      // Set your access credentials
	      caps.setCapability("browserstack.user", "sathishkumar93");
	      caps.setCapability("browserstack.key", "s14LDSWxcnzPK3LqoHzs");
	      
	      // Set URL of the application under test
	      caps.setCapability("app", "bs://c282c3e0c822c7bc2fbea4f890790cb9610410d5");

	      
	      // Specify device and os_version for testing
	      caps.setCapability("device", "Google Pixel 3");
	      caps.setCapability("os_version", "9.0");
	        
	      // Set other BrowserStack capabilities
	      caps.setCapability("project", "First Java Project");
	      caps.setCapability("build", "Java Android");
	      caps.setCapability("name", "first_test");
	        
	      
	      // Initialise the remote Webdriver using BrowserStack remote URL
	      // and desired capabilities defined above
	      
	      //AppiumDriver<MobileElement> mdriver = new IOSDriver<MobileElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
	        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
	            new URL("http://hub.browserstack.com/wd/hub"), caps);
	        

	      /* Write your Custom code here */
	        
	        
	        driver.findElementById("android:id/text1").click();
	     
	        
	        
	        
	        
	      // Invoke driver.quit() after the test is done to indicate that the test is completed.
	      driver.quit();

		
	}
	

}
