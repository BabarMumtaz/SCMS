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
    @Epic("Freight Relations")
    @Feature("Feature:07")
    @Story("As a user, I should be able to Add/Create Broker successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Brokers Relation > Add Broker")
    public void VerifyBrokersAddTestCase(){

        log = LogManager.getLogger(BrokersAddTest.class);
        log.info("Starting Brokers Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickBrokersFRSubMenu();
        log.info("Clicked Brokers FR Sub Menu");

        // Works for ANY page heading
        String pageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Brokers");
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Brokers", "Page heading does not match expected value.");

        pageObjectManager.getBrokersPage().clickAddBrokersBtn();
        log.info("Clicked Brokers Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Broker", "Add Page heading does not match expected value.");

        pageObjectManager.getBrokersPage().enterBrokersName(faker.company().name());
        log.info("Entered Brokers Company Name");

        pageObjectManager.getBrokersPage().enterContactPerson(faker.company().name());
        log.info("Entered Brokers Contact Person");

        pageObjectManager.getBrokersPage().enterBrokersDutchPhoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Brokers Tel Number");

        pageObjectManager.getBrokersPage().enterBrokersEmail(faker.internet().emailAddress());
        log.info("Entered Brokers Email");

        pageObjectManager.getBrokersPage().enterBrokersAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getBrokersPage().enterBrokersZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getGlobalMethodsPage().selectCountry();
        log.info("Selected Country");

        pageObjectManager.getBrokersPage().enterBrokersVat(FakeDataUtil.getVatNo());
        log.info("Entered Brokers Vat");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Field Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Brokers Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getSuccessAlertText("Broker successfully created.");
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Broker successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
