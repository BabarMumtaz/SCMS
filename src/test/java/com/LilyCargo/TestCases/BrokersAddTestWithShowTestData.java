package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class BrokersAddTestWithShowTestData extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Brokers",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Broker successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.07.02_Brokers")
    @Story("As a user, I should be able to Add/Create Broker successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Brokers Relation > Add Broker")
    public void VerifyBrokersAddTestWithShowTestData(){

        log = LogManager.getLogger(BrokersAddTestWithShowTestData.class);
        log.info("Starting Brokers Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickBrokersFRSubMenu();
        log.info("Clicked Brokers FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Brokers", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Brokers Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Broker", "Add Page heading does not match expected value.");

        // ---- Collect all fake data in one place ----
        Map<String, String> brokerData = new LinkedHashMap<>();

        brokerData.put("Company Name", faker.company().name());
        brokerData.put("Contact Person", faker.company().name());
        brokerData.put("Telephone Number", FakeDataUtil.getDutchPhoneNumber());
        brokerData.put("Email", faker.internet().emailAddress());
        brokerData.put("Address", faker.address().streetAddress());
        brokerData.put("Zip City", faker.address().zipCode());
        brokerData.put("Country", "CHINA");
        brokerData.put("VAT Number", FakeDataUtil.getVatNo());

        // ---- Enter values into fields ----
        pageObjectManager.getRelationsAllFieldsTestPage().enterName(brokerData.get("Company Name"));
        pageObjectManager.getRelationsAllFieldsTestPage().enterContactPerson(brokerData.get("Contact Person"));
        pageObjectManager.getRelationsAllFieldsTestPage().enterTelephoneNumber(brokerData.get("Telephone Number"));
        pageObjectManager.getRelationsAllFieldsTestPage().enterEmail(brokerData.get("Email"));
        pageObjectManager.getRelationsAllFieldsTestPage().enterAddress1(brokerData.get("Address"));
        pageObjectManager.getRelationsAllFieldsTestPage().enterZipCity(brokerData.get("Zip City"));
        pageObjectManager.getGlobalMethodsPage().selectCountryName(brokerData.get("Country"));
        pageObjectManager.getRelationsAllFieldsTestPage().enterVatNumber(brokerData.get("VAT Number"));

        // ---- Log all values in one go ----
        log.info("===== Broker Test Data Entered =====");
        brokerData.forEach((field, value) -> log.info("{}: {}", field, value));
        log.info("===================================");

        // ---- Attach test data into Allure ----
        StringBuilder allureData = new StringBuilder();
        brokerData.forEach((field, value) -> allureData.append(field).append(": ").append(value).append("\n"));

        Allure.addAttachment("Broker Test Data", "text/plain",
                allureData.toString(), StandardCharsets.UTF_8.name());

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Field Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Brokers Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Broker successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");
    }
}