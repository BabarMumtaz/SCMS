package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.LilyCargo.Util.ExcelUtil;


public class LoginUsingExcelFileTest extends TestBeforeAndAfter {

	Logger log;

	// DataProvider to fetch data from Excel file
	@DataProvider
	public Object[][] getLoginTestData() {
		// return LoginExcelUtil.getTestData("LoginCredentials"); // The sheet name is 'LoginCredentials'
		return ExcelUtil.getTestData("LoginCredentials",
				(System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\LoginTestData.xlsx"));
	}

	@Test(priority = 1, description = "Verify valid login", dataProvider = "getLoginTestData", groups = {"regression"})
	public void validLoginTestUsingDataDriven(String username, String password) {

		log = LogManager.getLogger(LoginUsingExcelFileTest.class);
		log.info("Starting Login Test Using Excel File Test");

		log.info("Attempting login with username: " + username);
		pageObjectManager.getLoginPage().login(username, password);

		// Verifying successful login
		Assert.assertTrue(pageObjectManager.getLoginPage().isLoginSuccessful(), "Login failed for: " + username);
		pageObjectManager.getLoginPage().logout();
	}
}
