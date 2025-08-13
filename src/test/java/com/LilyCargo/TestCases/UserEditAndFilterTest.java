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

        String mainPageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Overview");
        log.info("Main Page Heading is: " + mainPageHeading);
        Assert.assertEquals(mainPageHeading, "Overview", "Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().clickUserManagementBtn();
        log.info("🧭 Clicked User Management button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Users");
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Users", "Page heading does not match expected value.");
    }

    @Test(priority = 1,
            description = "Add User",
            groups = {"smoke", "regression"},
            enabled = true)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can edit User successfully")
    @Epic("Administration")
    @Feature("Feature:01.3_Overview_User Management_User Edit")
    @Story("As a user, I should be able to edit User successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > Overview > Users > Edit User")
    public void VerifyUserEditAndFilterTestCase() {

        navigateToUserManagement();

/*      This works too...
        pageObjectManager.getGlobalMethodsPage().hoverOnUser1stRow();
        log.info("Hover over 1st Row");

        pageObjectManager.getGlobalMethodsPage().clickOnViewIcon();
        log.info("Hover over View Icon and click");
*/
        pageObjectManager.getGlobalMethodsPage().hoverAndClickIconOnRow(0, "View");
        log.info("Hover over on A row and click View Icon");

        Assert.assertTrue(pageObjectManager.getGlobalMethodsPage().isViewPageDisplayed(), "View Page is not Displayed");

        pageObjectManager.getGlobalMethodsPage().clickOnEditBtn();
        log.info("Clicked on Edit button on view page");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Update Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Update User", "Add Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().selectGender("Female");
        log.info("✅ Female Gender dropdowns selected successfully");

        pageObjectManager.getAdminOverviewTestPage().enterUserDesignation(faker.job().position());
        log.info("Selected User Designation");

        pageObjectManager.getGlobalMethodsPage().selectStatus("InActive");
        log.info("✅ InActive Status selected successfully");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save User Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getSuccessAlertText("User successfully updated.");
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "User successfully updated.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }

    @Test(priority = 2, description = "Verify records have status Active by default",
            enabled = false)
    public void testActiveStatusFilter() throws InterruptedException {
        navigateToUserManagement();
        Assert.assertTrue(pageObjectManager.getGlobalMethodsPage().isAllRowsMatchingStatus("Active"), "❌ Status is not 'Active' for all records");
    }

    @Test(priority = 3, description = "Verify records have status Inactive after filtering",
            enabled = false)
    public void testInactiveStatusFilter() throws InterruptedException {
        navigateToUserManagement();
        pageObjectManager.getGlobalMethodsPage().applyStatusFilter("Inactive");
        Assert.assertTrue(pageObjectManager.getGlobalMethodsPage().isAllRowsMatchingStatus("Inactive"), "❌ Status is not 'Inactive' for all records");
    }

    @Test(priority = 4, description = "Verify records have status Blocked after filtering", enabled = false)
    public void testBlockedStatusFilter() throws InterruptedException {
        navigateToUserManagement();
        pageObjectManager.getGlobalMethodsPage().applyStatusFilter("Blocked");
        Assert.assertTrue(pageObjectManager.getGlobalMethodsPage().isAllRowsMatchingStatus("Blocked"), "❌ Status is not 'Blocked' for all records");
    }

}
