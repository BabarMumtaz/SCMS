package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.RetryAnalyzer;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginUsingConfigFileTest extends TestBeforeAndAfter {

	Logger log = LogManager.getLogger(LoginUsingConfigFileTest.class);

	@Test(priority = 1, description = "Verify valid login", retryAnalyzer = RetryAnalyzer.class, groups = {"login", "smoke", "regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a valid user can login")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Valid login")
	@Step("Perform login with valid credentials")
	public void validLoginTest() {
		pageObjectManager.getLoginPage().login(prop.getProperty("username1"), prop.getProperty("password"));

		// Verifying successful login
		Assert.assertTrue(pageObjectManager.getLoginPage().isLoginSuccessful(), "Login failed!");
		log.info("Valid login test passed.");
		pageObjectManager.getLoginPage().logout();
	}

	@Test(priority = 2, description = "Verify invalid login", groups = {"login", "regression"})
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify that an invalid user cannot login")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Invalid login")
	@Step("Perform login with invalid credentials")
	public void invalidLoginTest() {
		pageObjectManager.getLoginPage().login(prop.getProperty("usernameInV"), prop.getProperty("passwordInV"));

		// Verifying unsuccessful login
		Assert.assertTrue(pageObjectManager.getLoginPage().isLoginFailed(), "Login should have failed!");
		log.info("Invalid login test passed with error: " + pageObjectManager.getLoginPage().getErrorMessage());
	}
}