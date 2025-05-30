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


        // Check if 'No data found' is visible
        WebElement noDataMessage = pageObjectManager.getCargoDataPage().getNoDataFound();

        public void handleCargoDataUpload (String filePath){

            if (noDataMessage.isDisplayed()) {
                log.info("📄 'No data found' is displayed. Proceeding to upload.");

                uploadAndSubmitCargoData(filePath, log);

            } else {
                log.info("📌 Data exists. Adding SubFID.");

                pageObjectManager.getFreightDetail().clickSubFidAddIcon();
                log.info("Clicked SubFid Add Icon");

                Assert.assertTrue(pageObjectManager.getFreightDetail().isCreateSubFidPopupHeadingDisplayed(), "SubFid popup Not Displayed");
                log.info("Popup Heading: " + pageObjectManager.getFreightDetail().getCreateSubFidPopupHeading());

                pageObjectManager.getFreightDetail().selectSubFidShipper();
                log.info("Selected SubFid Shipper");

                pageObjectManager.getFreightDetail().selectSubFidNoTc();
                log.info("Selected SubFid NoTC");

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

/*            // Open SubFID dropdown and select the last non-'A' SubFID
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='subfid-dropdown']")));
            dropdown.click();

            List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul/li[not(text()='A')]")));

            WebElement lastOption = options.get(options.size() - 1);
            String selectedSubFid = lastOption.getText();
            lastOption.click();
            log.info("🔁 Switched to SubFID: " + selectedSubFid);*/


                // 3. Select last option from the <select> dropdown (other than 'A')

                WebElement subFidDropdown = pageObjectManager.getFreightDetail().getSubFidDrop();

                List<WebElement> options = subFidDropdown.getOptions();
                for (int i = options.size() - 1; i >= 0; i--) {
                    String val = options.get(i).getText().trim();
                    if (!val.equalsIgnoreCase("A") && !val.equalsIgnoreCase("None")) {
                        subFidDropdown.selectByVisibleText(val);
                        log.info("🔁 Selected SubFID from dropdown: " + val);
                        break;
                    }

                    // Proceed to upload
                    uploadAndSubmitCargoData(filePath, log);
                }


                Assert.assertTrue(pageObjectManager.getCargoDataPage().isCargoDataListingHs1stCellDisplayed(), "Cargo Data Listing Hs 1st Cell Not Displayed");
                log.info("Tab Heading: " + pageObjectManager.getCargoDataPage().getCargoDataListingHs1stCellText());

/*        pageObjectManager.getCargoDataPage().selectNoTc();
        log.info("Selected NoTC");*/

                Assert.assertTrue(pageObjectManager.getCargoDataPage().isCargoDataListingAreaDisplayed(), "Cargo Data Listing Hs 1st Cell Not Displayed");
                log.info("Section Heading: " + pageObjectManager.getCargoDataPage().getCargoDataListingAreaMessage());

                pageObjectManager.getCargoDataPage().clickOnUploadCargoDataIcon();
                log.info("Clicked Upload Cargo Data Icon");

                Assert.assertTrue(pageObjectManager.getCargoDataPage().isUploadCargoDataPopupDisplayed(), "Cargo Data Listing Hs 1st Cell Not Displayed");
                log.info("Heading: " + pageObjectManager.getCargoDataPage().getUploadCargoDataPopupHeading());

                pageObjectManager.getCargoDataPage().clickCargoDataPopupSubmitButton();
                log.info("Clicked Submit Button");

                Assert.assertTrue(pageObjectManager.getCargoDataPage().isUploadCargoSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
                log.info("Heading: " + pageObjectManager.getCargoDataPage().getUploadCargoSuccessAlertMessage());

                pageObjectManager.getCargoDataPage().clickOnAlertPopupCrossIcon();
                log.info("Clicked Alert Popup ");

                pageObjectManager.getCargoDataPage().clickOnExportCargoDataIcon();
                log.info("Clicked Export Cargo Data Icon");

                Assert.assertTrue(pageObjectManager.getCargoDataPage().isExportSuccessAlertMessageDisplayed(), "Export Success Alert Message Not Displayed");
                log.info("Success Alert Message: " + pageObjectManager.getCargoDataPage().getExportSuccessAlertMessage());

                pageObjectManager.getCargoDataPage().clickOnExportAlertPopupCrossIcon();
                log.info("Clicked Alert Popup ");

                // Log out after the test
                pageObjectManager.getLoginPage().logout();
                log.info("Logged out successfully.");
            }
        }
    }
}

/*
        public void uploadAndSubmitCargoData (String filePath){

            // Click upload icon
            pageObjectManager.getCargoDataPage().clickOnUploadCargoDataIcon();
            log.info("Clicked Upload Cargo Data Icon");

            Assert.assertTrue(pageObjectManager.getCargoDataPage().isUploadCargoDataPopupDisplayed(), "Cargo Data Listing Hs 1st Cell Not Displayed");
            log.info("Heading: " + pageObjectManager.getCargoDataPage().getUploadCargoDataPopupHeading());

            filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\TC9 Upload Data - 38 Records.xlsx";
            pageObjectManager.getCargoDataPage().uploadCargoDataInChooseFile(filePath);
            log.info("Uploaded A file");

            pageObjectManager.getCargoDataPage().clickCargoDataPopupSubmitButton();
            log.info("Clicked Submit Button");

            Assert.assertTrue(pageObjectManager.getCargoDataPage().isUploadCargoSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
            log.info("Heading: " + pageObjectManager.getCargoDataPage().getUploadCargoSuccessAlertMessage());

        }*/
