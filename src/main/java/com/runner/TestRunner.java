package com.runner;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.common.Report;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/main/resources/com/ms/features", glue = "com.Stepdefinitions", tags = "@Facebook", plugin = {
		"json", "json:Report/cucumber.json" }, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	public static ChromeDriverService CHROME_DRIVER_SERVICE;

//	@BeforeSuite
	public void intializingChromeDriver() {
		
	if (CHROME_DRIVER_SERVICE != null && CHROME_DRIVER_SERVICE.isRunning()) {
	return;
	}
	CHROME_DRIVER_SERVICE= new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\Cucumber\\chromedriver.exe")).usingAnyFreePort().build();
	try {
	CHROME_DRIVER_SERVICE.start();
	} catch (IOException e){
	System.out.println("Error Occured while starting ChromeDriver making it as null");
	System.out.println("Error is :: "+e.getMessage ());
	CHROME_DRIVER_SERVICE=null;
	throw new RuntimeException("Error Occured While Starting Chrome", e);
	}
	System.out.println("Error is :: ");
	}

	@AfterSuite
	public void OnFinish() {
		if (CHROME_DRIVER_SERVICE != null && CHROME_DRIVER_SERVICE.isRunning()) {
		CHROME_DRIVER_SERVICE.stop();
		}
		// BasePage.driver.quit();
		Report.moveOldReportToArchive ();
		try {
		String[] command = {"cmd.exe", "/C", "Start", "generateReport.bat" };
		Runtime.getRuntime().exec(command);
		System.out.println("Cucumber report creation is done");
		
		} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
}
