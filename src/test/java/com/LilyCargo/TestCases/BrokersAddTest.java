package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokersAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Brokers",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Broker successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.07_Brokers")
    @Story("As a user, I should be able to Add/Create Broker successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Brokers Relation > Add Broker")
    public void VerifyBrokersAddTestCase(){

        log = LogManager.getLogger(BrokersAddTest.class);
        log.info("Starting Brokers Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickBrokersFRSubMenu();
        log.info("Clicked Brokers FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is:{}", pageHeading);
        Assert.assertEquals(pageHeading, "Brokers", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Brokers Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is:{}", addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Broker", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterName(faker.company().name());
        log.info("Entered Brokers Company Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterContactPerson(faker.company().name());
        log.info("Entered Brokers Contact Person");

        pageObjectManager.getRelationsAllFieldsTestPage().enterTelephoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Brokers Tel Number");

        pageObjectManager.getRelationsAllFieldsTestPage().enterEmail(faker.internet().emailAddress());
        log.info("Entered Brokers Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getRelationsAllFieldsTestPage().enterZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getGlobalMethodsPage().selectCountryName("CHINA");
        log.info("Selected Country");

        pageObjectManager.getRelationsAllFieldsTestPage().enterVatNumber(FakeDataUtil.getString());
        log.info("Entered Brokers Vat");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Field Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Brokers Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is:{}", successAlert);
        Assert.assertEquals(successAlert, "Broker successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}
