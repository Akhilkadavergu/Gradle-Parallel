package com.Stepdefinitions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.common.BasePage;

import cucumber.api.Scenario;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BasePage {

	public String Eny = config.ReadProperty("Env");
	public static Date runStarted = new Date();
	public static Date runEnded;
	public static String runStartedDate = "";
	public static String runEndedDate;
	WebElement ele = null;
	public TestCaseFinished tcFinish;

	@Before(order = 0)
	public void initiate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Hooks.runStartedDate = dateFormat.format(runStarted);

		System.out.println("runStartedDate ::" + Hooks.runStartedDate);
		BasePage.initializeDriver();
		
	}
	// @Before(order =0)
	// public void LaunchURL () {
	// driver.get("www.google.com");
	// }

	@After(order = 0)
	public void closeDriverInstance() {
		if (driver != null) {
			driver.quit();
		}
		driver = null;
	}

	@After(order = 1)

	public void embedScreenshotOnFail(Scenario scenario) {
		if (scenario.isFailed()) {

			System.out.println("After is getting executed");
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				scenario.write(scenario.getName() + " is failed and failed screen is as above acreenshot");
			} catch (WebDriverException e) {
				scenario.write("Embed Failed" + e.getMessage());
			} catch (ClassCastException e1) {
				System.out.println("After is getting executed in second catch");
				e1.printStackTrace();
			}
		}
	}
}