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
    @Description("Verify that a user can add Brokers successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to Add/Create Brokers successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Brokers")
    public void VerifyBrokersAddTestCase(){

        log = LogManager.getLogger(BrokersAddTest.class);
        log.info("Starting Brokers Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickBrokersFRSubMenu();
        log.info("Clicked Brokers FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getBrokersPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Brokers Page Heading: " + pageObjectManager.getBrokersPage().getPageHeading());

        pageObjectManager.getBrokersPage().clickAddBrokersBtn();
        log.info("Clicked Brokers Add button");

        Assert.assertTrue(pageObjectManager.getBrokersPage().isAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("Brokers Add Page Heading: " + pageObjectManager.getBrokersPage().getAddPageHeading());

        pageObjectManager.getBrokersPage().enterBrokersName(faker.company().name());
        log.info("Entered Brokers Company Name");

        pageObjectManager.getBrokersPage().enterContactPerson(faker.company().name());
        log.info("Entered Brokers Contact Person");

        pageObjectManager.getBrokersPage().enterBrokersAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getBrokersPage().enterBrokersZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getBrokersPage().selectCountry();
        log.info("Selected Country");

        pageObjectManager.getBrokersPage().enterBrokersDutchPhoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Brokers Tel Number");

        pageObjectManager.getBrokersPage().enterBrokersEmail(faker.internet().emailAddress());
        log.info("Entered Brokers Email");

        pageObjectManager.getBrokersPage().enterBrokersVat(FakeDataUtil.getRemarks());
        log.info("Entered Brokers Vat");

        pageObjectManager.getBrokersPage().clickExtraEmailFieldCross();
        log.info("Click Extra Email Field Cross");

        pageObjectManager.getBrokersPage().clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        pageObjectManager.getBrokersPage().clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        pageObjectManager.getBrokersPage().clickSaveBrokersBack();
        log.info("Click Save Brokers Button");

        Assert.assertTrue(pageObjectManager.getBrokersPage().isBrokersSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getBrokersPage().getBrokersSuccessAlertMessage());

        pageObjectManager.getBrokersPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
