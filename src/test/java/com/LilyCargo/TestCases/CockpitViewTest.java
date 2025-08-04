package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CockpitViewTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add User",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can view Cockpit Data successfully, Extract and save Cockpit summary")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to view Cockpit Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Dashboard > Cockpit")
    public void VerifyCockpitViewTestCase(){
        
        log = LogManager.getLogger(CockpitViewTest.class);
        log.info("Starting Test from Cockpit.");

        pageObjectManager.getMenuBar().clickDashboardMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickCockpitDashSubMenu();
        log.info("Clicked Cockpit Sub Menu");

        Assert.assertTrue(pageObjectManager.getCockpitPage().isPageHeadingDisplayed(), "Heading Not Displayed");
        log.info("Cockpit Page Heading: " + pageObjectManager.getCockpitPage().getPageHeading());

        // ✅ Fetch and print card data
        //pageObjectManager.getCockpitPage().extractAndSaveAllCockpitTriggersData();

        List<String> summaries = pageObjectManager.getCockpitPage().processCockpitTriggers(3);  // Click first 15 triggers

        for (String s : summaries) {
            System.out.println(s);
        }
    }
}

