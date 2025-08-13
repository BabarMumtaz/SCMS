package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add User",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add User successfully")
    @Epic("Administration")
    @Feature("Feature:01_Overview_User Management")
    @Story("As a user, I should be able to Add/Create User successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > Overview > Users > Add User")
    public void VerifyUserAddTestCase(){

        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\profileImage.png";

        log = LogManager.getLogger(UserAddTest.class);
        log.info("Starting User Add Test from Administration.");

        pageObjectManager.getMenuBar().clickAdministrationMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickOverviewAdmSubMenu();
        log.info("Clicked User Sub Menu");

        String mainPageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Overview");
        log.info("Main Page Heading is: " + mainPageHeading);
        Assert.assertEquals(mainPageHeading, "Overview", "Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().clickUserManagementBtn();
        log.info("Clicked User Management button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Users");
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Users", "Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().clickAddUserBtn();
        log.info("Clicked User Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add User", "Add Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().addUserProfileImage(filePath);

        pageObjectManager.getAdminOverviewTestPage().enterUserName(faker.company().name());
        log.info("Entered User Name");

        pageObjectManager.getAdminOverviewTestPage().enterUserEmail1(faker.internet().emailAddress());
        log.info("Entered User Email");

        pageObjectManager.getAdminOverviewTestPage().enterUserPassword("secret123");
        log.info("Entered User Password");

        pageObjectManager.getAdminOverviewTestPage().enterUserConfirmPassword("secret123");
        log.info("Entered User Confirm Password");

        pageObjectManager.getAdminOverviewTestPage().enterUserDepartment(faker.job().field());
        log.info("Selected User Department");

        pageObjectManager.getAdminOverviewTestPage().enterUserDutchPhoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered User Tel Number");

        pageObjectManager.getAdminOverviewTestPage().enterUserAddress(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getAdminOverviewTestPage().selectRolesByTyping("Admin", "Master Admin (Super Admin)", "Role for Bob");
        log.info("Selected All defined roles");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save User Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getSuccessAlertText("User successfully created.");
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "User successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
