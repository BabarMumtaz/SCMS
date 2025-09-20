package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoleAddEditTest extends TestBeforeAndAfter {

    Logger log;

    private void navigateToRoleManagement() {
        log = LogManager.getLogger(RoleAddEditTest.class);
        log.info("Starting Role Add Test from Administration.");

        pageObjectManager.getMenuBar().clickAdministrationMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickOverviewAdmSubMenu();
        log.info("Clicked Role Sub Menu");

        String mainPageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Overview");
        log.info("Main Page Heading is: " + mainPageHeading);
        Assert.assertEquals(mainPageHeading, "Overview", "Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().clickUserManagementBtn();
        log.info("Clicked User Management button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Users");
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Users", "Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().clickRoleListingBtn();
        log.info("Clicked Role Management button");

        String rolePageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Roles");
        log.info("Page Heading is: " + rolePageHeading);
        Assert.assertEquals(rolePageHeading, "Roles", "Page heading does not match expected value.");
    }

    @Test(priority = 1, description = "Create a new Role", groups = {"smoke", "regression"}, enabled = false)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Role successfully")
    @Epic("Administration")
    @Feature("Feature:01.2_Overview_User Management_Create Role and Edit")
    @Story("As a Role, I should be able to Add/Create Role successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > Overview > Roles > Add Role")
    public void createRoleTest() {

        navigateToRoleManagement();

        pageObjectManager.getAdminOverviewTestPage().clickAddRoleBtn();
        log.info("Clicked Role Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add User", "Add Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().enterRoleName(faker.name().fullName());
        log.info("Entered Role Name");

        pageObjectManager.getAdminOverviewTestPage().clickRoleAssignAllCheckbox();
        log.info("Checked All roles");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save User Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getSuccessAlertText("User successfully created.");
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "User successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");


    }

    @Test(priority = 2, description = "Verify that a user can Edit Role successfully", enabled = true)
    public void editRoleTest() throws InterruptedException {

        navigateToRoleManagement();

        pageObjectManager.getGlobalMethodsPage().hoverAndClickIconOnRow(1, "View");
        log.info("Hover over on A row and click View Icon");

        Assert.assertTrue(pageObjectManager.getGlobalMethodsPage().isViewPageDisplayed(), "View Page is not Displayed");

        pageObjectManager.getGlobalMethodsPage().clickOnEditBtn();
        log.info("Clicked on Edit button on view page");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isRoleUpdatePageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("User Edit Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getRoleUpdatePageHeading());

        pageObjectManager.getAdminOverviewTestPage().scrollToElement();

        pageObjectManager.getAdminOverviewTestPage().clickRoleDashboardCheckbox();
        log.info("UnChecked Dashboard roles");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save User Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getSuccessAlertText("User successfully created.");
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "User successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}
