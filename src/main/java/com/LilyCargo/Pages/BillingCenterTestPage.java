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

public class BillingCenterTestPage {
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Logger log = LogManager.getLogger(BillingCenterTestPage.class);

    // Constructor
    public BillingCenterTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    @CacheLookup
    @FindBy(xpath = "//button[text()='INTL INV']")
    WebElement intlInvTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()='EU INV']")
    WebElement euInvTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Purchase Entry']")
    WebElement purchaseEntryTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Billed Invoices']")
    WebElement billedInvoicesTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Extra INV']")
    WebElement extraInvTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Invoice Details']")
    WebElement invoiceDetailsTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Product Services']")
    WebElement productServicesTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Billed Charges']")
    WebElement billedChargesTab;

    @CacheLookup
    @FindBy(id = "select-Invoice Type")
    WebElement invoiceTypeDropdown;

    // STANDARD, AMAZON BROKERAGE INV, AMAZON DUTY INV, and CREDIT INV
    @CacheLookup
    @FindBy(xpath = "//li[text()='STANDARD']")
    WebElement invoiceTypeDropdownValue;

    @CacheLookup
    @FindBy(xpath = "//input[@name='remarks']")
    WebElement remarksField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='selectable-Connected Client']")
    WebElement clientDropdown;

    @CacheLookup
    @FindBy(xpath = "//li[text()='Amazon EU SARL, Dutch Branch']")
    WebElement clientDropdownValue;

    @CacheLookup
    @FindBy(xpath = "//input[@name='invDate']")
    WebElement invDate;

    @CacheLookup
    @FindBy(xpath = "//input[@id='InvoiceNumber']")
    WebElement invoiceNumber;

    @CacheLookup
    @FindBy(xpath = "//input[@name='grace_days']")
    WebElement graceDays;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Import/Sales Remarks']")
    WebElement importSalesRemarksButton;

    @CacheLookup
    @FindBy(xpath = "//div[text()=' Remarks ']")
    WebElement remarksPopupHeading;

    @CacheLookup
    @FindBy(className = "btn-close")
    WebElement remarksPopupCloseIcon;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Notepad++']")
    WebElement notepadButton;

    @CacheLookup
    @FindBy(xpath = "//div[text()='Agreement Notes']")
    WebElement notepadPopupHeading;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Email Client']")
    WebElement emailClientButton;

    @CacheLookup
    @FindBy(id = "select-PID")
    WebElement pidDropdown;

    @CacheLookup
    @FindBy(xpath = "//li[text()='80210 - 2% Disbursement Fee']")
    WebElement pidDropdownValue;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitFycoDataButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelFycoDataButton;

    @CacheLookup
    @FindBy(id = "sv88jm5lo")
    WebElement successAlertMessage;

    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='Edit']")
    WebElement fycoDataEditIcon;

    @CacheLookup
    @FindBy(xpath = "//div[text()='Update']")
    WebElement fycoDataEditPopupHeading;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Update']")
    WebElement updateFycoDataButton;

    //	 ------------------------------------------------------------------------------------------------------------------------------------------------

    public void clickOnFycoDataAddIcon() {
        wait.until(ExpectedConditions.visibilityOf(fycoDataAddIcon)).click();
    }

    public String getPopupHeading() {
        return fycoDataPopupHeading.getText();
    }

    public boolean isFycoDataPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(fycoDataPopupHeading)).isDisplayed();
    }

    public void enterPlatoNumberField(String text) {
        platoNumberField.sendKeys(text);
    }

    public void enterArticleNumberField(String text) {
        articleNumberField.sendKeys(text);
    }

    public void enterHsTaricNumberField(String text) {
        hsTaricNumberField.sendKeys(text);
    }

    public void enterProductDescriptionField(String text) {
        productDescriptionField.sendKeys(text);
    }

    public void enterCtnsNumberField(String text) {
        ctnsNumberField.sendKeys(text);
    }

    public void enterPcsField(String text) {
        pcsField.sendKeys(text);
    }

    public void enterGrossKGField(String text) {
        grossKGField.sendKeys(text);
    }

    public void enterCvEuroField(String text) {
        cvEuroField.sendKeys(text);
    }

    public void scrollToBottom() {
        wait.until(ExpectedConditions.visibilityOf(submitFycoDataButton)); // Ensure visibility
        executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitFycoDataButton);
        wait.until(ExpectedConditions.elementToBeClickable(submitFycoDataButton));
    }

    public void clickSubmitFycoDataButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitFycoDataButton)).click();
    }

    public void clickCancelFycoDataButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelFycoDataButton)).click();
    }

    public void clickOnFycoDataPopupCloseIcon() {
        wait.until(ExpectedConditions.visibilityOf(fycoDataPopupCloseIcon)).click();
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

    public boolean isFycoDataEditIconDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(fycoDataEditIcon)).isDisplayed();
    }

    public void clickOnFycoDataEditIcon() {
        wait.until(ExpectedConditions.visibilityOf(fycoDataEditIcon)).click();
    }

    public boolean isFycoDataEditPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(fycoDataEditPopupHeading)).isDisplayed();
    }

    public void clickUpdateFycoDataButton() {
        wait.until(ExpectedConditions.elementToBeClickable(updateFycoDataButton)).click();
    }

}
