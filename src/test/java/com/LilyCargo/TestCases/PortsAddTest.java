package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PortsAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Port",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Port successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.15_Ports")
    @Story("As a user, I should be able to Add/Create Port successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Port")
    public void VerifyPortsAddTestCase(){

        log = LogManager.getLogger(PortsAddTest.class);
        log.info("Starting Port Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickPortsFRSubMenu();
        log.info("Clicked Ports FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Ports", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Port Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Port", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterName(FakeDataUtil.getRandomAirPort());
        log.info("Entered Port Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterCode(FakeDataUtil.getRandomPortCode());
        log.info("Entered Port Code");

        pageObjectManager.getRelationsAllFieldsTestPage().enterAbbreviation(FakeDataUtil.getAbbreviation(FakeDataUtil.getRandomAirPort()));
        log.info("Entered Port Abbreviation");

        pageObjectManager.getGlobalMethodsPage().selectPortType("Airport");
        log.info("Selected Port Type");

        pageObjectManager.getRelationsAllFieldsTestPage().searchAndSelectCountry("CANADA");
        log.info("Selected Country Name");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Port Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Port successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}
