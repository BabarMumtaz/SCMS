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
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to Add/Create User successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > Overview > Add User")
    public void VerifyUserAddTestCase(){

        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\profileImage.png";

        log = LogManager.getLogger(UserAddTest.class);
        log.info("Starting User Add Test from Administration.");

        pageObjectManager.getMenuBar().clickAdministrationMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickOverviewAdmSubMenu();
        log.info("Clicked User FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isAdminOverviewPageHeadingDisplayed(), "Heading Not Displayed");
        log.info("Admin Overview Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getOverviewPageHeading());

        pageObjectManager.getAdminOverviewTestPage().clickUserManagementBtn();
        log.info("Clicked User Management button");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isUserPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("User Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getUserPageHeading());

        pageObjectManager.getAdminOverviewTestPage().clickAddUserBtn();
        log.info("Clicked User Add button");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isUserAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("User Add Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getUserAddPageHeading());

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

        pageObjectManager.getAdminOverviewTestPage().selectRoles("Admin", "Master Admin (Super Admin)", "Role for Bob");
        log.info("Select roles");

        pageObjectManager.getAdminOverviewTestPage().clickSaveUserBack();
        log.info("Click Save User Button");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isUserSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getAdminOverviewTestPage().getUserSuccessAlertMessage());

        pageObjectManager.getAdminOverviewTestPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
