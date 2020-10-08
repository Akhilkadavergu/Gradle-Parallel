package com.common;

import com.common.BasePage;

public class CommonFuncitonsPages extends BasePage{

	public void readDataFromExcel(String sheetName, int rowNo) throws Exception {
		readExcelData(sheetName, rowNo);
	}

	public void launchURL(String sURL) {
	
		driver.get("https://www.facebook.com/");
	}

}
