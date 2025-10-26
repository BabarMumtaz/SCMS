package com.LilyCargo.Pages;

import com.LilyCargo.Util.DropdownMethodUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DocumentCenterTestPage {

    WebDriver driver;
    WebDriverWait wait;
    DropdownMethodUtil dropdownUtil;

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

    public DocumentCenterTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.dropdownUtil = new DropdownMethodUtil(driver, wait);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//button[text()='Download']")
    WebElement downloadBtn;

    @FindBy(xpath = "//button[text()='Authorization Letter to Carrier PDF']")
    WebElement authorizationPdfBtn;

    @FindBy(xpath = "//button[text()='Discharge and Reloading Form PDF']")
    WebElement dischargePdfBtn;

    @FindBy(xpath = "//button[text()='Full Truck Transport Document PDF']")
    WebElement fullTruckPdfBtn;

    @FindBy(xpath = "//button[text()='Security Statement to Customs PDF']")
    WebElement securityPdfBtn;

    @FindBy(xpath = "//input[@name='mrn']")
    WebElement mrnNoField;

    @FindBy(xpath = "//input[@name='plato']")
    WebElement platoNoField;

    @FindBy(xpath = "//button[text()='THC Arrival Notice PDF']")
    WebElement thcArrivalPdfBtn;

    @FindBy(xpath = "//input[@name='letter_to']")
    WebElement letterToField;

    @FindBy(xpath = "//input[@name='vessel']")
    WebElement vesselField;

    @FindBy(xpath = "//input[@name='voyage_no']")
    WebElement voyageNoField;

    @FindBy(xpath = "//button[text()='Generate']")
    WebElement generateBtn;

    @FindBy(xpath = "//button[text()='Customs Value / Invoice PDF']")
    WebElement customsValuePdfBtn;

    @FindBy(xpath = "//button[text()='Packing List PDF']")
    WebElement packingListPdfBtn;

    @FindBy(xpath = "//button[text()='Cargo Manifest CV Excel']")
    WebElement cargoManifestExcelBtn;

    @FindBy(xpath = "//button[text()='Fiscal Rep Debit Note PDF']")
    WebElement fiscalRepDebitPdfBtn;

    @FindBy(xpath = "//label[contains(text(), 'Select Vat')]/following::div[@role='button'][1]")
    WebElement selectVatDropdown;

    @FindBy(xpath = "//button[text()='Fiscal Rep Credit Note PDF']")
    WebElement fiscalRepCreditPdfBtn;

    @FindBy(xpath = "//button[text()='Customs Release PDF']")
    WebElement customsReleasePdfBtn;

    @FindBy(xpath = "//button[text()='Customs Release per VAT PDF']")
    WebElement customsReleasePerVatPdfBtn;

    @FindBy(xpath = "//button[text()='Customs Release per Doc PDF']")
    WebElement customsReleasePerDocPdfBtn;

    @FindBy(xpath = "//button[text()='Customs Release Data Excel']")
    WebElement customsReleaseExcelBtn;

    @FindBy(xpath = "//button[text()='Multi FIDS CCA Report Excel']")
    WebElement multiFidsCcaExcelBtn;

    @FindBy(xpath = "//button[text()='Billed Charges Excel']")
    WebElement billedChargesExcelBtn;

    @FindBy(xpath = "//button[text()='CBAM Overview Excel']")
    WebElement cbamOverviewExcelBtn;

    @FindBy(xpath = "//button[text()='EUDR Overview Excel']")
    WebElement eudrOverviewExcelBtn;

    @FindBy(xpath = "//button[text()='MADB CV and Duty Excel']")
    WebElement madbCvExcelBtn;

    @FindBy(xpath = "//input[@name='storage_location']")
    WebElement storageLocationField;

    @FindBy(xpath = "//label[contains(text(), 'Logistic Operator')]/following::div[@role='button'][1]")
    WebElement logisticOperatorIdDropdown;

    @FindBy(xpath = "//input[@name='ctns']")
    WebElement ctnsField;

    /** ---------- Methods ---------- */

    public void clickDownloadBtn() {
        wait.until(ExpectedConditions.visibilityOf(downloadBtn)).click();
    }

    public void clickAuthorizationPdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(authorizationPdfBtn)).click();
    }

    public void clickDischargePdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(dischargePdfBtn)).click();
    }

    public void clickFullTruckPdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(fullTruckPdfBtn)).click();
    }

    public void clickSecurityPdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(securityPdfBtn)).click();
    }

    public void clickThcArrivalPdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(thcArrivalPdfBtn)).click();
    }

    public void clickCustomsValuePdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(customsValuePdfBtn)).click();
    }

    public void clickPackingListPdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(packingListPdfBtn)).click();
    }

    public void clickCargoManifestExcelBtn() {
        wait.until(ExpectedConditions.visibilityOf(cargoManifestExcelBtn)).click();
    }

    public void clickFiscalRepDebitPdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(fiscalRepDebitPdfBtn)).click();
    }

    public void clickFiscalRepCreditPdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(fiscalRepCreditPdfBtn)).click();
    }

    public void clickCustomsReleasePdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(customsReleasePdfBtn)).click();
    }

    public void clickCustomsReleasePerVatPdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(customsReleasePerVatPdfBtn)).click();
    }

    public void clickCustomsReleasePerDocPdfBtn() {
        wait.until(ExpectedConditions.visibilityOf(customsReleasePerDocPdfBtn)).click();
    }

    public void clickCustomsReleaseExcelBtn() {
        wait.until(ExpectedConditions.visibilityOf(customsReleaseExcelBtn)).click();
    }

    public void clickMultiFidsCcaExcelBtn() {
        wait.until(ExpectedConditions.visibilityOf(multiFidsCcaExcelBtn)).click();
    }

    public void clickBilledChargesExcelBtn() {
        wait.until(ExpectedConditions.visibilityOf(billedChargesExcelBtn)).click();
    }

    public void clickCbamOverviewExcelBtn() {
        wait.until(ExpectedConditions.visibilityOf(cbamOverviewExcelBtn)).click();
    }

    public void clickEudrOverviewExcelBtn() {
        wait.until(ExpectedConditions.visibilityOf(eudrOverviewExcelBtn)).click();
    }

    public void clickMadbCvExcelBtn() {
        wait.until(ExpectedConditions.visibilityOf(madbCvExcelBtn)).click();
    }

}


