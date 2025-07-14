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

public class CarrierAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add carrier successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add carrier successfully")
    @Epic("EP001")
    @Feature("Feature:003")
    @Story("As a user, I should be able to add carrier successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add carrier")
    public void VerifyCarrierAddTestCase() throws InterruptedException {

        log = LogManager.getLogger(CarrierAddTest.class);
        log.info("Starting Carrier Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickCarriersFRSubMenu();
        log.info("Clicked Carriers FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getCarriersPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Page Heading: " + pageObjectManager.getCarriersPage().getPageHeading());

        pageObjectManager.getCarriersPage().clickAddCarrierBtn();
        log.info("Clicked Carriers Add button");

        pageObjectManager.getCarriersPage().enterTicker(faker.company().name());
        log.info("Entered Ticker Name");

        pageObjectManager.getCarriersPage().enterCarrierName(faker.company().name());
        log.info("Entered Carrier's Name");

        pageObjectManager.getCarriersPage().enterCarrierEmail(faker.internet().emailAddress());
        log.info("Entered Carrier's Email");

        pageObjectManager.getCarriersPage().enterCarrierDutchPhoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Carrier's Tel Number");

        pageObjectManager.getCarriersPage().enterAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getCarriersPage().enterZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getCarriersPage().selectCountry();
        log.info("Selected Country");

        pageObjectManager.getCarriersPage().enterExtraEmailLabel("Extra Email");
        log.info("Entered Extra Email");

        pageObjectManager.getCarriersPage().enterExtraEmailValue(faker.internet().emailAddress());
        log.info("Entered Extra Email Value");

        pageObjectManager.getCarriersPage().clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        pageObjectManager.getCarriersPage().clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        pageObjectManager.getCarriersPage().clickSaveCarrierBack();
        log.info("Click Save Carrier Button");

        Assert.assertTrue(pageObjectManager.getCarrierListing().isCarrierSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getCarrierListing().getCarrierSuccessAlertMessage());

        pageObjectManager.getCarrierListing().clickOnAlertPopupDP();
        log.info("Clicked Cross icon of Alert");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}