package com.LilyCargo.Pages;

import com.LilyCargo.Util.DropdownMethodUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    DropdownMethodUtil dropdownUtil;

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

    public DocumentCenterTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        this.dropdownUtil = new DropdownMethodUtil(driver, wait);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//button[text()='Authorization Letter to Carrier PDF']")
    WebElement authorizationPdfBtn;

    @FindBy(xpath = "//button[text()='Discharge and Reloading Form PDF']")
    WebElement dischargePdfBtn;

    @FindBy(xpath = "//button[text()='Full Truck Transport Document PDF']")
    WebElement fullTruckPdfBtn;

    @FindBy(xpath = "//button[text()='Security Statement to Customs PDF']")
    WebElement securityPdfBtn;

    @FindBy(xpath = "//button[text()='THC Arrival Notice PDF']")
    WebElement THCArrivalPdfBtn;

    @FindBy(xpath = "//button[text()='Customs Value / Invoice PDF']")
    WebElement customsValuePdfBtn;

    @FindBy(xpath = "//button[text()='Packing List PDF']")
    WebElement packingListPdfBtn;

    @FindBy(xpath = "//button[text()='Cargo Manifest CV Excel']")
    WebElement cargoManifestExcelBtn;

    @FindBy(xpath = "//button[text()='Multi FIDS CCA Report Excel']")
    WebElement customsValueBtn;

    @FindBy(xpath = "//button[text()='Fiscal Rep Debit Note PDF']")
    WebElement fiscalRepDebitPdfBtn;

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
    WebElement CbamOverviewExcelBtn;

    @FindBy(xpath = "//button[text()='EUDR Overview Excel']")
    WebElement EudrOverviewExcelBtn;

    @FindBy(xpath = "//button[text()='MADB CV and Duty Excel']")
    WebElement madbCvExcelBtn;

    @FindBy(xpath = "//input[@name='storage_location']")
    WebElement storageLocationField;

    @FindBy(xpath = "//label[contains(text(), 'Logistic Operator')]/following::div[@role='button'][1]")
    WebElement logisticOperatorIdDropdown;

    @FindBy(xpath = "//input[@name='ctns']")
    WebElement ctnsField;

    /** ---------- Methods ---------- */

    public void clickManageStorageLocationBtn() {
        wait.until(ExpectedConditions.visibilityOf(manageStorageLocationBtn)).click();
    }

    public void clickAddNewDeliveryBtn() {
        wait.until(ExpectedConditions.visibilityOf(addNewDeliveryBtn)).click();
    }

    public void enterStorageLocationField(String text) {
        actions.click(storageLocationField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .perform();
        storageLocationField.sendKeys(text);
    }

    public void enterCtns(String text) {
        ctnsField.sendKeys(text);
    }

    public void clickDeliverAllBtn() {
        wait.until(ExpectedConditions.visibilityOf(deliverAllBtn)).click();
    }

    public void selectLogisticsOperator(String logisticsOperator) {
        dropdownUtil.selectDropdownByText(logisticOperatorIdDropdown, logisticsOperator);
    }
}


