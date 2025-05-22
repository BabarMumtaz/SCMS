package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShipperAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add SHIPPER successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add SHIPPER successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add SHIPPER successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add SHIPPER")
    public void VerifyShipperAddTestCase() throws InterruptedException {

        log = LogManager.getLogger(ShipperAddTest.class);
        log.info("Starting Shipper Add Test from Freight Relations Tab.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickShippersFRSubMenu();
        log.info("Clicked Shipper FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getShippersPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getShippersPage().getPageHeading());

        pageObjectManager.getShippersPage().clickAddShipperBtn();
        log.info("Clicked Shipper Add button");

        Assert.assertTrue(pageObjectManager.getShippersPage().isAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getShippersPage().getAddPageHeading());

        pageObjectManager.getShippersPage().enterShipperStore(faker.company().name());
        log.info("Entered Shipper Store Name");

        pageObjectManager.getShippersPage().selectExportCompany();
        log.info("Selected Export Company");

        pageObjectManager.getShippersPage().enterShipperName(faker.company().name());
        log.info("Entered Shippers Name");

        pageObjectManager.getShippersPage().enterShipperAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getShippersPage().enterShipperZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getShippersPage().selectCountry();
        log.info("Selected Country");

        pageObjectManager.getShippersPage().enterShipperEmail1(faker.internet().emailAddress());
        log.info("Entered Shipper's Email");

        pageObjectManager.getShippersPage().enterShipperDutchPhoneNumber(); // New method for Dutch phone number
        log.info("Entered Shipper's Tel Number");

        pageObjectManager.getShippersPage().enterExtraEmailLabel("Extra Email");
        log.info("Entered Extra Email");

        pageObjectManager.getShippersPage().enterExtraEmailValue(faker.internet().emailAddress());
        log.info("Entered Extra Email Value");

        pageObjectManager.getShippersPage().clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        pageObjectManager.getShippersPage().clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        pageObjectManager.getShippersPage().enterShipperSCMEmail(faker.internet().emailAddress());
        log.info("Entered Shipper's SCM Email");

        pageObjectManager.getShippersPage().clickSaveShipperBack();
        log.info("Click Save Shipper Button");

        pageObjectManager.getShippersPage().clickOnAlertPopupDP();
        log.info("Clicked Cross icon of Alert");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}
