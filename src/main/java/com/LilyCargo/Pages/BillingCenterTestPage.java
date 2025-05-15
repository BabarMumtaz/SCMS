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

    @FindBy(xpath = "//button[text()='INTL INV']")
    WebElement intlInvTab;

    @FindBy(xpath = "//button[text()='EU INV']")
    WebElement euInvTab;

    @FindBy(xpath = "//button[text()='Purchase Entry']")
    WebElement purchaseEntryTab;

    @FindBy(xpath = "//button[text()='Billed Invoices']")
    WebElement billedInvoicesTab;

    @FindBy(xpath = "//button[text()='Extra INV']")
    WebElement extraInvTab;

    @FindBy(xpath = "//button[text()='Invoice Details']")
    WebElement invoiceDetailsTab;

    @FindBy(xpath = "//button[text()='Product Services']")
    WebElement productServicesTab;

    @FindBy(xpath = "//button[text()='Billed Charges']")
    WebElement billedChargesTab;

    @FindBy(id = "select-Invoice Type")
    WebElement invoiceTypeDropdown;

    // STANDARD, AMAZON BROKERAGE INV, AMAZON DUTY INV, and CREDIT INV
    @FindBy(xpath = "//li[text()='AMAZON BROKERAGE INV']")
    WebElement invoiceTypeDropdownValue;

    @FindBy(xpath = "//input[@name='remarks']")
    WebElement remarksField;

    @FindBy(xpath = "//button[@title='Clear']//*[name()='svg']")
    WebElement clientDropdownCrossIcon;

    //(//div[@id='select-PID'])[1]
    @FindBy(xpath = "//div[@class=' css-ackcql']")
    WebElement clientDropdown;

    @FindBy(xpath = "//div[@class=' css-ackcql']//input")
    WebElement clientDropdownInput;

    //------
    @FindBy(xpath = "//div[text()='Amazon EU SARL, Dutch Branch']")
    WebElement clientDropdownValue;

    @FindBy(xpath = "//input[@name='invDate']")
    WebElement invDate;

    @FindBy(xpath = "//input[@id='InvoiceNumber']")
    WebElement invoiceNumber;

    @FindBy(xpath = "//input[@name='grace_days']")
    WebElement graceDays;

    @FindBy(xpath = "//button[text()='Import/Sales Remarks']")
    WebElement importSalesRemarksButton;

    @FindBy(xpath = "//div[text()=' Remarks ']")
    WebElement remarksPopupHeading;

    @FindBy(className = "btn-close")
    WebElement remarksPopupCloseIcon;

    @FindBy(xpath = "//button[text()='Notepad++']")
    WebElement notepadButton;

    @FindBy(xpath = "//div[text()='Agreement Notes']")
    WebElement notepadPopupHeading;

    @FindBy(xpath = "//button[text()='Email Client']")
    WebElement emailClientButton;

    @FindBy(xpath = "//th[text()='Product']")
    WebElement productSectionHeading;

    //      (//div[@id='select-PID'])[1]                    //input[@name='products[0].product_id']
    @FindBy(css = "input[placeholder='PID'][name='products[0].product_id']")
    WebElement pidDropdown;

    @FindBy(xpath = "//li[text()='80210 - 2% Disbursement Fee']")
    WebElement pidDropdownValue;

    @FindBy(xpath = "//button[text()='+ Add Row']")
    WebElement addRowButton;

    @FindBy(xpath = "//button[text()='Save Works']")
    WebElement saveWorksButton;

    @FindBy(xpath = "//button[text()='Finish INV']")
    WebElement finishINVButton;

    @FindBy(xpath = "//button[text()='Total Entries by Ledger']")
    WebElement totalEntriesByLedgerTabPE;

    //PURCHASE ENTRY
    @FindBy(xpath = "//input[@name='supplier")
    WebElement shipperDropdown;

    @FindBy(xpath = "//li[text()='BTT Multimodal Container Solutions B.V.']")
    WebElement shipperDropdownValue;

    @FindBy(xpath = "//input[@name='InvoiceNumber']")
    WebElement invoiceNumberPE;

    @FindBy(xpath = "//input[@name='invoiceDate']")
    WebElement invoiceDatePE;

    @FindBy(xpath = "//input[@name='totalAmount']")
    WebElement totalAmount;

    @FindBy(id = "invoice_pdf")
    WebElement attachPdfPE;

    //@FindBy(id = "select-PID")
    @FindBy(xpath = "(//div[@id='select-Select'])[1]")
    WebElement glAccountDropdownPE;

    //(//li[contains(text(),'23025 - Duty')])[1]
    @FindBy(xpath = "//li[text()='23025 - Duty  payable (Credit)")
    WebElement glAccountDropdownValuePE;

    @FindBy(xpath = "(//input[@placeholder='Manual'])[1]")
    WebElement amountEur;

    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[text()='Push & New']")
    WebElement pushNewINVButton;

    @FindBy(xpath = "//button[text()='Push & Back']")
    WebElement pushBackINVButton;

    @FindBy(xpath = "//button[text()='Charges']")
    WebElement chargesTab;

    @FindBy(xpath = "//button[text()='Push All Invoices Exact']")
    WebElement pushAllInvoicesExactButton;

    @FindBy(xpath = "//button[text()='Push All Invoices Amazon']")
    WebElement pushAllInvoicesAmazonButton;

    //EXTRA INVOICE

    @FindBy(id = "select-Client")
    WebElement clientDropdownEI;

    @FindBy(xpath = "//li[text()='A.I. Trading GmbH']")
    WebElement clientDropdownValueEI;

    @FindBy(xpath = "//input[@name='invoice_date']")
    WebElement invoiceDateEI;

    @FindBy(xpath = "//input[@id='inv']")
    WebElement invoiceNumberEI;

    @FindBy(xpath = "//input[@name='remarks[0]']")
    WebElement remarksFieldEI;

    @FindBy(xpath = "//button[text()='Add More']")
    WebElement addMoreButtonEI;

    @FindBy(xpath = "//div[contains(@class,'input-grouped')]//*[name()='svg']")
    WebElement remarksCrossIconEI;

    @FindBy(id = "select-Ledger Type")
    WebElement ledgerTypeDropdown;

    // International, and European
    @FindBy(xpath = "//li[text()='International']")
    WebElement ledgerTypeDropdownValue;

    // PROFORMA INVOICE, and SALE INVOICE
    @FindBy(xpath = "//li[text()='PROFORMA INVOICE']")
    WebElement invoiceTypeDropdownValueEI;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelButtonEI;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButtonEI;

    @FindBy(xpath = "//div[contains(text(),'Invoice Created Successfully')]")
    WebElement successAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    @FindBy(xpath = "(//img[contains(@alt,'Edit')])[1]")
    WebElement invoiceEditIcon;

    @FindBy(xpath = "(//span[@title='download-invoice'])[1]")
    WebElement downloadInvoiceIcon;

    @FindBy(xpath = "(//span[@title='push-invoice'])[1]")
    WebElement pushToExactIcon;

    @FindBy(xpath = "(//span[@title='Push to Amazon'])[1]")
    WebElement pushToAmazonIcon;

    @FindBy(xpath = "//h4[text()='Recently Billed Invoices']")
    WebElement billedInvoiceTabRecentlyBilledInvoicesHeading;

    @FindBy(xpath = "(//select[@class='w-25 me-1 form-select'])[1]")
    WebElement allInvoiceTypesDropdown;

    // All, Exact, and Amazon
    @FindBy(xpath = "//option[@value='exact']")
    WebElement allInvoiceTypesDropdownValue;

    @FindBy(xpath = "(//select[@class='w-25 me-1 form-select'])[2]")
    WebElement allInvoicePushedDropdown;

    // All, Exact, and Amazon
    @FindBy(xpath = "//option[@value='unpushed']")
    WebElement allInvoicePushedDropdownValue;

    @FindBy(xpath = "//input[@placeholder='Enter search']")
    WebElement invoiceSearch;

    @FindBy(xpath = "//button[@id='button-addon2']//img")
    WebElement invoiceSearchIcon;


    //	 ------------------------------------------------------------------------------------------------------------------------------------------------

    public void clickOnIntlInvTab() {
        wait.until(ExpectedConditions.visibilityOf(intlInvTab)).click();
    }

    public String getEuInvTabName() {
        return euInvTab.getText();
    }

    public boolean isEuInvTabDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(euInvTab)).isDisplayed();
    }

    public void clickOnEulInvTab() {
        wait.until(ExpectedConditions.visibilityOf(euInvTab)).click();
    }

    public void clickOnBilledInvoicesTab() {
        wait.until(ExpectedConditions.visibilityOf(billedInvoicesTab)).click();
    }

    public String getExtraInvTabName() {
        return extraInvTab.getText();
    }

    public boolean isExtraInvTabDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(extraInvTab)).isDisplayed();
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

    public void clickOnBilledChargesTab() {
        wait.until(ExpectedConditions.visibilityOf(billedChargesTab)).click();
    }

    public boolean isClientDropdownDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(clientDropdown)).isDisplayed();
    }

    public void hoverOnClientDropdown() {
        actions.moveToElement(clientDropdown).perform();
    }

 /*   // Utility method to wait until element is clickable
    private WebElement waitUntilElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Utility method to wait until element is visible
    private void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Method to get the view freight icon
    public WebElement getClientDropdownCrossIcon() {
        waitUntilVisible(clientDropdownCrossIcon);
        return clientDropdownCrossIcon;
    }

    public void clickOnClientDropdownCrossIcon() {
        waitUntilElementClickable(clientDropdownCrossIcon).click();
    }*/

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        wait.until(ExpectedConditions.elementToBeClickable(dropdownValue)).click();
    }

    public void selectClient() throws InterruptedException {
        //selectDropdownValue(clientDropdown, clientDropdownValue);
        clientDropdown.click(); // Click to activate input
        Thread.sleep(2000);
        clientDropdownInput.sendKeys("Amazon EU SARL, Dutch Branch"); // Type to trigger search
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(clientDropdownValue)).click();
    }

    public void selectInvoiceType() {
        selectDropdownValue(invoiceTypeDropdown, invoiceTypeDropdownValue);
    }

    public void enterRemarks(String text) {
        remarksField.sendKeys(text);
    }

    private void selectDate(WebElement element, String month,String day, String year) {
        actions.click(element).sendKeys(day).sendKeys(month).sendKeys(Keys.TAB).sendKeys(year).perform();
    }

    public void selectIntlEuInvDate(String day, String month, String year) {
        selectDate(invDate, day, month, year);
    }

    // Method to enter invoice number into the invoiceNumber field
    public void enterInvoiceNumber(String invoice) {
        invoiceNumber.sendKeys(invoice);
    }

    public void enterGraceDays(String text) {
        actions.click(graceDays).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .perform();
        graceDays.sendKeys(text);
    }

    public String getProductSectionColHeading() {
        return productSectionHeading.getText();
    }

    public boolean isProductSectionColHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(productSectionHeading)).isDisplayed();
    }

    public void scrollToBottom() {
        wait.until(ExpectedConditions.visibilityOf(pidDropdown)); // Ensure visibility
        executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", pidDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(pidDropdown));
    }

    public void scrollToElement() {
        executor.executeScript("arguments[0].scrollIntoView(true);", pidDropdown);
    }

    public void selectPidDropdown() {
        selectDropdownValue(pidDropdown, pidDropdownValue);
    }

    public void clickSaveWorksButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveWorksButton)).click();
    }

    public void scrollToFinishButton() {
        executor.executeScript("arguments[0].scrollIntoView(true);", finishINVButton);
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

    //EXTRA INV

    public void selectExtraInvClient() {
        selectDropdownValue(clientDropdownEI, clientDropdownValueEI);
    }

    public void selectExtraInvDate(String month,String day, String year) {
        selectDate(invoiceDateEI, month, day, year);
    }

    // Method to enter invoice number into the invoiceNumber field
    public void enterExtraInvoiceNumber(String invoice) {
        invoiceNumberEI.sendKeys(invoice);
    }

    public void enterExtraInvRemarks(String text) {
        remarksFieldEI.sendKeys(text);
    }

    public void selectLedgerTypeDropdown() {
        selectDropdownValue(ledgerTypeDropdown, ledgerTypeDropdownValue);
    }

    public void selectExtraInvType() {
        selectDropdownValue(invoiceTypeDropdown, invoiceTypeDropdownValueEI);
    }

    public void scrollToSubmitButton() {
        executor.executeScript("arguments[0].scrollIntoView(true);", submitButtonEI);
    }

    public void clickSubmitINVButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonEI)).click();
    }

    //PURCHASE ENTRY METHODS

    public void clickOnPurchaseEntryTab() {
        wait.until(ExpectedConditions.visibilityOf(purchaseEntryTab)).click();
    }

    public String getPurchaseEntryTabName() {
        return purchaseEntryTab.getText();
    }

    public boolean isPurchaseEntryTabDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(purchaseEntryTab)).isDisplayed();
    }

    public void selectPurchaseEntryShipper() {
        selectDropdownValue(shipperDropdown, shipperDropdownValue);
    }

    public void selectPurchaseEntryDate(String month,String day, String year) {
        selectDate(invoiceDatePE, month, day, year);
    }

    // Method to enter invoice number into the invoiceNumber field
    public void enterPurchaseEntryNumber(String invoice) {
        invoiceNumberPE.sendKeys(invoice);
    }

    public void enterPurchaseEntryTotalAmount(String text) {
        totalAmount.sendKeys(text);
    }

    public void selectGLAccountDropdown() {
        selectDropdownValue(glAccountDropdownPE, glAccountDropdownValuePE);
    }

    public void enterGlAccountAmount(String text) {
        amountEur.sendKeys(text);
    }

    public void scrollToPushPurchaseEntryButton() {
        executor.executeScript("arguments[0].scrollIntoView(true);", pushNewINVButton);
    }

    public void clickPushPurchaseEntryButton() {
        wait.until(ExpectedConditions.elementToBeClickable(pushNewINVButton)).click();
    }
}
