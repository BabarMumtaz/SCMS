package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserAndLoginTest extends TestBeforeAndAfter {

    Logger log;
    String userEmail;
    String userPassword;

    @Test(priority = 1, description = "Create a new user with random credentials", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add User successfully")
    @Epic("Administration")
    @Feature("Feature:01.2_Overview_User Management_Create User and Login")
    @Story("As a user, I should be able to Add/Create User successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > Overview > Users > Add User")
    public void createUserTest() {

        Faker faker = new Faker();
        userEmail = faker.internet().emailAddress();
        userPassword = "Test@123";

        log = LogManager.getLogger(CreateUserAndLoginTest.class);
        log.info("Starting User Add Test from Administration.");

        pageObjectManager.getMenuBar().clickAdministrationMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickOverviewAdmSubMenu();
        log.info("Clicked User FR Sub Menu");

        String mainPageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Overview");
        log.info("Main Page Heading is: {}", mainPageHeading);
        Assert.assertEquals(mainPageHeading, "Overview", "Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().clickUserManagementBtn();
        log.info("Clicked User Management button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Users");
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Users", "Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().clickAddUserBtn();
        log.info("Clicked User Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", addPageHeading);
        Assert.assertEquals(addPageHeading, "Add User", "Add Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().enterUserName(faker.name().fullName());
        log.info("Entered User Name");

        userEmail = faker.internet().emailAddress();
        pageObjectManager.getAdminOverviewTestPage().enterUserEmail1(userEmail);
        log.info("Entered User Email");

        pageObjectManager.getAdminOverviewTestPage().enterUserPassword(userPassword);
        log.info("Entered User Password");

        pageObjectManager.getAdminOverviewTestPage().enterUserConfirmPassword(userPassword);
        log.info("Entered User Confirm Password");

        pageObjectManager.getAdminOverviewTestPage().selectRolesByTyping("Admin", "Master Admin (Super Admin)", "Role for Bob");
        log.info("Selected All defined roles");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save User Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getSuccessAlertText("User successfully created.");
        log.info("Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "User successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }

    @Test(priority = 2, dependsOnMethods = "createUserTest", description = "Login using the newly created user", groups = {"login", "smoke", "regression"})
    public void loginWithNewUserTest() {

        log.info("🔐 Attempting to log in with newly created user: {}", userEmail);

        pageObjectManager.getLoginPage().login(userEmail, userPassword);

        Assert.assertTrue(pageObjectManager.getLoginPage().isLoginSuccessful(), "❌ Login failed with new user.");
        log.info("✅ Logged in successfully with new user: {}", userEmail);
    }
}