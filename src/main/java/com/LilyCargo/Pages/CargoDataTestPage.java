package com.LilyCargo.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CargoDataTestPage {
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Logger log = LogManager.getLogger(CargoDataTestPage.class);

    // Constructor
    public CargoDataTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    WebElement cargoDataListingHs1stCell;

    @FindBy(xpath = "//p[text()='No data found']")
    WebElement cargoDataListingEmptyArea;

    //button[@id='tc-no']
    @FindBy(id = "tc-no")
    WebElement noTcDropdown;

    @FindBy(xpath = "//button[text()='TC1']")
    WebElement noTcDropdownValue;

    @FindBy(xpath = "//div[@class='cargo-action-listbtn']//div[3]")
    WebElement exportCargoDataIcon;

    @FindBy(xpath = "//div[@class='cargo-action-listbtn']//div[4]")
    WebElement uploadCargoDataIcon;

    @FindBy(id = "delete-cargo-data")
    WebElement deleteCargoDataButton;

    @FindBy(css = ".lc-header-title.modal-title.h4")
    WebElement deleteCargoDataPopupHeading;

    @FindBy(css = ".text-center.my-3")
    WebElement deleteCargoDataPopupText;

    @FindBy(xpath = "//button[text()='Yes']")
    WebElement deleteCargoDataPopupSubmitButton;

    @FindBy(xpath = "//button[text()='No & Close']")
    WebElement deleteCargoDataPopupCancelButton;

    @FindBy(xpath = "//div[@class='lc-header-title modal-title h4']")
    WebElement uploadCargoDataPopupHeading;

    @FindBy(className = "btn-close")
    WebElement uploadCargoDataPopupCloseIcon;

    @FindBy(xpath = "//input[@name='file']")
    WebElement uploadCargoDataPopupChooseFile;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement uploadCargoDataPopupSubmitButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement uploadCargoDataPopupCancelButton;

    @FindBy(xpath = "//div[contains(text(),'Data successfully uploaded')]")
    WebElement uploadCargoSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    @FindBy(id = "72e9s8its")
    WebElement exportSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement exportSuccessAlertCrossIcon;

//	 -----------------------------------------------------------------------------------------------------------------------------------------------

    public String getCargoDataListingHs1stCellText() {
        return cargoDataListingHs1stCell.getText();
    }

    public boolean isCargoDataListingHs1stCellDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(cargoDataListingHs1stCell)).isDisplayed();
    }

    public boolean isCargoDataListingAreaDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(cargoDataListingEmptyArea)).isDisplayed();
    }

    public String getCargoDataListingAreaMessage() {
        return cargoDataListingEmptyArea.getText();
    }

    public WebElement getNoDataFound() {
        return cargoDataListingEmptyArea;
    }


    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void selectNoTc() {
        selectDropdownValue(noTcDropdown, noTcDropdownValue);
    }

    public void clickOnExportCargoDataIcon() {
        wait.until(ExpectedConditions.visibilityOf(exportCargoDataIcon)).click();
    }

    public void clickOnUploadCargoDataIcon() {
        wait.until(ExpectedConditions.visibilityOf(uploadCargoDataIcon)).click();
    }

    public String getUploadCargoDataPopupHeading() {
        return uploadCargoDataPopupHeading.getText();
    }

    public boolean isUploadCargoDataPopupDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(uploadCargoDataPopupHeading)).isDisplayed();
    }

    public void clickOnUploadCargoDataPopupCloseIcon() {
        wait.until(ExpectedConditions.visibilityOf(uploadCargoDataPopupCloseIcon)).click();
    }

    public void uploadCargoDataInChooseFile(String filePath) {
        uploadCargoDataPopupChooseFile.sendKeys(filePath);
        log.info("Uploaded A file: " + filePath);
    }

    public void clickCargoDataPopupSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadCargoDataPopupSubmitButton)).click();
    }

    public void clickCargoDataPopupCancelButton() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadCargoDataPopupCancelButton)).click();
    }

    public boolean isUploadCargoSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(uploadCargoSuccessAlertMessage)).isDisplayed();
    }

    public String getUploadCargoSuccessAlertMessage() {
        return uploadCargoSuccessAlertMessage.getText();
    }


    public void clickOnAlertPopupCrossIcon() {
        wait.until(ExpectedConditions.visibilityOf(successAlertCrossIcon)).click();
    }

    public String getExportSuccessAlertMessage() {
        return exportSuccessAlertMessage.getText();
    }

    public boolean isExportSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(exportSuccessAlertMessage)).isDisplayed();
    }

    public void clickOnExportAlertPopupCrossIcon() {
        wait.until(ExpectedConditions.visibilityOf(exportSuccessAlertCrossIcon)).click();
    }

    public void uploadAndSubmitCargoData(String filePath, Logger log) {

        clickOnUploadCargoDataIcon();
        log.info("📤 Clicked upload icon");

        uploadCargoDataInChooseFile(filePath);
        log.info("📎 File selected: " + filePath);

        clickCargoDataPopupSubmitButton();
        log.info("📨 Clicked Submit on upload popup");

        isUploadCargoSuccessAlertMessageDisplayed();
        log.info("✅ Upload confirmed: " + getUploadCargoSuccessAlertMessage());
    }


}