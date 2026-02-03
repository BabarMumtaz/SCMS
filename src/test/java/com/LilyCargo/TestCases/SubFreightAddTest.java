package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import com.LilyCargo.Util.FileUtil;
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
    @Epic("Booked Freight 03")
    @Feature("Feature:03.03_Create Sub Freight")
    @Story("As a user, I should be able to Create SubFreight successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Open Freight Detail > Create SubFreight")
    public void VerifySubFreightCreation() throws InterruptedException {

        log = LogManager.getLogger(SubFreightAddTest.class);
        log.info("Starting SubFreight Add Test from Detail Page.");

        pageObjectManager.getMenuBar().clickBookedFreightMenu();
        log.info("Clicked Booked Freight Button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Booked Freights", "Page heading does not match expected value.");

/*
        String fidToSearch = FileUtil.getData("FreightID");
        pageObjectManager.getFreightListing().searchFid(fidToSearch);
        String searchedFid = pageObjectManager.getFreightListing().getSearchResultFid();
        Assert.assertEquals(searchedFid, fidToSearch, "Searched FId does not match expected value.");
*/

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");
        log.info("Edit wrapper is displayed.");
        
        pageObjectManager.getFreightDetail().clickSubFidAddIcon();
        log.info("Clicked SubFid Add Icon");

        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: {}", popupHeading);
        Assert.assertEquals(popupHeading, "Create Sub Freight", "Popup heading does not match expected value.");

        pageObjectManager.getBookedFreights().selectExportCompany("BEIJING CENTURY");
        log.info("Selected SubFid Export Company");

        pageObjectManager.getBookedFreights().selectShipper("Shenzhen Jingsen Jiaju Keji");
        log.info("Selected SubFid Shipper");

        pageObjectManager.getBookedFreights().selectSubFidNoTc("TC1");
        log.info("Selected SubFid NoTC");

        Thread.sleep(500);

        pageObjectManager.getBookedFreights().enterHouseBLNO(FakeDataUtil.getString());
        log.info("Entered SubFid House BL No");

        pageObjectManager.getBookedFreights().enterClientReference(FakeDataUtil.getString());
        log.info("Entered SubFid Client Ref");

        pageObjectManager.getFreightDetail().clickYesButton();
        log.info("Clicked Submit Button");

        String subFidSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", subFidSuccessAlert);

        Assert.assertTrue(
                subFidSuccessAlert.startsWith("SUBFID created "),
                "Warning Alert does not contain 'SUBFID created... Check warning for details!' -> " + subFidSuccessAlert);

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

    }
}