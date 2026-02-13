package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCargoDataAndRemoveSubFidTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can Delete Cargo Data And Remove SubFid Test after Creating SubFreight successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Delete Cargo Data And Remove SubFid Test successfully")
    @Epic("Booked Freight 03")
    @Feature("Feature:03.11.03_CargoData_Delete Cargo Data And Remove SubFid Test")
    @Story("As a user, I should be able to Delete Cargo Data And Remove SubFid Test successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Open Freight Detail > Create SubFreight > Cargo Data Tab > Delete Cargo Data And Remove SubFid Test")
    public void VerifyDeleteCargoDataAndRemoveSubFidTest() throws InterruptedException {

        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\TC9 Upload Data - 38 Records.xlsx";

        log = LogManager.getLogger(DeleteCargoDataAndRemoveSubFidTest.class);
        log.info("Starting SubFreight Add Test from Detail Page.");

        pageObjectManager.getMenuBar().clickBookedFreightMenu();
        log.info("Clicked Booked Freight Button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Booked Freights", "Page heading does not match expected value.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");
        log.info("Edit wrapper is displayed.");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Fid Number is: {}", fidNumber);

        pageObjectManager.getFreightDetail().clickSubFidAddIcon();
        log.info("Clicked SubFid Add Icon");

        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: {}", popupHeading);
        Assert.assertEquals(popupHeading, "Create Sub Freight", "Popup heading does not match expected value.");

        pageObjectManager.getBookedFreights().selectExportCompany("BEIJING CENTURY");
        log.info("Selected SubFid Export Company");

        pageObjectManager.getBookedFreights().selectShipper("Shenzhen Jingsen Jiaju Keji");
        log.info("Selected SubFid Shipper");

        pageObjectManager.getBookedFreights().selectSubFidNoTc("TC9");
        log.info("Selected SubFid NoTC");

        pageObjectManager.getBookedFreights().enterHouseBLNO(FakeDataUtil.getString());
        log.info("Entered SubFid House BL No");

        pageObjectManager.getBookedFreights().enterClientReference(FakeDataUtil.getString());
        log.info("Entered SubFid Client Ref");

        pageObjectManager.getFreightDetail().clickYesButton();
        log.info("Clicked Submit Button");

        String subFidSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", subFidSuccessAlert);
        Assert.assertEquals(subFidSuccessAlert, "SUBFID created successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        Thread.sleep(1000);

        pageObjectManager.getFreightDetail().selectLastSubFID();

        //pageObjectManager.getFreightDetail().scrollToRight();

        pageObjectManager.getFreightDetail().scrollToTab("API Docs");
        log.info("Scroll to Right Towards Cargo Data Tab");

        Thread.sleep(1000);

        pageObjectManager.getFreightDetail().clickTab("Cargo Data");

        String tabHeading = pageObjectManager.getFreightDetail().getCargoDataTabText();
        log.info("Tab Heading is: {}", tabHeading);
        Assert.assertEquals(tabHeading, "Cargo Data", "Page heading does not match expected value.");

        pageObjectManager.getCargoDataPage().uploadAndSubmitCargoDataTc9(filePath, log);
        pageObjectManager.getCargoDataPage().exportCargoData();

        pageObjectManager.getCargoDataPage().clickDeleteCargoDataButton();
        log.info("Clicked Delete Cargo Data Button");

        String deletePopupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Delete Popup Heading is: {}", deletePopupHeading);
        Assert.assertEquals(deletePopupHeading, "Delete Cargo Data", "Popup heading does not match expected value.");

        pageObjectManager.getFreightDetail().clickYesButton();
        log.info("Clicked Submit 'Yes' Button");

        String deleteSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", deleteSuccessAlert);
        Assert.assertEquals(deleteSuccessAlert, "Cargo Data deleted successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        pageObjectManager.getCargoDataPage().clickRemoveSubFidButton();
        log.info("Clicked Remove SUBFID Button");

        String removePopupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Delete Popup Heading is: {}", removePopupHeading);
        Assert.assertEquals(removePopupHeading, "Delete Sub Freight", "Popup heading does not match expected value.");

        pageObjectManager.getFreightDetail().clickYesButton();
        log.info("Clicked Submit 'Yes' Button");

        String removeSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", removeSuccessAlert);
        Assert.assertTrue(
                removeSuccessAlert.startsWith("Sub FID "),
                "Warning Alert does not contain 'Sub FID No.. Check warning for details!' -> " + removeSuccessAlert
        );

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

    }
}