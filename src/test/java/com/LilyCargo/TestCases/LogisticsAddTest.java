package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogisticsAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Logistic",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Logistic successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.10_Logistics")
    @Story("As a user, I should be able to Add/Create Logistic successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Logistic Relation > Add Logistic")
    public void VerifyLogisticsAddTestCase(){

        log = LogManager.getLogger(LogisticsAddTest.class);
        log.info("Starting Logistic Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickLogisticsFRSubMenu();
        log.info("Clicked Logistic FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Logistics", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Logistic Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Logistic", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterShortName(faker.name().name());
        log.info("Entered Logistic  Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterCompanyName(faker.company().name());
        log.info("Entered Logistic Company Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterContactPerson(faker.name().name());
        log.info("Entered Logistic Contact Person");

        pageObjectManager.getRelationsAllFieldsTestPage().enterAddress1(faker.address().streetAddress());
        log.info("Entered Address 1");

        pageObjectManager.getRelationsAllFieldsTestPage().enterZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getGlobalMethodsPage().selectCountryName("CHINA");
        log.info("Selected Country");

        pageObjectManager.getRelationsAllFieldsTestPage().enterVatNumber(FakeDataUtil.getString());
        log.info("Entered Logistic Vat");

        pageObjectManager.getRelationsAllFieldsTestPage().enterEmail(faker.internet().emailAddress());
        log.info("Entered Logistic Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterTelephoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Logistic Tel Number");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Field Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Logistic Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Logistic successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
