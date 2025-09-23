package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InternationalProductsAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add International Products successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add International Products successfully")
    @Epic("Finance 05")
    @Feature("Feature:05.01_International Product")
    @Story("As a user, I should be able to add International Products successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Finance > Add International Products")
    public void VerifyInternationalProductAddTestCase(){

        log = LogManager.getLogger(InternationalProductsAddTest.class);
        log.info("Starting International Products Add Test from Finance.");

        pageObjectManager.getMenuBar().clickFinanceMenu();
        log.info("Clicked Finance Menu");

        pageObjectManager.getMenuBar().clickInternationalProductsSubMenu();
        log.info("Clicked International Products Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "International Products", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked International Products Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", addPageHeading);
        Assert.assertEquals(addPageHeading, "Add International Product Service", "Add Page heading does not match expected value.");

        pageObjectManager.getFinanceAllFieldsTestPage().enterPid(FakeDataUtil.getIntlPidNo());
        log.info("Entered PID");

        pageObjectManager.getFinanceAllFieldsTestPage().enterLmgbrIn(FakeDataUtil.getNumberWithoutDecimal());
        log.info("Entered Lmgbr In");

        pageObjectManager.getFinanceAllFieldsTestPage().enterLmgbrOut(FakeDataUtil.getNumberWithoutDecimal());
        log.info("Entered Lmgbr Out");

        pageObjectManager.getGlobalMethodsPage().selectVatCode("2/21/21%");
        log.info("Selected Vat Code");

        pageObjectManager.getFinanceAllFieldsTestPage().enterDescription(FakeDataUtil.getRemarks());
        log.info("Entered Description");

        pageObjectManager.getFinanceAllFieldsTestPage().enterSort(FakeDataUtil.getRemarks());
        log.info("Entered Sort");

        pageObjectManager.getFinanceAllFieldsTestPage().enterPrice(FakeDataUtil.getNumberWithoutDecimal());
        log.info("Entered Price");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Product Service successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}
