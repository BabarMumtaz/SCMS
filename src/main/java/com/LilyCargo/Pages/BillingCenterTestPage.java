package com.LilyCargo.Pages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class BillingCenterTestPage {
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Logger log = LogManager.getLogger(BillingCenterTestPage.class);
    public static Faker faker;

    // Constructor
    public BillingCenterTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        faker = new Faker();
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
    //(//div[@id='select-PID'])[1]
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
    //@FindBy(id = "select-PID")
    @FindBy(xpath = "//input[@name='products[3].product_id']")
    WebElement pidDropdown;

    @CacheLookup
    @FindBy(xpath = "//li[text()='80210 - 2% Disbursement Fee']")
    WebElement pidDropdownValue;

    @CacheLookup
    @FindBy(xpath = "//button[text()='+ Add Row']")
    WebElement addRowButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Save Works']")
    WebElement saveWorksButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Finish INV']")
    WebElement finishINVButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Total Entries by Ledger']")
    WebElement totalEntriesByLedgerTabPE;

    @CacheLookup
    @FindBy(xpath = "//input[@name='supplier")
    WebElement shipperDropdown;

    @CacheLookup
    @FindBy(xpath = "//li[text()='BTT Multimodal Container Solutions B.V.']")
    WebElement shipperDropdownValue;

    @CacheLookup
    @FindBy(xpath = "//input[@name='InvoiceNumber']")
    WebElement invoiceNumberPE;

    @CacheLookup
    @FindBy(xpath = "//input[@name='invoiceDate']")
    WebElement invoiceDatePE;

    @CacheLookup
    @FindBy(xpath = "//input[@name='totalAmount']")
    WebElement totalAmount;

    @CacheLookup
    @FindBy(id = "invoice_pdf")
    WebElement attachPdfPE;

    @CacheLookup
    //@FindBy(id = "select-PID")
    @FindBy(xpath = "(//div[@id='select-Select'])[1]")
    WebElement productDropdownPE;

    @CacheLookup
    //(//li[contains(text(),'23025 - Duty')])[1]
    @FindBy(xpath = "//li[text()='23025 - Duty  payable (Credit)")
    WebElement productDropdownValuePE;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Manual'])[1]")
    WebElement amountEur;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Push & New']")
    WebElement pushNewINVButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Push & Back']")
    WebElement pushBackINVButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Charges']")
    WebElement chargesTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Push All Invoices Exact']")
    WebElement pushAllInvoicesExactButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Push All Invoices Amazon']")
    WebElement pushAllInvoicesAmazonButton;

    //EXTRA INVOICE

    @CacheLookup
    @FindBy(id = "select-Client")
    WebElement clientDropdownEI;

    @CacheLookup
    @FindBy(xpath = "//li[text()='A.I. Trading GmbH']")
    WebElement clientDropdownValueEI;

    @CacheLookup
    @FindBy(xpath = "//input[@name='invoice_date']")
    WebElement invoiceDateEI;

    @CacheLookup
    @FindBy(xpath = "//input[@id='inv']")
    WebElement invoiceNumberEI;

    @CacheLookup
    @FindBy(xpath = "//input[@name='remarks[0]']")
    WebElement remarksFieldEI;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Add More']")
    WebElement addMoreButtonEI;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'input-grouped')]//*[name()='svg']")
    WebElement remarksCrossIconEI;

    @CacheLookup
    @FindBy(id = "select-Ledger Type")
    WebElement selectLedgerTypeDropdown;

    // International, and European
    @CacheLookup
    @FindBy(xpath = "//li[text()='International']")
    WebElement selectLedgerTypeDropdownValue;

    // PROFORMA INVOICE, and SALE INVOICE
    @CacheLookup
    @FindBy(xpath = "//li[text()='PROFORMA INVOICE']")
    WebElement invoiceTypeDropdownValueEI;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelButtonEI;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButtonEI;

    @CacheLookup
    @FindBy(id = "ytr46dned")
    WebElement successAlertMessage;

    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    @CacheLookup
    @FindBy(xpath = "(//img[contains(@alt,'Edit')])[1]")
    WebElement invoiceEditIcon;

    @CacheLookup
    @FindBy(xpath = "(//span[@title='download-invoice'])[1]")
    WebElement downloadInvoiceIcon;

    @CacheLookup
    @FindBy(xpath = "(//span[@title='push-invoice'])[1]")
    WebElement pushToExactIcon;

    @CacheLookup
    @FindBy(xpath = "(//span[@title='Push to Amazon'])[1]")
    WebElement pushToAmazonIcon;

    @CacheLookup
    @FindBy(xpath = "//h4[text()='Recently Billed Invoices']")
    WebElement billedInvoiceTabRecentlyBilledInvoicesHeading;

    @CacheLookup
    @FindBy(xpath = "(//select[@class='w-25 me-1 form-select'])[1]")
    WebElement allInvoiceTypesDropdown;

    // All, Exact, and Amazon
    @CacheLookup
    @FindBy(xpath = "//option[@value='exact']")
    WebElement allInvoiceTypesDropdownValue;

    @CacheLookup
    @FindBy(xpath = "(//select[@class='w-25 me-1 form-select'])[2]")
    WebElement allInvoicePushedDropdown;

    // All, Exact, and Amazon
    @CacheLookup
    @FindBy(xpath = "//option[@value='unpushed']")
    WebElement allInvoicePushedDropdownValue;

    @CacheLookup
    @FindBy(className = "input-group input-group")
    WebElement invoiceSearch;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-addon2']//img")
    WebElement invoiceSearchIcon;


    //	 ------------------------------------------------------------------------------------------------------------------------------------------------

    public void clickOnIntlInvTab() {
        wait.until(ExpectedConditions.visibilityOf(intlInvTab)).click();
    }

    public void clickOnEulInvTab() {
        wait.until(ExpectedConditions.visibilityOf(euInvTab)).click();
    }

    public void clickOnPurchaseEntryTab() {
        wait.until(ExpectedConditions.visibilityOf(purchaseEntryTab)).click();
    }
    public void clickOnBilledInvoicesTab() {
        wait.until(ExpectedConditions.visibilityOf(billedInvoicesTab)).click();
    }

    public void clickOnExtraInvTab() {
        wait.until(ExpectedConditions.visibilityOf(extraInvTab)).click();
    }

    public void clickOnInvoiceDetailsTab() {
        wait.until(ExpectedConditions.visibilityOf(invoiceDetailsTab)).click();
    }

    public void clickOnProductServicesTab() {
        wait.until(ExpectedConditions.visibilityOf(productServicesTab)).click();
    }

    public void clickOnNilledChargesTab() {
        wait.until(ExpectedConditions.visibilityOf(billedChargesTab)).click();
    }

    public boolean isClientDropdownDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(clientDropdown)).isDisplayed();
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void selectClient() {
        selectDropdownValue(clientDropdown, clientDropdownValue);
    }

    public void selectInvoiceType() {
        selectDropdownValue(invoiceTypeDropdown, invoiceTypeDropdownValue);
    }

    public void enterRemarks(String text) {
        remarksField.sendKeys(text);
    }

    private void selectDate(WebElement element, String month,String day, String year) {
        actions.click(element).sendKeys(month).sendKeys(day).sendKeys(year).perform();
    }

    public void selectIntlEuInvDate(String month,String day, String year) {
        selectDate(invDate, month, day, year);
    }

 //   private  String generateInvoiceNumber;

    // Method to generate invoice number
    public String generateInvoiceNumber() {
        // Generate a random number for the invoice part (e.g., 010155)
        String invoicePart = faker.number().digits(6);

        // Generate a random uppercase letter for the prefix (e.g., 25X)
        String prefix = faker.letterify("25?", true);

        // Combine prefix and invoice part
        return prefix + "-" + invoicePart;
    }

    // Method to enter invoice number into the invoiceNumber field
    public void enterInvoiceNumber(String invoice) {
        invoiceNumber.sendKeys(invoice);
    }

    public void enterAdminFee(String text) {
        actions.click(graceDays).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .perform();
        graceDays.sendKeys(text);
    }

    public void selectPidDropdown() {
        selectDropdownValue(pidDropdown, pidDropdownValue);
    }

    public void clickSaveWorksButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveWorksButton)).click();
    }

    public void clickFinishINVButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finishINVButton)).click();
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
