package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserChangePasswordAndLoginTest extends TestBeforeAndAfter {

    Logger log;
    String userEmail;
    String userPassword;

    @Test(priority = 1,
            description = "Change Password",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Change Password successfully")
    @Epic("Administration")
    @Feature("Feature:01.02.02_Overview_My Profile")
    @Story("As a user, I should be able to Change Password successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > Overview > My Profiles > Change Password")
    public void VerifyChangePasswordTestCase() {

        userEmail = "appelitpublicate@gmail.com";
        userPassword = "Test@123";

        log = LogManager.getLogger(UserChangePasswordAndLoginTest.class);
        log.info("Starting Change Password Test from Administration.");

        pageObjectManager.getMenuBar().clickAdministrationMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickOverviewAdmSubMenu();
        log.info("Clicked My Profile Sub Menu");

        String mainPageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Main Page Heading is: " + mainPageHeading);
        Assert.assertEquals(mainPageHeading, "Overview", "Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().clickMyProfileBtn();
        log.info("Clicked My Profile button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "My Profile", "Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().clickChangePasswordBtn();
        log.info("Clicked Change Password Btn");

        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: " + popupHeading);
        Assert.assertEquals(popupHeading, "Change Password", "Popup heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().enterUserPassword("secret123");
        log.info("Entered Current Password");

        pageObjectManager.getAdminOverviewTestPage().enterUserPassword(userPassword);
        log.info("Entered User New Password");

        pageObjectManager.getAdminOverviewTestPage().enterUserConfirmPassword(userPassword);
        log.info("Entered User Confirm Password");

        pageObjectManager.getGlobalMethodsPage().clickUpdateBtn();
        log.info("Click Update My Profile Button");

        String personalInfoSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + personalInfoSuccessAlert);
        Assert.assertEquals(personalInfoSuccessAlert, "Profile Updated successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }

    @Test(priority = 2, dependsOnMethods = "VerifyChangePasswordTestCase", description = "Login using the a changed password user", groups = {"login", "smoke", "regression"})
    public void loginWithChangedPasswordTest() {

        log.info("🔐 Attempting to log in with a changed password user: " + userEmail);

        pageObjectManager.getLoginPage().login(userEmail, userPassword);

        Assert.assertTrue(pageObjectManager.getLoginPage().isLoginSuccessful(), "❌ Login failed with a changed password user.");
        log.info("✅ Logged in successfully with a changed password user: " + userEmail);
    }
}