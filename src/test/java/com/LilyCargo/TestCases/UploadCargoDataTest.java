package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UploadCargoDataTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can Upload Cargo Data successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Upload Cargo Data successfully")
    @Epic("Booked Freight 03")
    @Feature("Feature:03.11_Cargo Data")
    @Story("As a user, I should be able to Upload Cargo Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Open Freight Detail > Upload Cargo Data")
    public void CargoDataUploadTest() throws InterruptedException {

        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\TC9 Upload Data - 38 Records.xlsx";

        log = LogManager.getLogger(UploadCargoDataTest.class);
        log.info("Test setup completed.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");
        log.info("Edit wrapper is displayed.");

        pageObjectManager.getFreightDetail().scrollToRight();
        log.info("Clicked Incidents Registration Tab");

        Thread.sleep(1000);

        pageObjectManager.getFreightDetail().clickCargoDataTab();
        log.info("Clicked Cargo Data Tab");

        String tabHeading = pageObjectManager.getFreightDetail().getCargoDataTabText();
        log.info("Tab Heading is: " + tabHeading);
        Assert.assertEquals(tabHeading, "Cargo Data", "Page heading does not match expected value.");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Fid Number is: " + fidNumber);

        /** ---------- Cargo Data Tab ---------- */

        List<WebElement> noDataElements = pageObjectManager.getCargoDataPage().getNoDataFoundElements(); // This should return List<WebElement>

        if (!noDataElements.isEmpty() && noDataElements.getFirst().isDisplayed()) {
            log.info("📄 'No data found' is displayed. Proceeding to upload.");

            pageObjectManager.getCargoDataPage().selectNoTc("TC9");
            log.info("Selected NoTC 9");

            String noTcSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
            log.info("NoTC Success Alert is: {}", noTcSuccessAlert);
            Assert.assertEquals(noTcSuccessAlert, "NoTC updated", "Success Alert does not match expected value.");

            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Clicked NoTC Alert Popup Cross Icon");

            pageObjectManager.getCargoDataPage().uploadAndSubmitCargoData(filePath, log);

            pageObjectManager.getCargoDataPage().exportCargoData();
        }

        else {
            log.info("📌 Data exists. Adding SubFID.");

            pageObjectManager.getFreightDetail().clickSubFidAddIcon();
            log.info("Clicked SubFid Add Icon");

            String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
            log.info("Popup Heading is: {}", popupHeading);
            Assert.assertEquals(popupHeading, "Create Sub Freight", "Popup heading does not match expected value.");

            pageObjectManager.getBookedFreights().selectExportCompany("BEIJING CENTURY");
            log.info("Selected SubFid Export Company");

            pageObjectManager.getBookedFreights().selectShipper("ShenZhen JingSen");
            log.info("Selected SubFid Shipper");

            pageObjectManager.getBookedFreights().selectSubFidNoTc("TC9");
            log.info("Selected SubFid NoTC");

            pageObjectManager.getBookedFreights().enterHouseBLNO(FakeDataUtil.getString());
            log.info("Entered SubFid House BL No");

            pageObjectManager.getBookedFreights().enterClientReference(FakeDataUtil.getString());
            log.info("Entered SubFid Client Ref");

            pageObjectManager.getFreightDetail().clickSubmitSubFidButton();
            log.info("Clicked Submit Button");

            String subFidSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
            log.info("Success Alert is: {}", subFidSuccessAlert);
            Assert.assertEquals(subFidSuccessAlert, "Sub FID successfully added", "Success Alert does not match expected value.");

            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Clicked Alert Popup Cross Icon");

            Thread.sleep(1000);

            pageObjectManager.getFreightDetail().selectLastSubFID();

            pageObjectManager.getCargoDataPage().uploadAndSubmitCargoData(filePath, log);

            pageObjectManager.getCargoDataPage().exportCargoData();
        }
    }
}