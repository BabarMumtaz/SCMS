package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EuropeanProductsAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add European Products successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add European Products successfully")
    @Epic("Finance 05")
    @Feature("Feature:05.02_European Product")
    @Story("As a user, I should be able to add European Products successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Finance > Add European Products")
    public void VerifyEuropeanProductsAddTestCase(){

        log = LogManager.getLogger(EuropeanProductsAddTest.class);
        log.info("Starting European Products Add Test from Finance.");

        pageObjectManager.getMenuBar().clickFinanceMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickEuropeanProductsSubMenu();
        log.info("Clicked European Products Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "European Products", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked European Products Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add European Product Service", "Add Page heading does not match expected value.");

        pageObjectManager.getFinanceAllFieldsTestPage().enterPid(FakeDataUtil.getEuPidNo());
        log.info("Entered PID");

        pageObjectManager.getFinanceAllFieldsTestPage().enterLmgbrIn(FakeDataUtil.getContents());
        log.info("Entered Lmgbr In");

        pageObjectManager.getFinanceAllFieldsTestPage().enterLmgbrOut(FakeDataUtil.getContents());
        log.info("Entered Lmgbr Out");

        pageObjectManager.getGlobalMethodsPage().selectVatCode("2/21/21%");
        log.info("Selected Vat Code");

        pageObjectManager.getFinanceAllFieldsTestPage().enterDescription(FakeDataUtil.getRemarks());
        log.info("Entered Description");

        pageObjectManager.getFinanceAllFieldsTestPage().enterSort(FakeDataUtil.getRemarks());
        log.info("Entered Sort");

        pageObjectManager.getFinanceAllFieldsTestPage().enterPrice(FakeDataUtil.getContents());
        log.info("Entered Price");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Product Service successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
