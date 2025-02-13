package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Util.ScreenShotUtil;
import com.LilyCargo.Util.RetryAnalyzer;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginUsingConfigFileTest extends TestBaseClass {

	private static final Logger log = LogManager.getLogger(LoginUsingConfigFileTest.class);

	@BeforeMethod
	public void setup() {
		initialization(); // Open browser
		log.info("Test setup completed.");
	}

	@Test(priority = 1, description = "Verify valid login", retryAnalyzer = RetryAnalyzer.class, groups = {"smoke", "regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a valid user can login")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Valid login")
	@Step("Perform login with valid credentials")
	public void validLoginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
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
		Assert.assertTrue(loginPage.isLoginFailed(), "Login should have failed!");
		log.info("Invalid login test passed with error: " + loginPage.getErrorMessage());
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		String testName = result.getMethod().getMethodName();
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtil.takeScreenshotAtEndOfTest(driver, testName);
			log.error("Test FAILED: {} - Screenshot captured.", testName);
		} else {
			log.info("Test {}: {}", testName, result.getStatus() == ITestResult.SUCCESS ? "PASSED" : "SKIPPED");
		}
		driver.quit();
	}
}
