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
    @Epic("Freight Relations 04")
    @Feature("Feature:04.02.03_Client")
    @Story("As a user, I should be able to Duplicate Client successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Client Listing > Edit Client > Duplicate Client")
    public void VerifyClientDuplicateTestCase(){

        log = LogManager.getLogger(ClientDuplicateTest.class);
        log.info("Starting Client Edit Test from Listing Page.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickClientFRSubMenu();
        log.info("Clicked Client FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Clients", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().hoverAndClickIconOnRow(0, "Edit");
        log.info("Hover over on A row and click Edit Icon");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", addPageHeading);
        Assert.assertEquals(addPageHeading, "Update Client", "Edit Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().clickDuplicateBtn();
        log.info("Click Duplicate Client Button");

        pageObjectManager.getRelationsAllFieldsTestPage().updateName(faker.name().name());
        log.info("Update Clients Name");

        pageObjectManager.getRelationsAllFieldsTestPage().updateVatNumber(FakeDataUtil.getString());
        log.info("Update VAT");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Fields Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Client successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}
