package com.classFirstTest;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;

public class SecondTest {

	AndroidDriver<AndroidElement> driver;

	
	



	@Test
	public void mySecondTest() throws InterruptedException, MalformedURLException {
		
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
		caps.setCapability("name", "Second_test");


		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above

		//AppiumDriver<MobileElement> mdriver = new IOSDriver<MobileElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), caps);


		AndroidElement animationelemt = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Animation\"]");
		tapAnElement(driver,animationelemt);
		Thread.sleep(30000);
		driver.quit();

	}



	private void tapAnElement(AndroidDriver<AndroidElement> driver, AndroidElement elementparam) {

		TouchAction ta = new AndroidTouchAction(driver);
		ta.tap(tapOptions().withElement(element(elementparam))).perform();
	}

	private void SwipeAnElement(AndroidDriver driver, AndroidElement start, AndroidElement end) {

		TouchAction ta = new AndroidTouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(start)).withDuration(Duration.ofSeconds(5))).moveTo(element(end)).release().perform();


	}


	
	
}
