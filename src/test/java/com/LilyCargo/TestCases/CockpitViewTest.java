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

        Assert.assertTrue(pageObjectManager.getCockpitPage().isPageHeadingDisplayed(), "Heading Not Displayed");
        log.info("Cockpit Page Heading: " + pageObjectManager.getCockpitPage().getPageHeading());

        Assert.assertTrue(pageObjectManager.getCockpitPage().isCustomsEntriesTriggerHeadingDisplayed(), "Trigger Heading Not Displayed");
        log.info("Cockpit Page Heading: " + pageObjectManager.getCockpitPage().getCustomsEntriesTriggerHeading());
    }

    @Test(priority = 0,
            description = "Add User",
            groups = {"smoke", "regression"},
            enabled = true)
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
}

