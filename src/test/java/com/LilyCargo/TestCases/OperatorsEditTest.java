package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OperatorsEditTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Edit Operator",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Edit Operator successfully")
    @Epic("Administration 02")
    @Feature("Feature:02.05_Operator")
    @Story("As a user, I should be able to Edit Operator successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > Operator > Edit Operator")
    public void VerifyOperatorsEditTestCase() {

        log = LogManager.getLogger(OperatorsEditTest.class);
        log.info("Starting Edit Operator Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickAdministrationMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickOperatorsAdminSubMenu();
        log.info("Clicked Operators Sub Menu");

        String mainPageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Main Page Heading is: " + mainPageHeading);
        Assert.assertEquals(mainPageHeading, "Operators", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickEditDetailsBtn();
        log.info("Clicked Edit Btn of LMAAS Operator");

        String operator01PopupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: " + operator01PopupHeading);
        Assert.assertEquals(operator01PopupHeading, "Update Operator: LMAAS", "Popup heading does not match expected value.");

        pageObjectManager.getHsTriggersPage().enterHsCode(FakeDataUtil.getHsCode(10));
        log.info("Entered Dump Duty HS Code");

        pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
        log.info("Clicked Submit Button");

        String operator01SuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Operator 01 Success Alert is: " + operator01SuccessAlert);
        Assert.assertEquals(operator01SuccessAlert, "Operator successfully updated.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

        /** ---------- Operator 02 ---------- */

        pageObjectManager.getGlobalMethodsPage().clickEditDetailsBtn();
        log.info("Clicked Edit Btn of LMLOG Operator");

        String operator02PopupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: " + operator02PopupHeading);
        Assert.assertEquals(operator02PopupHeading, "Update Operator: LMLOG", "Popup heading does not match expected value.");

        pageObjectManager.getHsTriggersPage().enterHsCode(FakeDataUtil.getHsCode(10));
        log.info("Entered Dump Duty HS Code");

        pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
        log.info("Clicked Submit Button");

        String operator02SuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Operator 02 Success Alert is: " + operator02SuccessAlert);
        Assert.assertEquals(operator02SuccessAlert, "Operator successfully updated.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}