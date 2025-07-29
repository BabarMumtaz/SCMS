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
    @Epic("EP001")
    @Feature("Feature:003")
    @Story("As a user, I should be able to Upload Cargo Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add carrier")
    public void CargoDataUploadTest() throws InterruptedException {

        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\TC9 Upload Data - 38 Records.xlsx";

        log = LogManager.getLogger(UploadCargoDataTest.class);
        log.info("Test setup completed.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        pageObjectManager.getFreightDetail().scrollToRight();
        log.info("Clicked Incidents Registration Tab");

        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");
        log.info("Edit wrapper is displayed.");

        pageObjectManager.getFreightDetail().clickCargoDataTab();
        log.info("Clicked Cargo Data Tab");

        //----------------------------------Cargo Data Tab----------------------------------

        List<WebElement> noDataElements = pageObjectManager.getCargoDataPage().getNoDataFoundElements(); // This should return List<WebElement>

        if (!noDataElements.isEmpty() && noDataElements.get(0).isDisplayed()) {
            log.info("📄 'No data found' is displayed. Proceeding to upload.");

            pageObjectManager.getCargoDataPage().selectNoTc();
            log.info("Selected NoTC");

            Assert.assertTrue(pageObjectManager.getCargoDataPage().isUpdateNoTcSuccessAlertMessageDisplayed(), "NoTc update Alert popup Not Displayed");
            log.info("NoTC Success Alert Message: " + pageObjectManager.getCargoDataPage().getUpdateNoTcSuccessAlertMessage());

            pageObjectManager.getFreightDetail().clickOnAlertPopupCrossIcon();
            log.info("Clicked NoTC Alert Popup Cross Icon");

            pageObjectManager.getCargoDataPage().uploadAndSubmitCargoData(filePath, log);
        }

        else {
            log.info("📌 Data exists. Adding SubFID.");

            pageObjectManager.getFreightDetail().clickSubFidAddIcon();
            log.info("Clicked SubFid Add Icon");

            Assert.assertTrue(pageObjectManager.getFreightDetail().isCreateSubFidPopupHeadingDisplayed(), "SubFid  Alert popup Not Displayed");
            log.info("Popup Heading: " + pageObjectManager.getFreightDetail().getCreateSubFidPopupHeading());

            pageObjectManager.getFreightDetail().selectSubFidShipper();
            log.info("Selected SubFid Shipper");

/*            pageObjectManager.getFreightDetail().selectSubFidNoTc();
            log.info("Selected SubFid NoTC");*/

            pageObjectManager.getFreightDetail().enterSubFidHblNo(FakeDataUtil.getHouseBLNo());
            log.info("Entered SubFid House BL No");

            pageObjectManager.getFreightDetail().enterSubFidClientRef(FakeDataUtil.getHouseBLNo());
            log.info("Entered SubFid Client Ref");

            pageObjectManager.getFreightDetail().clickSubmitSubFidButton();
            log.info("Clicked Submit Button");

            Assert.assertTrue(pageObjectManager.getFreightDetail().isSubFidAddSuccessAlertMessageDisplayed(), "Sub FID Creation Success Alert Message Not Displayed");
            log.info("Success Alert Message: " + pageObjectManager.getFreightDetail().getSubFidAddSuccessAlertMessage());

            pageObjectManager.getFreightDetail().clickOnAlertPopupCrossIcon();
            log.info("Clicked Alert Popup ");

            Thread.sleep(2000);

            pageObjectManager.getFreightDetail().selectLastSubFID();

            pageObjectManager.getCargoDataPage().uploadAndSubmitCargoData(filePath, log);
        }
    }
}