package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class LmTeamAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Lm Team",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Lm Team successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.12_Lm Team")
    @Story("As a user, I should be able to Add/Create Lm Team successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Lm Team")
    public void VerifyLmTeamAddTestCase(){

        log = LogManager.getLogger(LmTeamAddTest.class);
        log.info("Starting Lm Team Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickLmTeamFRSubMenu();
        log.info("Clicked Lm Team FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Lm Team", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Lm Team Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add LM Team", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterName(faker.name().name());
        log.info("Entered Lm Team Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterPosition(faker.company().profession());
        log.info("Entered Lm Team Position");

        pageObjectManager.getRelationsAllFieldsTestPage().enterTelephoneNumber(FakeDataUtil.getDutchPhoneNumber());
        log.info("Entered Lm Team Telephone Number");

        pageObjectManager.getRelationsAllFieldsTestPage().enterEmail(faker.internet().emailAddress());
        log.info("Entered Lm Team Email");

        pageObjectManager.getRelationsAllFieldsTestPage().selectPayrollEndsDate();
        log.info("Entered Lm Team Pay Roll Date: Current Date");

        pageObjectManager.getRelationsAllFieldsTestPage().selectOfficeAccessStartDate();
        log.info("Entered Lm Team Start DATE: Current Date");

        pageObjectManager.getRelationsAllFieldsTestPage().selectOfficeAccessEndDate();
        log.info("Entered Lm Team End DATE: 1 year from now");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Clicked ALl Extra Fields Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Lm Team Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "LM Team successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
