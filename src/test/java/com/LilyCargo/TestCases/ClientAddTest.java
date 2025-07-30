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
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to Add/Create Client successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Client")
    public void VerifyClientAddTestCase(){

        log = LogManager.getLogger(ClientAddTest.class);
        log.info("Starting Client Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickClientFRSubMenu();
        log.info("Clicked Client FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getClientPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Client Page Heading: " + pageObjectManager.getClientPage().getPageHeading());

        pageObjectManager.getClientPage().clickAddClientBtn();
        log.info("Clicked Client Add button");

        Assert.assertTrue(pageObjectManager.getClientPage().isAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("Client Add Page Heading: " + pageObjectManager.getClientPage().getAddPageHeading());

        pageObjectManager.getClientPage().enterClientName(faker.company().name());
        log.info("Entered Clients Name");

        pageObjectManager.getClientPage().enterContactPerson(faker.company().name());
        log.info("Entered Contact Person Name");

        pageObjectManager.getClientPage().enterClientAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getClientPage().enterClientEmail1(faker.internet().emailAddress());
        log.info("Entered Clients Email");

        pageObjectManager.getClientPage().enterClientFinancialEmail(faker.internet().emailAddress());
        log.info("Entered Clients Financial Email");

        pageObjectManager.getClientPage().enterClientFiscalMattersEmail(faker.internet().emailAddress());
        log.info("Entered Clients Fiscal Matters Email");

        pageObjectManager.getClientPage().enterClientCeoEmail(faker.internet().emailAddress());
        log.info("Entered Client Ceo Email");

        pageObjectManager.getClientPage().enterClientDutchPhoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Clients Tel Number");

        pageObjectManager.getClientPage().selectRegion();
        log.info("Selected Region");

        pageObjectManager.getClientPage().selectCountry();
        log.info("Selected Country");

        pageObjectManager.getClientPage().enterClientZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getClientPage().enterVat(FakeDataUtil.getVatNo());
        log.info("Entered VAT");

        pageObjectManager.getClientPage().selectLfr();
        log.info("Selected LFR");

        pageObjectManager.getClientPage().clickExtraEmailFieldCross();
        log.info("Click Extra Email Field Cross");

        pageObjectManager.getClientPage().clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        pageObjectManager.getClientPage().clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        pageObjectManager.getClientPage().enterScmEmail(faker.internet().emailAddress());
        log.info("Entered Clients SCM Email");

        pageObjectManager.getClientPage().enterCustomsReleaseEmail(faker.internet().emailAddress());
        log.info("Entered Clients Customs Release Email");

        pageObjectManager.getClientPage().enterBillingEmail(faker.internet().emailAddress());
        log.info("Entered Clients Billing Email");

        pageObjectManager.getClientPage().clickSaveClientBack();
        log.info("Click Save Client Button");

        Assert.assertTrue(pageObjectManager.getClientPage().isClientSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getClientPage().getClientSuccessAlertMessage());

        pageObjectManager.getClientPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
