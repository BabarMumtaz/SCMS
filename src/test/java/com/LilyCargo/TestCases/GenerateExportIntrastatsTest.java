package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GenerateExportIntrastatsTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can generate and export cargo intrastats data successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can generate and export cargo intrastats data successfully")
    @Epic("Dashboard 01")
    @Feature("Feature:01.03_Intrastats")
    @Story("As a user, I should be able to generate and export cargo intrastats data successfully")
    @Step("Hit Site Url -> Login -> Dashboard > Intrastats -> Select LFR -> Generate & Export Cargo Data")
    public void VerifyIntrastatsReportTestCase() throws InterruptedException {

        log = LogManager.getLogger(GenerateExportIntrastatsTest.class);
        log.info("[Test01] Starting export generation from Dashboard > Intrastats");

        pageObjectManager.getMenuBar().clickDashboardMenu();
        log.info("[Test01] Clicked Dashboard > Freight Relations");

        pageObjectManager.getMenuBar().clickIntrastatsDashSubMenu();
        log.info("[Test01] Clicked Intrastats submenu");

        String mainPageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Main Page Heading is: {}", mainPageHeading);
        Assert.assertEquals(mainPageHeading, "Intrastats", "Page heading does not match expected value.");

        pageObjectManager.getIntrastatsPage().selectlfr();
        log.info("[Test01] Selected LFR from dropdown");

/*        pageObjectManager.getIntrastatsPage().selectMonth();
        log.info("Selected Month");

        pageObjectManager.getIntrastatsPage().selectZone();
        log.info("Selected Zone");

        pageObjectManager.getIntrastatsPage().selectClient();
        log.info("Selected Client"); */

        for (int month = 1; month <= 12; month++) {
            log.info("[Test01] Trying to generate with month: {}", month);
            pageObjectManager.getIntrastatsPage().selectMonthAndGenerate(month);

            if (pageObjectManager.getIntrastatsPage().isNoDataFoundVisible()) {
                log.info("[Test01] No data found for month: {}", month);
            } else {
                String foundMonth = pageObjectManager.getIntrastatsPage().getMonthFromFirstRow();
                log.info("[Test01] Data found for month: {}", foundMonth);

                pageObjectManager.getIntrastatsPage().clickExportIcon();
                pageObjectManager.getIntrastatsPage().clickFreightDataExportOption();
                log.info("[Test01] Exported Freight data for month: {}", foundMonth);

                String exportSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
                log.info("[Test01] Export Success Alert is: {}", exportSuccessAlert);
                Assert.assertEquals(exportSuccessAlert, "Data exported", "Success Alert does not match expected value.");


                pageObjectManager.getIntrastatsPage().clickOnAlertPopup();
                log.info("[Test01] Closed alert popup");

                pageObjectManager.getIntrastatsPage().clickExportIcon();
                pageObjectManager.getIntrastatsPage().clickCargoDataExportOption();
                log.info("[Test01] Exported Cargo data for month: {}", foundMonth);
                break;
            }
        }

        String exportSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("[Test01] Export Success Alert is: {}", exportSuccessAlert);
        Assert.assertEquals(exportSuccessAlert, "Data exported", "Success Alert does not match expected value.");

        pageObjectManager.getIntrastatsPage().clickOnAlertPopup();
        log.info("[Test01] Closed final alert");

    }


    @Test(priority = 2, description = "Verify that a user can generate and export freight + cargo intrastats data", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can generate and export both freight and cargo intrastats data")
    @Epic("EP001")
    @Feature("Feature:003")
    @Story("As a user, I should be able to generate and export freight and cargo intrastats data")
    @Step("Login -> Dashboard > Intrastats -> Select Fields -> Generate & Export Freight + Cargo Data")
    public void VerifyIntrastatsReportTestCase02() throws InterruptedException {

        log = LogManager.getLogger(GenerateExportIntrastatsTest.class);
        log.info("[Test02] Starting export generation from Dashboard > Intrastats");

        pageObjectManager.getMenuBar().clickDashboardMenu();
        log.info("[Test02] Clicked Dashboard > Freight Relations");

        pageObjectManager.getMenuBar().clickIntrastatsDashSubMenu();
        log.info("[Test02] Clicked Intrastats submenu");

        String mainPageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("[Test02] Main Page Heading is: {}", mainPageHeading);
        Assert.assertEquals(mainPageHeading, "Intrastats", "Page heading does not match expected value.");

        pageObjectManager.getIntrastatsPage().selectFields("NL LMLOG Fiscal Rep (Import)", "NL", "2025", "Amazon EU SARL, Dutch Branch");
        log.info("[Test02] Selected Fiscal Rep, Zone, Year, Client");

        for (int month = 1; month <= 12; month++) {
            log.info("[Test02] Trying to generate with month: {}", month);
            pageObjectManager.getIntrastatsPage().selectMonthAndGenerate(month);

            if (pageObjectManager.getIntrastatsPage().isNoDataFoundVisible()) {
                log.info("[Test02] No data found for month: {}", month);
            } else {
                String foundMonth = pageObjectManager.getIntrastatsPage().getMonthFromFirstRow();
                log.info("[Test02] Data found for month: {}", foundMonth);

                pageObjectManager.getIntrastatsPage().clickExportIcon();
                pageObjectManager.getIntrastatsPage().clickFreightDataExportOption();
                log.info("[Test02] Exported Freight data for month: {}", foundMonth);

                String exportSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
                log.info("[Test02] Export Success Alert is: {}", exportSuccessAlert);
                Assert.assertEquals(exportSuccessAlert, "Data exported", "Success Alert does not match expected value.");

                pageObjectManager.getIntrastatsPage().clickOnAlertPopup();
                log.info("[Test02] Closed alert popup");

                pageObjectManager.getIntrastatsPage().clickExportIcon();
                pageObjectManager.getIntrastatsPage().clickCargoDataExportOption();
                log.info("[Test02] Exported Cargo data for month: {}", foundMonth);
                break;
            }
        }

        String exportSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info(" [Test02] Export Success Alert is: {}", exportSuccessAlert);
        Assert.assertEquals(exportSuccessAlert, "Data exported", "Success Alert does not match expected value.");

        pageObjectManager.getIntrastatsPage().clickOnAlertPopup();
        log.info("[Test02] Closed final alert");

    }
}