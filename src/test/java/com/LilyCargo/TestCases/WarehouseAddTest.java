package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WarehouseAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Warehouse",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Warehouse successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to Add/Create Warehouse successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Warehouse")
    public void VerifyWarehouseAddTestCase(){

        log = LogManager.getLogger(WarehouseAddTest.class);
        log.info("Starting Warehouse Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickWarehousesFRSubMenu();
        log.info("Clicked Warehouse FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getWarehousePage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Warehouse Page Heading: " + pageObjectManager.getWarehousePage().getPageHeading());

        pageObjectManager.getWarehousePage().clickAddWarehouseBtn();
        log.info("Clicked Warehouse Add button");

        Assert.assertTrue(pageObjectManager.getWarehousePage().isAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("Warehouse Add Page Heading: " + pageObjectManager.getWarehousePage().getAddPageHeading());

        pageObjectManager.getWarehousePage().enterWarehouseCompany(faker.company().name());
        log.info("Entered Warehouse Company Name");

        pageObjectManager.getWarehousePage().enterContactPerson(faker.company().name());
        log.info("Entered Warehouse Name");

        pageObjectManager.getWarehousePage().enterWarehouseEmail1(faker.internet().emailAddress());
        log.info("Entered Warehouse Email");

        pageObjectManager.getWarehousePage().enterWarehouseAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getWarehousePage().selectCountry();
        log.info("Selected Country");

        pageObjectManager.getWarehousePage().enterWarehouseZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getWarehousePage().enterWarehouseDutchPhoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Warehouse Tel Number");

        pageObjectManager.getWarehousePage().enterWarehouseAgreementNotes(FakeDataUtil.getRemarks());
        log.info("Entered Warehouse Agreement Notes");

        pageObjectManager.getWarehousePage().clickExtraEmailFieldCross();
        log.info("Click Extra Email Field Cross");

        pageObjectManager.getWarehousePage().clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        pageObjectManager.getWarehousePage().clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        pageObjectManager.getWarehousePage().clickSaveWarehouseBack();
        log.info("Click Save Warehouse Button");

        Assert.assertTrue(pageObjectManager.getWarehousePage().isWarehouseSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getWarehousePage().getWarehouseSuccessAlertMessage());

        pageObjectManager.getWarehousePage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
