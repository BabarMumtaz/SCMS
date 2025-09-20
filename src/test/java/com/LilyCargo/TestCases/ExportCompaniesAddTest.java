package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExportCompaniesAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Export Company",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Export Company successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.03_Shippers")
    @Story("As a user, I should be able to Add/Create Export Company successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Export Company")
    public void VerifyExportCompaniesAddTestCase(){

        log = LogManager.getLogger(ExportCompaniesAddTest.class);
        log.info("Starting Export Company Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickExportCompaniesFRSubMenu();
        log.info("Clicked Export Company FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Export Companies", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Export Company Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Export Company", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterName(faker.name().name());
        log.info("Entered Export Company Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterContactPerson(faker.name().name());
        log.info("Entered Export Company Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterEmail(faker.internet().emailAddress());
        log.info("Entered Export Company Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getGlobalMethodsPage().selectCountryName("CHINA");
        log.info("Selected Country");

        pageObjectManager.getRelationsAllFieldsTestPage().enterZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getRelationsAllFieldsTestPage().enterTelephoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Export Company Tel Number");

        pageObjectManager.getRelationsAllFieldsTestPage().enterAgreementNotes(FakeDataUtil.getRemarks());
        log.info("Entered Export Company Agreement Notes");

        pageObjectManager.getRelationsAllFieldsTestPage().enterExtraEmailLabel("Extra Email");
        log.info("Entered Extra Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterExtraEmailValue(faker.internet().emailAddress());
        log.info("Entered Extra Email Value");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Clicked ALl Extra Fields Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Export Company Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Export Company successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}

