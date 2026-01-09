package com.LilyCargo.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CargoDataTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Logger log = LogManager.getLogger(CargoDataTestPage.class);

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

    public CargoDataTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    WebElement cargoDataListingHs1stCell;

    @FindBy(xpath = "//p[text()='No data found']")
    List<WebElement> cargoDataListingEmptyArea;

    //button[@id='tc-no']
    @FindBy(id = "tc-no")
    WebElement noTcDropdown;

    @FindBy(xpath = "//div[@class='cargo-action-listbtn']//div[3]")
    WebElement exportCargoDataIcon;

    @FindBy(xpath = "//div[@class='cargo-action-listbtn']//div[4]")
    WebElement uploadCargoDataIcon;

    @FindBy(id = "remove-sub-fID")
    WebElement removeSubFidButton;

    @FindBy(id = "delete-cargo-data")
    WebElement deleteCargoDataButton;

    @FindBy(xpath = "//input[@name='file']")
    WebElement uploadCargoDataPopupChooseFile;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement uploadCargoDataPopupSubmitButton;

    @FindBy(xpath = "//button[text()='UPLOAD TEMPLATE']")
    WebElement uploadCargoDataPopupSubmitButtonTC1;

    @FindBy(className = "Toastify__toast-body")
    WebElement alertPopupText;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    /** ---------- Methods ---------- */

    public List<WebElement> getNoDataFoundElements() {
        return cargoDataListingEmptyArea;
    }

    public void clickRemoveSubFidButton() {
        wait.until(ExpectedConditions.visibilityOf(removeSubFidButton)).click();
    }

    public void clickDeleteCargoDataButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteCargoDataButton)).click();
    }

    public void selectDropdownButtonsByText(WebElement dropdownElement, String optionText) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click(); // open the dropdown
        log.info("Opened a dropdown");
        WebElement dropdownOption = wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath("//button[text()='" + optionText + "']"))));
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownOption);
        dropdownOption.click();
        log.info("Selected button from dropdown: {}", optionText);
    }

/*    public void selectDropdownByText(WebElement dropdownElement, String optionText) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click(); // open the dropdown
        log.info("Opened dropdown");
        WebElement dropdownOption = wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath("//li[contains(text(),'" + optionText + "')] "))));
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownOption);
        dropdownOption.click();
        log.info("Selected option: {}", optionText);
    }*/

    public void selectNoTc(String noTcValue) {
        selectDropdownButtonsByText(noTcDropdown, noTcValue);
    }

    public void clickOnExportCargoDataIcon() {
        wait.until(ExpectedConditions.visibilityOf(exportCargoDataIcon)).click();
    }

    public void clickOnUploadCargoDataIcon() {
        wait.until(ExpectedConditions.visibilityOf(uploadCargoDataIcon)).click();
    }

    public void uploadCargoDataInChooseFile(String filePath) {
        uploadCargoDataPopupChooseFile.sendKeys(filePath);
        log.info("Uploaded A file: {}", filePath);
    }

    public void clickCargoDataPopupSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadCargoDataPopupSubmitButton)).click();
    }

    public void clickCargoDataPopupSubmitButtonTc1() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadCargoDataPopupSubmitButtonTC1)).click();
    }

    public void clickOnAlertPopupCrossIcon() {
        wait.until(ExpectedConditions.visibilityOf(successAlertCrossIcon)).click();
    }

    public void isCargoAlertMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(alertPopupText)).isDisplayed();
    }

    public String getAlertPopupText() {
        return wait.until(ExpectedConditions.visibilityOf(alertPopupText)).getText().trim();
    }

    public void uploadAndSubmitCargoDataTc9(String filePath, Logger log) {

        clickOnUploadCargoDataIcon();
        log.info("Clicked upload icon");

        uploadCargoDataInChooseFile(filePath);
        log.info("File selected: {}", filePath);

        clickCargoDataPopupSubmitButton();
        log.info("Clicked Submit on upload popup");

        isCargoAlertMessageDisplayed();
        log.info("Upload confirmed: {}", getAlertPopupText());

        clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup");
    }

    public void uploadAndSubmitCargoDataTc1(String filePath, Logger log) {

        clickOnUploadCargoDataIcon();
        log.info("Clicked upload icon");

        uploadCargoDataInChooseFile(filePath);
        log.info("File selected: {}", filePath);

        clickCargoDataPopupSubmitButtonTc1();
        log.info("Clicked Submit on upload popup");

        isCargoAlertMessageDisplayed();
        log.info("Upload confirmed: {}", getAlertPopupText());

        clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup");
    }

    public void exportCargoData() {

        clickOnExportCargoDataIcon();
        log.info("Clicked Export icon");

        isCargoAlertMessageDisplayed();
        log.info("Upload confirmed: {}", getAlertPopupText());

        clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup");
    }
}