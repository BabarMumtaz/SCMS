package com.LilyCargo.TestCases;
import com.LilyCargo.Base.TestBeforeAndAfter;
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
    @Epic("EP001")
    @Feature("Feature:002")
    @Story("As a user, I should be able to edit carrier successfully")
    @Step("Hit Site Url > Login with valid credentials > Detail Page of Carrier > Edit carrier")
    public void EditCarrierTest() throws InterruptedException {

        log = LogManager.getLogger(CarrierEditFromDetailViewTest.class);
        log.info("Starting Carrier Edit Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickCarriersFRSubMenu();
        log.info("Clicked Carriers FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getCarriersPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getCarriersPage().getPageHeading());

        pageObjectManager.getCarrierListing().hoverOnCarrier1stRow();
        log.info("Hover over 1st Row");

        pageObjectManager.getCarrierListing().clickOnViewCarrierIcon();
        log.info("Hover over View Icon and click");

        Assert.assertTrue(pageObjectManager.getCarrierListing().isViewPageDisplayed(), "View Page is not Displayed");

        pageObjectManager.getCarrierListing().clickOnEditCarrierIconFromDetail();
        log.info("Clicked on Edit button on view page");

        pageObjectManager.getCarriersPage().enterCarrierEmail2(faker.internet().emailAddress());
        log.info("Entered Carrier's Email 2");

        pageObjectManager.getCarriersPage().enterDutchPhoneNumber2(); // New method for Dutch phone number
        log.info("Entered Carrier's Tel 2 Number");

        pageObjectManager.getCarriersPage().enterAddress2(faker.address().streetAddress());
        log.info("Entered Address 2");

        pageObjectManager.getCarriersPage().clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross icon");

        pageObjectManager.getCarriersPage().clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        pageObjectManager.getCarriersPage().clickSaveCarrierBack();
        log.info("Click Save Carrier Button");

        pageObjectManager.getCarriersPage().clickOnAlertPopupDP();
        log.info("Clicked Cross icon of Alert");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}