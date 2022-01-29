package com.classFirstTest;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ThirdTest {

	static AndroidDriver<AndroidElement> driver;



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
		caps.setCapability("name", "Drag_Drop_Test");


		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above

		//AppiumDriver<MobileElement> mdriver = new IOSDriver<MobileElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), caps);


//		AndroidElement animationelemt = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Animation\"]");
//		tapAnElement(driver,animationelemt);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
//		AndroidElement source =driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
//		AndroidElement destine =driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
//		DragAndDrop(driver, source, destine);
		
		ScrollAndClick(driver, "Radio Group");
		driver.findElement(By.xpath("//*[@content-desc=\"Radio Group\"]")).click();
		
		Thread.sleep(20000);
		driver.quit();

	}



	public void tapAnElement(AndroidDriver<AndroidElement> driver, AndroidElement elementparam) {

		TouchAction ta = new AndroidTouchAction(driver);
		ta.tap(tapOptions().withElement(element(elementparam))).perform();
		
	}

	
	public void SwipeAnElement(AndroidDriver driver, AndroidElement start, AndroidElement end) {

		TouchAction ta = new AndroidTouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(start)).withDuration(Duration.ofSeconds(5))).moveTo(element(end)).release().perform();
        

	}

	public void tapOnCoordinates(AndroidDriver driver, int x, int y) {

		TouchAction ta = new AndroidTouchAction(driver);
		ta.tap(point(x, y)).perform();


	}

	public void longPress(AndroidDriver driver, AndroidElement elementparam) {


		TouchAction ta = new AndroidTouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(elementparam)).withDuration(Duration.ofSeconds(5))).perform();

	}

	public void DragAndDrop(AndroidDriver driver, AndroidElement source, AndroidElement destine) {

		TouchAction ta = new AndroidTouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(source))).moveTo(element(destine)).release().perform();

	}

	public void ScrollAndClick(AndroidDriver driver, String textvalue) {

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+textvalue+"\").instance(0))");

	}

	public void ScrollFindTheMobileElementAndClick(By by) {

		while(driver.findElements(by).size()==0) 
		{
			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			int center = (int)(dimensions.width*0.5);
			TouchAction ta = new AndroidTouchAction(driver);
			ta.press(PointOption.point(center, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(center, scrollEnd)).release().perform();

		}


	}
}