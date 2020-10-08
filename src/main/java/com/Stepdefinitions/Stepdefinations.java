package com.Stepdefinitions;

import org.testng.Assert;

import com.common.CommonFuncitonsPages;
import com.pages.Facebook_Pages;
import com.pages.IPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class Stepdefinations {
	CommonFuncitonsPages obj = new CommonFuncitonsPages();
	Facebook_Pages fbObj = new Facebook_Pages();

	public IPage getPageFromPageName(String pageName) {
		IPage pageObj = null;
		switch (pageName.toLowerCase()) {
		case "facebook":
			pageObj = fbObj;
			break;
		}
		return pageObj;
	}

	@Given("^test data is read from Excel with \"([^\"]*)\" and row \"([^\"]*)\"$")
	public void test_data_is_read_from_Excel_with_Facebook_and_row(String SheetName, int rowNo) throws Exception {
		obj.readDataFromExcel(SheetName, rowNo);
	}

	@Given("^I Launch \"([^\"]*)\" URL$")
	public void Launch_URL(String sURL) throws Exception {
		obj.launchURL(sURL);
	}

	@When("^I enter \"([^\"]*)\" in \"([^\"]*)\" Field in \"([^\"]*)\" Page$")
	public void i_enter_in_Field_in_Page(String sValue, String sFieldName, String sPage) throws Exception {
		boolean result = getPageFromPageName(sPage).selectElement(sValue, sFieldName);
		Assert.assertTrue(result, String.format("Failed to Enter " + sValue + " in " + sFieldName + " in " + sPage));

	}

	@Then("^I verify \"([^\"]*)\" is displayed in \"([^\"]*)\" Page$")
	public void i_verify_is_displayed_in_Page(String sField, String sPage) throws Exception {
		boolean result = getPageFromPageName(sPage).verifyElement(sField);
		Assert.assertTrue(result, String.format("Failed to Verify " + sField + " in " + sPage));

	}

	// @When("I select the option \"([^\"])\" in \"([^\"])\" input in \"([^\"]*)\"
	// page$")
	// public void selectElement(String svalue, String sFieldName, String sPage)
	// throws Exception {
	// boolean result = getPageFromPageName (sPage).selectElement(sValue,
	// sFieldName);
	// Assert.assertTrue (result, String
	// format ("Failed to select " + sValue + " from " + sFieldName +
	// dropdown in " +, sPage +
	// page"));
	//
	// @Mhen ("I click on \"([^\"])\" in \"([^\"])\" page$")
	// public void clickonElement(String sElement, String sPage) throws Exception {
	// boolean result = getPageFromPageName (sPage).clickElement(sElement);
	// Assert.assertTrue (result, String.format("Failed to click on %1$s in %2$s
	// page", SElement, sPage));
	// @when ("^I enter \"([^\"])\" in \"([^\"])\" field in "([^"]*) \" page$")
	//
	// public void setData(String sValue, String sFieldName, String sPage) throws
	// Exception {
	// getPageFromPageName (sPage).setData(sValue, sfieldName);
	// @Then("AI validate \"([^\"]*)\" is present in " i)N" field in \"([^\"]")\"
	// pages")
	//
	// public void checkElement (String SExpectedvalue, String sFieldName, String
	// sPage) throws Exception {
	// boolean result - getPageFromPageName (SPage).validatevalue(sExpectedvalue,
	// sFieldName);
	// Assert.assertTrue(result,
	// String.format("Failed to verify %1$s at 255 in 1635s' page", 'sExpectedValue,
	// sFieldName, sPage));
	// @And ("^I search \"([^\"]*)\" from Global Search in ION" pages")
	//
	// public void searchElement(String recordType, String :Page) throws
	// InterruptedException f
	// boolean result = getPageFromPageName (sPage),searchElementE(recordType);
	// Assert.assertTrue(result, String. format("Failed to scarch + recordType +"in
	// + sPage + " page"));
}
