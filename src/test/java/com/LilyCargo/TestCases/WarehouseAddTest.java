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

        // Works for ANY page heading
        String pageHeading = pageObjectManager.getGlobalMethodsPage().getPageHeadingText("Warehouses");
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Warehouses", "Page heading does not match expected value.");

        pageObjectManager.getWarehousePage().clickAddWarehouseBtn();
        log.info("Clicked Warehouse Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Warehouse", "Add Page heading does not match expected value.");

        pageObjectManager.getWarehousePage().enterWarehouseCompany(faker.company().name());
        log.info("Entered Warehouse Company Name");

        pageObjectManager.getWarehousePage().enterContactPerson(faker.company().name());
        log.info("Entered Warehouse Contact Person");

        pageObjectManager.getWarehousePage().enterWarehouseAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getWarehousePage().enterWarehouseZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getGlobalMethodsPage().selectCountry();
        log.info("Selected Country");

        pageObjectManager.getWarehousePage().enterWarehouseDutchPhoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Warehouse Tel Number");

        pageObjectManager.getWarehousePage().enterWarehouseEmail(faker.internet().emailAddress());
        log.info("Entered Warehouse Email");

        pageObjectManager.getWarehousePage().enterWarehouseAgreementNotes(FakeDataUtil.getRemarks());
        log.info("Entered Warehouse Agreement Notes");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Field Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Warehouse Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getSuccessAlertText("Warehouse successfully created.");
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Warehouse successfully created.", "Success Alert does not match expected value.");

        //Assert.assertTrue(pageObjectManager.getGlobalMethodsPage().isSuccessAlertDisplayed("Warehouse successfully created."));

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
