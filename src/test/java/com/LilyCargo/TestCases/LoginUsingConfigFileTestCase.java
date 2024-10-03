package com.LilyCargo.TestCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Pages.LoginTestPage;
import com.LilyCargo.Util.RetryAnalyzer;
import com.LilyCargo.Util.TestUtilClass;

import io.qameta.allure.*;

public class LoginUsingConfigFileTestCase extends TestBaseClass {

	LoginTestPage loginPage;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(LoginUsingConfigFileTestCase.class);

	@BeforeMethod
	public void setup() {
		initialization(); // Opens browser
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// loginPage = PageFactory.initElements(driver, LoginTestPage.class);
		loginPage = PageFactory.initElements(driver, LoginTestPage.class);
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

		// Verifying successful login
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
		log.info("Valid login test passed.");

		loginPage.logout();
	}

	@Test(priority = 2, description = "Verify invalid login", retryAnalyzer = RetryAnalyzer.class, groups = {"regression"})
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
	public void tearDown() throws IOException {
		TestUtilClass.takeScreenshotAtEndOfTest();
		if (driver != null) {
			driver.quit();
			log.info("Browser closed.");
		}
	}
}
