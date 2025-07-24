package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserEditAndFilterTest extends TestBeforeAndAfter {

    Logger log;

    private void navigateToUserManagement() {
        log = LogManager.getLogger(UserEditAndFilterTest.class);
        log.info("🔁 Navigating to User Management from Administration...");

        pageObjectManager.getMenuBar().clickAdministrationMenu();
        log.info("🧭 Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickOverviewAdmSubMenu();
        log.info("🧭 Clicked Overview Sub Menu");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isAdminOverviewPageHeadingDisplayed(), "❌ Admin Overview Page Heading not displayed");
        log.info("✅ Admin Overview Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getOverviewPageHeading());

        pageObjectManager.getAdminOverviewTestPage().clickUserManagementBtn();
        log.info("🧭 Clicked User Management button");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isUserPageHeadingDisplayed(), "❌ User Page Heading not displayed");
        log.info("✅ User Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getUserPageHeading());
    }

    @Test(priority = 1,
            description = "Add User",
            groups = {"smoke", "regression"},
            enabled = false)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add User successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to Add/Create User successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > Overview > Add User")
    public void VerifyUserEditAndFilterTestCase() {

        navigateToUserManagement();

/*      This works too...
        pageObjectManager.getAdminOverviewTestPage().hoverOnUser1stRow();
        log.info("Hover over 1st Row");

        pageObjectManager.getAdminOverviewTestPage().clickOnViewUserIcon();
        log.info("Hover over View Icon and click");
*/
        pageObjectManager.getAdminOverviewTestPage().hoverAndClickIconOnRow(0, "View");
        log.info("Hover over on A row and click View Icon");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isUserViewPageDisplayed(), "View Page is not Displayed");

        pageObjectManager.getAdminOverviewTestPage().clickOnEditUserBtn();
        log.info("Clicked on Edit button on view page");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isUserUpdatePageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("User Edit Page Heading: " + pageObjectManager.getAdminOverviewTestPage().getUserUpdatePageHeading());

        pageObjectManager.getAdminOverviewTestPage().selectGender("Female");
        log.info("✅ Female Gender dropdowns selected successfully");

        pageObjectManager.getAdminOverviewTestPage().enterUserDesignation(faker.job().position());
        log.info("Selected User Designation");

        pageObjectManager.getAdminOverviewTestPage().selectStatus("InActive");
        log.info("✅ InActive Status selected successfully");

        pageObjectManager.getAdminOverviewTestPage().clickSaveUserBack();
        log.info("Click Save User Button");

        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isUpdateUserSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getAdminOverviewTestPage().getUpdatedUserSuccessAlertMessage());

        pageObjectManager.getAdminOverviewTestPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }

    @Test(priority = 2, description = "Verify records have status Active by default",
            enabled = true)
    public void testActiveStatusFilter() throws InterruptedException {
        navigateToUserManagement();
        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isAllRowsMatchingStatus("Active"), "❌ Status is not 'Active' for all records");
    }

    @Test(priority = 3, description = "Verify records have status Inactive after filtering",
            enabled = true)
    public void testInactiveStatusFilter() throws InterruptedException {
        navigateToUserManagement();
        pageObjectManager.getAdminOverviewTestPage().applyStatusFilter("Inactive");
        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isAllRowsMatchingStatus("Inactive"), "❌ Status is not 'Inactive' for all records");
    }

    @Test(priority = 4, description = "Verify records have status Blocked after filtering", enabled = true)
    public void testBlockedStatusFilter() throws InterruptedException {
        navigateToUserManagement();
        pageObjectManager.getAdminOverviewTestPage().applyStatusFilter("Blocked");
        Assert.assertTrue(pageObjectManager.getAdminOverviewTestPage().isAllRowsMatchingStatus("Blocked"), "❌ Status is not 'Blocked' for all records");
    }

}
