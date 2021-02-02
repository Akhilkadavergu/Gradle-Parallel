package com.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import com.cucumber.MSChromeDriverServiceHandler;
import com.runner.TestRunner;

import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.Alert;

public class BasePage {

	public static WebDriver driver;
	public static Wait<WebDriver> wait;
	public static String ScenarioID;
	public static LinkedHashMap<String, String> testdataMap;
	public static String SheetName, scenTempName, productname, scenName;
	public static String SHEETNAME;
	public static int RowNo;
	public static JavascriptExecutor jse;
	public static Actions action;
	public static Wait<WebDriver> largeWait;
	public static HashMap<String, String> hm = new HashMap<String, String>();
	GenericFunction gf = new GenericFunction();
	public Property config = new Property(
			System.getProperty("user.dir") + "/src//main//resources//" + "//config.properties");

	public static void initializeDriver() {
		try {
			System.out.println("Launching Chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src//main//resources//" + "chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
			ChromeOptions options = new ChromeOptions();
			System.out.println(driver);
			 driver = new ChromeDriver(options);
//			try {
//				System.out.println("driver");
//				 driver = new ChromeDriver(TestRunner.CHROME_DRIVER_SERVICE,options);
//				 System.out.println("pint A");
//			} catch (Exception e) {
//				
//				 driver = new ChromeDriver(MSChromeDriverServiceHandler.CHROME_DRIVER_SERVICE,options);
//				 
//			}
			System.out.println(driver);

			wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			jse = (JavascriptExecutor) driver;
			largeWait = new WebDriverWait(driver, 600);
			action = new Actions(driver);
		} catch (Exception e1) {
			System.out.println("Error while getting WebDriver: ." + e1);
		}
	}

	public void NavigateUrl(String url) throws InterruptedException {

		try {

			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(2000);

			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e) {
			}
		} catch (Exception e1) {
			System.out.println("Failed to launch browser");
			Assert.fail();
		}
	}

	public void readExcelData(String SheetName, int rowNo) throws Exception {

		testdataMap = gf.getRowDataHM(System.getProperty("user.dir") + "//src//main//resources//", "excelSheet",
				SheetName, rowNo);
	}
}