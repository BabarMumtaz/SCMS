package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
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
    @Epic("Freight Relations 04")
    @Feature("Feature:04.04_Shippers")
    @Story("As a user, I should be able to add SHIPPER successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add SHIPPER")
    public void VerifyShipperAddTestCase() throws InterruptedException {

        log = LogManager.getLogger(ShipperAddTest.class);
        log.info("Starting Shipper Add Test from Freight Relations Tab.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickShippersFRSubMenu();
        log.info("Clicked Shipper FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Shippers", "Page heading does not match expected value.");

        pageObjectManager.getShippersPage().clickAddShipperBtn();
        log.info("Clicked Shipper Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Shipper", "Add Page heading does not match expected value.");

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

        pageObjectManager.getShippersPage().enterShipperDutchPhoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Shipper's Tel Number");

/*        pageObjectManager.getShippersPage().enterExtraEmailLabel("Extra Email");
        log.info("Entered Extra Email");

        pageObjectManager.getShippersPage().enterExtraEmailValue(faker.internet().emailAddress());
        log.info("Entered Extra Email Value");*/

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Field Cross");

        pageObjectManager.getShippersPage().enterShipperSCMEmail(faker.internet().emailAddress());
        log.info("Entered Shipper's SCM Email");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Shipper Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Shipper successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
