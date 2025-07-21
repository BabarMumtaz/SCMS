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
    @Epic("EP001")
    @Feature("Feature:003")
    @Story("As a user, I should be able to add International Products successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Finance > Add International Products")
    public void VerifyInternationalProductCreation() throws InterruptedException {

        log = LogManager.getLogger(InternationalProductsAddTest.class);
        log.info("Starting International Products Add Test from Finance.");

        pageObjectManager.getMenuBar().clickFinanceMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickInternationalProductsSubMenu();
        log.info("Clicked International Products Sub Menu");

        Assert.assertTrue(pageObjectManager.getInternationalProductsPage().isIntlProductsPageHeadingDisplayed(), "Heading Not Displayed");
        log.info("Page Heading: " + pageObjectManager.getInternationalProductsPage().getIntlProductsPageHeading());

        pageObjectManager.getInternationalProductsPage().clickAddIntlProductsBtn();
        log.info("Clicked International Products Add button");

        pageObjectManager.getInternationalProductsPage().enterPid(FakeDataUtil.getPidNo());
        log.info("Entered PID");

        pageObjectManager.getInternationalProductsPage().enterLmgbrIn(FakeDataUtil.getContents());
        log.info("Entered Lmgbr In");

        pageObjectManager.getInternationalProductsPage().enterLmgbrOut(FakeDataUtil.getContents());
        log.info("Entered Lmgbr Out");

        pageObjectManager.getInternationalProductsPage().selectVatCode();
        log.info("Selected Vat Code");

        pageObjectManager.getInternationalProductsPage().enterDescription(FakeDataUtil.getRemarks());
        log.info("Entered Description");

        pageObjectManager.getInternationalProductsPage().enterSort(FakeDataUtil.getRemarks());
        log.info("Entered Sort");

        pageObjectManager.getInternationalProductsPage().enterPrice(FakeDataUtil.getContents());
        log.info("Entered Price");

        pageObjectManager.getInternationalProductsPage().clickSaveIntlProductBack();
        log.info("Click Save International Products Button");

        Assert.assertTrue(pageObjectManager.getInternationalProductsPage().isIntlProductSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getInternationalProductsPage().getIntlProductSuccessAlertMessage());

        pageObjectManager.getInternationalProductsPage().clickOnAlertPopupDP();
        log.info("Clicked Cross icon of Alert");

    }
}