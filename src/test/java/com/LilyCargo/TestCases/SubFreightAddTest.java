package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubFreightAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can Create SubFreight successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Create SubFreight successfully")
    @Epic("EP001")
    @Feature("Feature:003")
    @Story("As a user, I should be able to Create SubFreight successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Open Freight Detail > Create SubFreight")
    public void VerifySubFreightCreation() throws InterruptedException {

        log = LogManager.getLogger(SubFreightAddTest.class);
        log.info("Starting SubFreight Add Test from Detail Page.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");
        log.info("Edit wrapper is displayed.");

        //----------------------------------SubFId----------------------------------

        pageObjectManager.getFreightDetail().clickSubFidAddIcon();
        log.info("Clicked SubFid Add Icon");

/*
        Assert.assertTrue(pageObjectManager.getFreightDetail().isCreateSubFidPopupHeadingDisplayed(), "SubFid popup Not Displayed");
        log.info("Popup Heading: " + pageObjectManager.getFreightDetail().getCreateSubFidPopupHeading());
*/
        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: " + popupHeading);
        Assert.assertEquals(popupHeading, "Create Sub Freight", "Popup heading does not match expected value.");

        pageObjectManager.getBookedFreights().selectExportCompany("BEIJING CENTURY");
        log.info("Selected SubFid Export Company");

        pageObjectManager.getBookedFreights().selectShipper("ShenZhen JingSen");
        log.info("Selected SubFid Shipper");

        pageObjectManager.getFreightDetail().selectSubFidNoTc();
        log.info("Selected SubFid NoTC");

        pageObjectManager.getFreightDetail().enterSubFidHblNo(FakeDataUtil.getHouseBLNo());
        log.info("Entered SubFid House BL No");

        pageObjectManager.getFreightDetail().enterSubFidClientRef(FakeDataUtil.getHouseBLNo());
        log.info("Entered SubFid Client Ref");

        pageObjectManager.getFreightDetail().clickSubmitSubFidButton();
        log.info("Clicked Submit Button");

/*
        Assert.assertTrue(pageObjectManager.getFreightDetail().isSubFidAddSuccessAlertMessageDisplayed(), "Sub FID Creation Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getFreightDetail().getSubFidAddSuccessAlertMessage());
*/

        String pushInvoiceSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + pushInvoiceSuccessAlert);
        Assert.assertEquals(pushInvoiceSuccessAlert, "Subfreight created successfully", "Success Alert does not match expected value.");

        pageObjectManager.getFreightDetail().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

    }
}