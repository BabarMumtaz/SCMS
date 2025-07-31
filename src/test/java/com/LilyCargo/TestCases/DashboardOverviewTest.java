package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardOverviewTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add User",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can view Dashboard Data successfully, Extract and save dashboard summary")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to view Dashboard Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Dashboard > Overview > view Dashboard Data")
    public void VerifyDashboardOverviewTestCase(){


        log = LogManager.getLogger(DashboardOverviewTest.class);
        log.info("Starting Test from Dashboard.");

        pageObjectManager.getMenuBar().clickDashboardMenu();
        log.info("Clicked Administration Menu");

        // Store current tab
        pageObjectManager.getDashboardOverviewTestPage().storeParentWindow();

        pageObjectManager.getMenuBar().clickOverviewDashboardSubMenu();
        log.info("Clicked Overview Dashboard Sub Menu");

        pageObjectManager.getDashboardOverviewTestPage().switchToNewTab();
        log.info("Switched to the new tab");

        Assert.assertTrue(pageObjectManager.getDashboardOverviewTestPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Dashboard Overview Page Heading: " + pageObjectManager.getDashboardOverviewTestPage().getPageHeading());

/*        String summary = pageObjectManager.getDashboardOverviewTestPage().getCustomsEntriesSummary();
        // Print to console
        System.out.println(summary);*/

        // ✅ Fetch and print card data
        pageObjectManager.getDashboardOverviewTestPage().extractAndSaveAllStatsCardsData();

        // Close dashboard window
        driver.close();
        log.info("❌ Closed dashboard window");

        // Switch back to main window
        pageObjectManager.getDashboardOverviewTestPage().switchBackToOriginalTab();

    }
}
