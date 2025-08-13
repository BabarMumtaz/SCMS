package com.LilyCargo.TestCases;
import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CarrierEditFromDetailViewTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can edit carrier successfully", groups = {"regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can edit Carrier successfully from the Carrier view page")
    @Epic("Freight Relations")
    @Feature("Feature:01.1")
    @Story("As a user, I should be able to edit carrier successfully")
    @Step("Hit Site Url > Login with valid credentials > Freight Relations > Carriers Relation > Detail Page of Carrier > Edit carrier")
    public void VerifyCarrierEditTestCase() throws InterruptedException {

        log = LogManager.getLogger(CarrierEditFromDetailViewTest.class);
        log.info("Starting Carrier Edit Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickCarriersFRSubMenu();
        log.info("Clicked Carriers FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Carriers");
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Carriers", "Page heading does not match expected value.");

        pageObjectManager.getCarrierListing().hoverOnCarrier1stRow();
        log.info("Hover over 1st Row");

        pageObjectManager.getCarrierListing().clickOnViewCarrierIcon();
        log.info("Hover over View Icon and click");

        Assert.assertTrue(pageObjectManager.getCarrierListing().isViewPageDisplayed(), "View Page is not Displayed");

        pageObjectManager.getCarrierListing().clickOnEditCarrierIconFromDetail();
        log.info("Clicked on Edit button on view page");

        pageObjectManager.getCarriersPage().enterCarrierEmail2(faker.internet().emailAddress());
        log.info("Entered Carrier's Email 2");

        pageObjectManager.getCarriersPage().enterCarrierDutchPhoneNumber2(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Carrier's Tel 2 Number");

        pageObjectManager.getCarriersPage().enterAddress2(faker.address().streetAddress());
        log.info("Entered Address 2");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Field Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getSuccessAlertText("Carrier successfully updated.");
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Carrier successfully updated.", "Success Alert does not match expected value.");

        pageObjectManager.getCarrierListing().clickOnAlertPopupDP();
        log.info("Clicked Cross icon of Alert");

    }
}