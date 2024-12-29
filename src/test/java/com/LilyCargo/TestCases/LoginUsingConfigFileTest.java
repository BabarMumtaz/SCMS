package com.LilyCargo.TestCases;

import java.io.IOException;
import java.time.Duration;

import com.LilyCargo.Util.ScreenShotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Pages.LoginTestPage;
import com.LilyCargo.Util.RetryAnalyzer;
import com.LilyCargo.Util.TestUtilClass;

import io.qameta.allure.*;

public class LoginUsingConfigFileTest extends TestBaseClass {

	Logger log;

	@BeforeMethod
	public void setup() {
		initialization(); // Opens browser
		log = LogManager.getLogger(LoginUsingConfigFileTest.class);
		log.info("Test setup completed.");
	}

	@Test(priority = 1, description = "Verify valid login", retryAnalyzer = RetryAnalyzer.class, groups = {"smoke", "regression"}, enabled = true)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a valid user can login")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Valid login")
	@Step("Perform login with valid credentials")
	public void validLoginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		// Verifying successful login
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
		log.info("Valid login test passed.");

		loginPage.logout();
	}

	@Test(priority = 2, description = "Verify invalid login", groups = {"regression"}, enabled = false)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify that an invalid user cannot login")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Invalid login")
	@Step("Perform login with invalid credentials")
	public void invalidLoginTest() {
		loginPage.login(prop.getProperty("usernameInV"), prop.getProperty("passwordInV"));

		// Verifying unsuccessful login
		Assert.assertTrue(loginPage.isLoginFailed(), "Login should have failed!");
		log.info("Invalid login test passed with error: " + loginPage.getErrorMessage());
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		// Get the name of the test method
		String testName = result.getMethod().getMethodName();

		try {
			// Take a screenshot using the test method name
			ScreenShotUtil.takeScreenshotAtEndOfTest(driver, testName);
		} catch (IOException e) {
			log.error("Failed to take screenshot for test: " + testName, e); // Use logging instead of printStackTrace
		} finally {
			if (driver != null) {
				driver.quit();
				log.info("Browser closed.");
			}
		}
	}
}
