package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import com.LilyCargo.Util.FileUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UploadTC1CargoDataTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can Upload TC1 Cargo Data successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Upload TC1 Cargo Data successfully")
    @Epic("Booked Freight 03")
    @Feature("Feature:03.11.02_Cargo Data_UploadTC1CargoDataTest")
    @Story("As a user, I should be able to Upload TC1 Cargo Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Open Freight Detail > Upload TC1 Cargo Data")
    public void VerifyCargoDataTc1UploadTest() throws InterruptedException {

        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\TC1 Upload Data-20 Records (-1 Issue HS).xlsx";

        log = LogManager.getLogger(UploadCargoDataTest.class);
        log.info("Test setup completed.");

        pageObjectManager.getMenuBar().clickBookedFreightMenu();
        log.info("Clicked Booked Freight Button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Booked Freights", "Page heading does not match expected value.");

        String fidToSearch = FileUtil.getData("FreightID");
        pageObjectManager.getFreightListing().globalSearch(fidToSearch);
        String searchedFid = pageObjectManager.getFreightListing().getSearchResultFid();
        Assert.assertEquals(searchedFid, fidToSearch, "Searched FId does not match expected value.");

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

        Thread.sleep(1000);

        pageObjectManager.getFreightDetail().clickCargoDataTab();
        log.info("Clicked Cargo Data Tab");

        String tabHeading = pageObjectManager.getFreightDetail().getCargoDataTabText();
        log.info("Tab Heading is: {}", tabHeading);
        Assert.assertEquals(tabHeading, "Cargo Data", "Page heading does not match expected value.");

        /** ---------- Cargo Data Tab ---------- */

        List<WebElement> noDataElements = pageObjectManager.getCargoDataPage().getNoDataFoundElements(); // This should return List<WebElement>

        if (!noDataElements.isEmpty() && noDataElements.getFirst().isDisplayed()) {
            log.info("No data found' is displayed. Proceeding to upload.");

            pageObjectManager.getCargoDataPage().selectNoTc("TC1");
            log.info("Selected NoTC TC1");

            String noTcSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
            log.info("NoTC Success Alert is: {}", noTcSuccessAlert);
            Assert.assertEquals(noTcSuccessAlert, "NoTC updated", "Success Alert does not match expected value.");

            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Clicked NoTC Alert Popup Cross Icon");

        }

        else {
            log.info("Data exists. Adding SubFID.");

            pageObjectManager.getFreightDetail().clickSubFidAddIcon();
            log.info("Clicked SubFid Add Icon");

            String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
            log.info("Popup Heading is: {}", popupHeading);
            Assert.assertEquals(popupHeading, "Create Sub Freight", "Popup heading does not match expected value.");

            pageObjectManager.getBookedFreights().selectExportCompany("BEIJING CENTURY");
            log.info("Selected SubFid Export Company");

            pageObjectManager.getBookedFreights().selectShipper("ShenZhen JingSen");
            log.info("Selected SubFid Shipper");

            pageObjectManager.getBookedFreights().selectSubFidNoTc("TC1");
            log.info("Selected SubFid NoTC TC1");

            pageObjectManager.getBookedFreights().enterHouseBLNO(FakeDataUtil.getString());
            log.info("Entered SubFid House BL No");

            pageObjectManager.getBookedFreights().enterClientReference(FakeDataUtil.getString());
            log.info("Entered SubFid Client Ref");

            pageObjectManager.getFreightDetail().clickYesButton();
            log.info("Clicked Submit Button");

            String subFidSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
            log.info("Success Alert is: {}", subFidSuccessAlert);
            Assert.assertEquals(subFidSuccessAlert, "Sub FID successfully added", "Success Alert does not match expected value.");

            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Clicked Alert Popup Cross Icon");

            Thread.sleep(1000);

            pageObjectManager.getFreightDetail().selectLastSubFID();

        }
        pageObjectManager.getCargoDataPage().uploadAndSubmitCargoDataTc1(filePath, log);
        pageObjectManager.getCargoDataPage().exportCargoData();
    }
}