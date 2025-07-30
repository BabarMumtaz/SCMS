package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientDuplicateTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can Duplicate Client successfully", groups = {"regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Duplicate Client successfully from the listing 1st page")
    @Epic("EP001")
    @Feature("Feature:002")
    @Story("As a user, I should be able to Duplicate Client successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Client Listing > Edit Client > Duplicate Client")
    public void VerifyClientDuplicateTestCase() throws InterruptedException {

        log = LogManager.getLogger(ClientDuplicateTest.class);
        log.info("Starting Client Edit Test from Listing Page.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickClientFRSubMenu();
        log.info("Clicked Client FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getClientPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Client Page Heading: " + pageObjectManager.getClientPage().getPageHeading());

        pageObjectManager.getAdminOverviewTestPage().hoverAndClickIconOnRow(0, "Edit");
        log.info("Hover over on A row and click Edit Icon");

        Assert.assertTrue(pageObjectManager.getClientPage().isAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("Client Edit Page Heading: " + pageObjectManager.getClientPage().getAddPageHeading());

        pageObjectManager.getClientPage().clickDuplicateBtn();
        log.info("Click Duplicate Client Button");

        pageObjectManager.getClientPage().updatedClientName(faker.company().name());
        log.info("Update Clients Name");

        pageObjectManager.getClientPage().enterVat(FakeDataUtil.getVatNo());
        log.info("Update VAT");

        pageObjectManager.getClientPage().clickExtraEmailFieldCross();
        log.info("Click Extra Email Field Cross");

        pageObjectManager.getClientPage().clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        pageObjectManager.getClientPage().clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        pageObjectManager.getClientPage().clickSaveClientBack();
        log.info("Click Save Client Button");

        Assert.assertTrue(pageObjectManager.getClientPage().isClientSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getClientPage().getClientSuccessAlertMessage());

        pageObjectManager.getClientPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
