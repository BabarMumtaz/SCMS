package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountriesAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Country",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Country successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.15_Countries")
    @Story("As a user, I should be able to Add/Create Country successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Country")
    public void VerifyCountriesAddTestCase(){

        log = LogManager.getLogger(CountriesAddTest.class);
        log.info("Starting Country Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickCountriesFRSubMenu();
        log.info("Clicked Countries FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Countries", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Country Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Country", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterName(FakeDataUtil.getRandomCountry());// New method for Dutch phone number
        log.info("Entered Country Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterCode(FakeDataUtil.getRandomCountryCode()); // New method for Dutch phone number
        log.info("Entered Country Code");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Country Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Country successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}
