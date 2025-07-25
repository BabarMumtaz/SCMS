package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoleAddEditTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Create a new Role", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Role successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a Role, I should be able to Add/Create Role successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > Overview > Add Role")
    public void createRoleTest() {

        log = LogManager.getLogger(RoleAddEditTest.class);
        log.info("Starting Role Add Test from Administration.");

        pageObjectManager.getMenuBar().clickAdministrationMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickOverviewAdmSubMenu();
        log.info("Clicked Role Sub Menu");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isAdminOverviewPageHeadingDisplayed(), "Heading Not Displayed");
        log.info("Admin Overview Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getOverviewPageHeading());

        pageObjectManager.getAdminOverviewTestPage().clickUserManagementBtn();
        log.info("Clicked User Management button");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isUserPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("User Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getUserPageHeading());

        pageObjectManager.getAdminOverviewTestPage().clickRoleListingBtn();
        log.info("Clicked Role Management button");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isRolePageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("Role Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getRolePageHeading());

        pageObjectManager.getAdminOverviewTestPage().clickAddRoleBtn();
        log.info("Clicked Role Add button");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isRoleAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("Role Add Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getRoleAddPageHeading());

        pageObjectManager.getAdminOverviewTestPage().enterRoleName(faker.name().fullName());
        log.info("Entered Role Name");

        pageObjectManager.getAdminOverviewTestPage().clickRoleAssignAllCheckbox();
        log.info("Checked All roles");

        pageObjectManager.getAdminOverviewTestPage().clickSaveUserBack();
        log.info("Click Save Role Button");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isRoleSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getAdminOverviewTestPage().getRoleSuccessAlertMessage());

        pageObjectManager.getAdminOverviewTestPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
