package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Client",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Client successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.02_Client")
    @Story("As a user, I should be able to Add/Create Client successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Client")
    public void VerifyClientAddTestCase(){

        log = LogManager.getLogger(ClientAddTest.class);
        log.info("Starting Client Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickClientFRSubMenu();
        log.info("Clicked Client FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Clients", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Client Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Client", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterName(faker.name().name());
        log.info("Entered Clients Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterContactPerson(faker.name().name());
        log.info("Entered Contact Person Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getRelationsAllFieldsTestPage().enterEmail(faker.internet().emailAddress());
        log.info("Entered Clients Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterFinanceEmail(faker.internet().emailAddress());
        log.info("Entered Clients Financial Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterFiscalMattersEmail(faker.internet().emailAddress());
        log.info("Entered Clients Fiscal Matters Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterCeoEmail(faker.internet().emailAddress());
        log.info("Entered Client Ceo Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterTelephoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Clients Tel Number");

        pageObjectManager.getGlobalMethodsPage().selectRegion("eu");
        log.info("Selected Region");

        pageObjectManager.getGlobalMethodsPage().selectCountryName("CHINA");
        log.info("Selected Country");

        pageObjectManager.getRelationsAllFieldsTestPage().enterZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getRelationsAllFieldsTestPage().enterVatNumber(FakeDataUtil.getString());
        log.info("Entered VAT");

        pageObjectManager.getGlobalMethodsPage().selectLfr("NL LMLOG Fiscal");
        log.info("Selected LFR");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Fields Cross");

        pageObjectManager.getRelationsAllFieldsTestPage().enterScmEmails(FakeDataUtil.getFakeEmails(3).split(";"));
        log.info("Entered Clients SCM Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterCustomsReleaseEmails(FakeDataUtil.getFakeEmails(3).split(";"));
        log.info("Entered Clients Customs Release Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterBillingEmails(FakeDataUtil.getFakeEmails(3).split(";"));
        log.info("Entered Clients Billing Email");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Client successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
