package com.pages;

public interface IPage {

	public boolean clickElement(String eleld) throws InterruptedException, Exception;
	public boolean selectElement(String dropDownEleId, String option);
	public boolean verifyElement(String eleId) throws InterruptedException, Exception;
	public boolean setData(String sFieldName, String sValue) throws Exception;
	public boolean validateValue(String sExpectedValue, String sFielldName) throws Exception;
	public boolean searchElement (String recordType) throws InterruptedException;
	public boolean verifyNonPresenceofElement (String sFieldlane);
	public boolean verifyTooltip(String sfieldName, String sToolTip);
	public boolean verifyBackgroundColor (String sData, String sColor);
	public void storeValues(String sFieldValues) throws Exception;
}
