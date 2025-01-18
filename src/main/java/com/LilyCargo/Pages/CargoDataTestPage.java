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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    WebElement cargoDataListingHs1stCell;

    @CacheLookup
    @FindBy(xpath = "//p[text()='No data found']")
    WebElement cargoDataListingEmptyArea;

    @CacheLookup
    //button[@id='tc-no']
    @FindBy(id = "tc-no")
    WebElement noTcDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[text()='TC1']")
    WebElement noTcDropdownValue;

    @CacheLookup
    @FindBy(xpath = "//div[@class='cargo-action-listbtn']//div[3]")
    WebElement exportCargoDataIcon;

    @CacheLookup
    @FindBy(xpath = "//div[@class='cargo-action-listbtn']//div[4]")
    WebElement uploadCargoDataIcon;

    @CacheLookup
    @FindBy(className = "//div[@class='lc-header-title modal-title h4']")
    WebElement uploadCargoDataPopupHeading;

    @CacheLookup
    @FindBy(className = "btn-close")
    WebElement uploadCargoDataPopupCloseIcon;

    @CacheLookup
    @FindBy(className = "//input[@name='file']")
    WebElement uploadCargoDataPopupChooseFile;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement uploadCargoDataPopupSubmitButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement uploadCargoDataPopupCancelButton;

    @CacheLookup
    @FindBy(id = "79vn6timw")
    WebElement successAlertMessage;

    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

//	 -----------------------------------------------------------------------------------------------------------------------------------------------

    public String getCargoDataListingHs1stCellText() {
        return cargoDataListingHs1stCell.getText();
    }

    public boolean isCargoDataListingHs1stCellDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(cargoDataListingHs1stCell)).isDisplayed();
    }

    public String getCargoDataListingAreaMessage() {
        return cargoDataListingEmptyArea.getText();
    }

    public boolean isCargoDataListingAreaDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(cargoDataListingEmptyArea)).isDisplayed();
    }

    public void enterIncidentsRegPopupProblemField(String text) {
        incidentsRegPopupProblemField.sendKeys(text);
    }

    public void clickOnExportCargoDataIcon() {
        wait.until(ExpectedConditions.visibilityOf(exportCargoDataIcon)).click();
    }

    public void clickOnUploadCargoDataIcon() {
        wait.until(ExpectedConditions.visibilityOf(uploadCargoDataIcon)).click();
    }

    public void clickSubmitIncidentsRegButton() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadCargoDataPopupSubmitButton)).click();
    }

    public void clickCancelIncidentsRegButton() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadCargoDataPopupCancelButton)).click();
    }

    public void clickOnUploadCargoDataPopupCloseIcon() {
        wait.until(ExpectedConditions.visibilityOf(uploadCargoDataPopupCloseIcon)).click();
    }

    public String getSuccessAlertMessage() {
        return successAlertMessage.getText();
    }

    public boolean isSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(successAlertMessage)).isDisplayed();
    }

    public void clickOnAlertPopupCrossIcon() {
        wait.until(ExpectedConditions.visibilityOf(successAlertCrossIcon)).click();
    }
}