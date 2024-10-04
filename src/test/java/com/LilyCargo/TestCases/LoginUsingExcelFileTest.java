package com.LilyCargo.TestCases;

import java.io.IOException;
import java.time.Duration;

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

	LoginTestPage loginPage;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		initialization(); // Initializes the browser
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		loginPage = PageFactory.initElements(driver, LoginTestPage.class);
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
	public void validLoginTest(String username, String password) {
		log.info("Attempting login with username: " + username);
		loginPage.login(username, password);

		// Verifying successful login
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed for: " + username);
		loginPage.logout();
	}

	@AfterMethod
	public void tearDown() throws IOException {
		TestUtilClass.takeScreenshotAtEndOfTest();
		if (driver != null) {
			driver.quit(); // Closes the browser instance after each test method
			log.info("Browser closed successfully.");
		}
	}
}
