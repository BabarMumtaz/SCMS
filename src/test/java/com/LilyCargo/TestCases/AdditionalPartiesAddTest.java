package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionalPartiesAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Additional Party",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Additional Party successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.13_AdditionalParties")
    @Story("As a user, I should be able to Add/Create Additional Party successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Additional Parties Relation > Add Additional Party")
    public void VerifyAdditionalPartiesAddTestCase(){

        log = LogManager.getLogger(AdditionalPartiesAddTest.class);
        log.info("Starting Additional Party Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickAdditionalPartiesFRSubMenu();
        log.info("Clicked Additional Party FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Additional Parties", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Additional Party Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Additional Party", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterCompanyName(faker.company().name());
        log.info("Entered Additional Party  Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterContactPerson(faker.company().name());
        log.info("Entered Additional Party Contact Person");

        pageObjectManager.getRelationsAllFieldsTestPage().enterAddress1(faker.address().streetAddress());
        log.info("Entered Address 1");

        pageObjectManager.getRelationsAllFieldsTestPage().enterZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getGlobalMethodsPage().selectCountryName("CHINA");
        log.info("Selected Country");

        pageObjectManager.getRelationsAllFieldsTestPage().enterEmail(faker.internet().emailAddress());
        log.info("Entered Additional Party Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterTelephoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Additional Party Tel Number");

        pageObjectManager.getRelationsAllFieldsTestPage().enterVatNumber(FakeDataUtil.getString());
        log.info("Entered Additional Party Vat No");

        pageObjectManager.getRelationsAllFieldsTestPage().enterEoriNumber(FakeDataUtil.getString());
        log.info("Entered Additional Party Eori No");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Field Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Additional Party Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Additional Party successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}
