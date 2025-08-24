package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlAccountAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add Gl Account successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Gl Account successfully")
    @Epic("Finance 05")
    @Feature("Feature:05.03_Gl Account")
    @Story("As a user, I should be able to add Gl Account successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Finance > Add Gl Account")
    public void VerifyGlAccountAddTestCase() throws InterruptedException {

        log = LogManager.getLogger(GlAccountAddTest.class);
        log.info("Starting Gl Account Add Test from Finance.");

        pageObjectManager.getMenuBar().clickFinanceMenu();
        log.info("Clicked Finance Menu");

        pageObjectManager.getMenuBar().clickManageGlAccountsSubMenu();
        log.info("Clicked Gl Account Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Manage GL Account", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Gl Account Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add GL Account", "Add Page heading does not match expected value.");

        pageObjectManager.getFinanceAllFieldsTestPage().enterLedger(FakeDataUtil.getContents());
        log.info("Entered Ledger");

        pageObjectManager.getFinanceAllFieldsTestPage().enterDescription(FakeDataUtil.getDescription());
        log.info("Entered Description");

        pageObjectManager.getFinanceAllFieldsTestPage().enterType(FakeDataUtil.getDescription());
        log.info("Entered Type");

        pageObjectManager.getFinanceAllFieldsTestPage().enterBsProfitLoss(FakeDataUtil.getDescription());
        log.info("Entered Bs Profit Loss");

        Thread.sleep(2000);

        pageObjectManager.getGlobalMethodsPage().selectDebitCredit("Credit");
        log.info("Selected Credit");

        pageObjectManager.getGlobalMethodsPage().selectVatCode("2/21/21%");
        log.info("Selected Vat Code");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "GL Account successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
