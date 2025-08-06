package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CockpitViewTest extends TestBeforeAndAfter {

    Logger log;

    private void navigateToCockpit() {

        log = LogManager.getLogger(CockpitViewTest.class);
        log.info("Starting Test from Cockpit.");

        pageObjectManager.getMenuBar().clickDashboardMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickCockpitDashSubMenu();
        log.info("Clicked Cockpit Sub Menu");

        Assert.assertTrue(pageObjectManager.getCockpitPage().isCockpitHeadingDisplayed(), "❌ Cockpit heading is not displayed!");
        Assert.assertEquals(pageObjectManager.getCockpitPage().getPageHeading(), "Cockpit", "❌ Heading text does not match!");
        log.info("✅ Cockpit heading verified successfully.");

        Assert.assertTrue(pageObjectManager.getCockpitPage().isCustomsEntriesTriggerHeadingDisplayed(), "Trigger Heading Not Displayed");
        log.info("Cockpit Page Heading: " + pageObjectManager.getCockpitPage().getCustomsEntriesTriggerHeading());
    }

    @Test(priority = 0,
            description = "Add User",
            groups = {"smoke", "regression"},
            enabled = false)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can view Cockpit Data successfully, Extract and save Cockpit summary")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to view Cockpit Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Dashboard > Cockpit")
    public void VerifyCockpitTriggersListTestCase(){

        navigateToCockpit();

        pageObjectManager.getCockpitPage().extractAndSaveAllCockpitTriggersData();

    }

    @Test(priority = 1,
            description = "Add User",
            groups = {"smoke", "regression"},
            enabled = false)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can view Cockpit Data successfully, Extract and save Cockpit summary")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to view Cockpit Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Dashboard > Cockpit")
    public void VerifyCockpitTriggersDynamicListingTestCase(){

        navigateToCockpit();

        pageObjectManager.getCockpitPage().processCockpitTriggers(3);  // Click first 3 triggers
    }

    @Test(priority = 2, description = "Verify Cockpit Tabs",
            enabled = true)
    public void verifyCockpitTabs() {

        navigateToCockpit();

        pageObjectManager.getCockpitPage().clickTab("Low Margin Projection");
        log.info("✅ Low Margin Projection tab clicked.");
        Assert.assertTrue(pageObjectManager.getCockpitPage().isLowMarginProjectionListingDateCellDisplayed(), "❌ Low Margin Projection Listing Cell not displayed!");

        pageObjectManager.getCockpitPage().clickTab("Latest Incident Registrations");
        log.info("✅ Latest Incident Registrations tab clicked.");
        Assert.assertTrue(pageObjectManager.getCockpitPage().isLatestIncidentListingDateCellDisplayed(), "❌ Latest Incident Registrations Listing Cell not displayed!");

        pageObjectManager.getCockpitPage().clickTab("Daily Import Duty");
        log.info("✅ Daily Import Duty tab clicked.");
        Assert.assertTrue(pageObjectManager.getCockpitPage().isDailyImportDutyListingDateCellDisplayed(), "❌ Daily Import Duty Listing Cell not displayed!");

        pageObjectManager.getCockpitPage().clickDailyImportDutyFidExportIcon();
        log.info("✅ Daily Import Duty Download FID icon clicked.");

        pageObjectManager.getCockpitPage().clickTab("Latest Added Plato");
        log.info("✅ Latest Added Plato tab clicked.");
        Assert.assertTrue(pageObjectManager.getCockpitPage().isLatestAddedPlatoListingDateCellDisplayed(), "❌ Latest Added Plato Listing Cell not displayed!");
    }
}

