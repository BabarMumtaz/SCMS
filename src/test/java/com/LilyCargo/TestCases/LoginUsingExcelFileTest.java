package com.LilyCargo.TestCases;

import java.io.IOException;
import java.time.Duration;

import com.LilyCargo.Util.ScreenShotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Pages.LoginTestPage;
import com.LilyCargo.Util.ExcelUtil;
import com.LilyCargo.Util.TestUtilClass;

public class LoginUsingExcelFileTest extends TestBaseClass {

	Logger log;

	@BeforeMethod
	public void setup() {
		initialization(); // Initializes the browser

		log = LogManager.getLogger(LoginUsingExcelFileTest.class);
		log.info("Test setup completed.");
	}

	// DataProvider to fetch data from Excel file
	@DataProvider
	public Object[][] getLoginTestData() {
		// return LoginExcelUtil.getTestData("LoginCredentials"); // The sheet name is 'LoginCredentials'
		return ExcelUtil.getTestData("LoginCredentials",
				(System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\LoginTestData.xlsx"));
	}

	@Test(priority = 1, description = "Verify valid login", dataProvider = "getLoginTestData", groups = {"regression"})
	public void validLoginTestUsingDataDriven(String username, String password) {
		log.info("Attempting login with username: " + username);
		loginPage.login(username, password);

		// Verifying successful login
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed for: " + username);
		loginPage.logout();
	}

	@AfterMethod
	public void tearDown() {
		captureScreenshot("validLoginTestUsingDataDriven");
		closeBrowser();
	}

	private void captureScreenshot(String testName) {
		try {
			ScreenShotUtil.takeScreenshotAtEndOfTest(driver, testName);
			log.info("Screenshot captured for test: " + testName);
		} catch (IOException e) {
			log.error("Error capturing screenshot.", e);
		}
	}

	private void closeBrowser() {
		if (driver != null) {
			driver.quit();
			log.info("Browser closed successfully.");
		}
	}
}
