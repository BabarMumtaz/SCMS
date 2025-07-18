package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GenerateExportIntrastatsTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can generate and export inrastats data successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can generate and export inrastats data successfully")
    @Epic("EP001")
    @Feature("Feature:003")
    @Story("As a user, I should be able to generate and export inrastats data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Dashboard > Intrastats")
    public void VerifyIntrastatsReportTestCase() throws InterruptedException {

        log = LogManager.getLogger(GenerateExportIntrastatsTest.class);
        log.info("Starting export data generation... from Dashboard > Inrastats");

        pageObjectManager.getMenuBar().clickDashboardMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickIntrastatsDashSubMenu();
        log.info("Clicked Carriers FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getIntrastatsPage().isIntrastatsPageHeadingDisplayed(), "Heading Not Displayed");
        log.info("Page Heading: " + pageObjectManager.getIntrastatsPage().getIntrastatsPageHeading());

        pageObjectManager.getIntrastatsPage().selectlfr();
        log.info("Selected LFR");

/*        pageObjectManager.getIntrastatsPage().selectMonth();
        log.info("Selected Month");

        pageObjectManager.getIntrastatsPage().selectZone();
        log.info("Selected Zone");

        pageObjectManager.getIntrastatsPage().selectClient();
        log.info("Selected Client");*/

        for (int month = 1; month <= 12; month++) {
            log.info("📅 Trying with month: " + month);
            pageObjectManager.getIntrastatsPage().selectMonthAndGenerate(month);

            if (pageObjectManager.getIntrastatsPage().isNoDataFoundVisible()) {
                log.info("❌ No data found for month: " + month);
            } else {
                String foundMonth = pageObjectManager.getIntrastatsPage().getMonthFromFirstRow();
                log.info("✅ Data found for month: " + foundMonth);
                pageObjectManager.getIntrastatsPage().clickExportIcon();
                pageObjectManager.getIntrastatsPage().clickFreightDataExportOption();
                log.info("📤 Exported data for month: " + foundMonth);
                break;
            }
        }

        Assert.assertTrue(pageObjectManager.getIntrastatsPage().isExportDataSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getIntrastatsPage().getExportDataSuccessAlertMessage());

        pageObjectManager.getIntrastatsPage().clickOnAlertPopup();
        log.info("Clicked Cross icon of Alert");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}