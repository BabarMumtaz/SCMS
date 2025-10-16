package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FulfillmentAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can Add Fulfillment successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Add Fulfillment successfully")
    @Epic("Booked Freight 03")
    @Feature("Feature:03.12_Fulfillment")
    @Story("As a user, I should be able to Add Fulfillment successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Open Freight Detail > Fulfillment > Add Delivery")
    public void VerifyFulfillmentAddTest() throws InterruptedException {

        log = LogManager.getLogger(FulfillmentAddTest.class);
        log.info("Test setup completed.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Fid Number is: {}", fidNumber);

        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");
        log.info("Edit wrapper is displayed.");

        pageObjectManager.getFreightDetail().scrollToRight();
        log.info("Scroll to Right Towards Cargo Data Tab");

        Thread.sleep(500);

        pageObjectManager.getFreightDetail().clickFulfillmentTab();
        log.info("Clicked Fulfillment Tab");

        String tabHeading = pageObjectManager.getFreightDetail().getFulfillmentTabText();
        log.info("Tab Heading is: {}", tabHeading);
        Assert.assertEquals(tabHeading, "Fulfillment", "Page heading does not match expected value.");

        pageObjectManager.getFulfillmentPage().clickManageStorageLocationBtn();
        log.info("Clicked Manage Storage Location Btn");

        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: {}", popupHeading);
        Assert.assertEquals(popupHeading, "Manage Storage Location", "Popup heading does not match expected value.");

        pageObjectManager.getFulfillmentPage().enterStorageLocationField("A2");
        log.info("Entered Storage Location");

        pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
        log.info("Clicked Submit Button");

        String storageSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Storage Success Alert is: {}", storageSuccessAlert);
        Assert.assertEquals(storageSuccessAlert, "Storage Location Updated", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked NoTC Alert Popup Cross Icon");

        pageObjectManager.getFulfillmentPage().clickAddNewDeliveryBtn();
        log.info("Clicked Add New Delivery Btn");

        pageObjectManager.getFulfillmentPage().selectLogisticsOperator("CHATEL NORD");
        log.info("Selected Logistics Operator");

        pageObjectManager.getFulfillmentPage().enterCtns("200");
        log.info("Entered Ctns");

        pageObjectManager.getFulfillmentPage().clickDeliverAllBtn();
        log.info("Clicked Delivery All Btn");

        pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
        log.info("Clicked Submit Button");

        String deliverySuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Delivery Success Alert is: {}", deliverySuccessAlert);
        Assert.assertEquals(deliverySuccessAlert, "Delivery has been added", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked NoTC Alert Popup Cross Icon");

    }
}