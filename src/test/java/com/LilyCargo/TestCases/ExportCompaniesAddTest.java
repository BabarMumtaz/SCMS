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
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to Add/Create Export Company successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Export Company")
    public void VerifyExportCompaniesAddTestCase(){

        log = LogManager.getLogger(ExportCompaniesAddTest.class);
        log.info("Starting Export Company Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickExportCompaniesFRSubMenu();
        log.info("Clicked Export Company FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getExportCompanyPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Export Company Page Heading: " + pageObjectManager.getExportCompanyPage().getPageHeading());

        pageObjectManager.getExportCompanyPage().clickAddExportCompanyBtn();
        log.info("Clicked Export Company Add button");

        Assert.assertTrue(pageObjectManager.getExportCompanyPage().isAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("Export Company Add Page Heading: " + pageObjectManager.getExportCompanyPage().getAddPageHeading());

        pageObjectManager.getExportCompanyPage().enterExportCompanyName(faker.company().name());
        log.info("Entered Export Company Name");

        pageObjectManager.getExportCompanyPage().enterContactPerson(faker.company().name());
        log.info("Entered Export Company Name");

        pageObjectManager.getExportCompanyPage().enterExportCompanyEmail1(faker.internet().emailAddress());
        log.info("Entered Export Company Email");

        pageObjectManager.getExportCompanyPage().enterExportCompanyAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getExportCompanyPage().selectCountry();
        log.info("Selected Country");

        pageObjectManager.getExportCompanyPage().enterExportCompanyZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getExportCompanyPage().enterExportCompanyDutchPhoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Export Company Tel Number");

        pageObjectManager.getExportCompanyPage().enterExportCompanyAgreementNotes(FakeDataUtil.getRemarks());
        log.info("Entered Export Company Agreement Notes");

        pageObjectManager.getExportCompanyPage().clickExtraEmailFieldCross();
        log.info("Click Extra Email Field Cross");

        pageObjectManager.getExportCompanyPage().clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        pageObjectManager.getExportCompanyPage().clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        pageObjectManager.getExportCompanyPage().clickSaveExportCompanyBack();
        log.info("Click Save Export Company Button");

        Assert.assertTrue(pageObjectManager.getExportCompanyPage().isExportCompanySuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getExportCompanyPage().getExportCompanySuccessAlertMessage());

        pageObjectManager.getExportCompanyPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}

