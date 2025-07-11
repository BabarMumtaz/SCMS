package com.LilyCargo.Pages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Supplier;

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

    //--------------------------------------------------------------------------------------------------------------------------------

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
    WebElement invoiceAmzBrokerageTypeDropdownValue;

    @FindBy(xpath = "//li[text()='AMAZON DUTY INV']")
    WebElement invoiceAmzDutyTypeDropdownValue;

    @FindBy(xpath = "//input[@name='remarks']")
    WebElement remarksField;

    @FindBy(xpath = "//button[@title='Clear']//*[name()='svg']")
    WebElement clientDropdownCrossIcon;

    //(//div[@id='select-PID'])[1]
    @FindBy(xpath = "//div[@class=' css-ackcql']")
    WebElement clientDropdown;

    @FindBy(xpath = "//div[@class=' css-ackcql']//input")
    WebElement clientDropdownInput;

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

    @FindBy(css = ".billing-table-wrapper.table") // Update selector as needed
    WebElement productListContainer;

    //      input[placeholder='PID'][name='products[0].product_id']                   //input[@name='products[0].product_id']
    @FindBy(xpath = "(//div[@id='select-PID'])[1]")
    WebElement pidDropdown;

    @FindBy(xpath = "(//div[@id='select-PID'])[2]")
    WebElement pidDropdown2;

    @FindBy(xpath = "(//div[@id='select-PID'])[3]")
    WebElement pidDropdown3;

    @FindBy(xpath = "(//div[@id='select-PID'])[4]")
    WebElement pidDropdown4;

    @FindBy(xpath = "(//div[@id='select-PID'])[5]")
    WebElement pidDropdown5;

    @FindBy(xpath = "(//div[@id='select-PID'])[6]")
    WebElement pidDropdown6;

    // Store all PID dropdowns in a list
    @FindBy(xpath = "//div[@id='select-PID']")
    List<WebElement> pidDropdownsList;

    @FindBy(xpath = "//ul[@role='listbox']")
    WebElement pidDropdownsListBox;

    @FindBy(xpath = "//li[@role='option']")
    WebElement pidDropdownsListBoxOption;

    @FindBy(xpath = "//li[text()='80210 - 2% Disbursement Fee']")
    WebElement pidINTLDropdownValue;

    @FindBy(xpath = "//li[text()='80110 - B2C Customs Entry']")
    WebElement pidEUDropdownValue;

    @FindBy(xpath = "//input[@name='products[2].description']")
    WebElement pidDropdownDescription;

    @FindBy(xpath = "(//div[@id='select-VAT Code'])")
    List<WebElement> vatDropdownList;

    //label[contains(text(),'VAT Code')]
    @FindBy(xpath = "//label[contains(text(),'VAT Code')]")
    List<WebElement> vatDropdownText;

    @FindBy(xpath = "(//div[@id='select-VAT Code'])[1]")
    WebElement vatDropdown;

    @FindBy(xpath = "//li[text()='2']")
    WebElement vatDropdownValue;

    @FindBy(xpath = "//input[@placeholder='Sale']")
    WebElement salePriceList;

    @FindBy(xpath = "//button[text()='+ Add Row']")
    WebElement addRowButton;

    @FindBy(xpath = "//button[text()='Save Works']")
    WebElement saveWorksButton;

    @FindBy(xpath = "//button[text()='Finish INV']")
    WebElement finishINVButton;

    @FindBy(xpath = "//button[text()='Total Entries by Ledger']")
    WebElement totalEntriesByLedgerTabPE;

    //---------------------PURCHASE ENTRY---------------------

    @FindBy(xpath = "//th[text()='G/L Accounts']")
    WebElement glAccountsSectionHeading;

    @FindBy(xpath = "(//div[@id='select-Supplier'])")
    WebElement shipperDropdown;

    @FindBy(xpath = "//li[text()='BTT Multimodal Container Solutions B.V.']")
    WebElement shipperDropdownValue;

    @FindBy(xpath = "//input[@name='invoiceNumber']")
    WebElement invoiceNumberPE;

    @FindBy(xpath = "//input[@name='invoiceDate']")
    WebElement invoiceDatePE;

    @FindBy(xpath = "//input[@name='totalAmount']")
    WebElement totalAmount;

    @FindBy(xpath = "(//input[@id='invoice_pdf'])")
    WebElement attachPdfPE;

    @FindBy(xpath = "(//div[@id='select-Select'])")
    List<WebElement> glAccountDropdownListPE;

    @FindBy(xpath = "//ul[@role='listbox']")
    WebElement glAccountDropdownListPEListBox;

    @FindBy(xpath = "//li[@role='option']")
    WebElement glAccountDropdownListPEListBoxOption;

    //(//li[contains(text(),'23025 - Duty')])[1]
    @FindBy(xpath = "//li[text()='23025 - Duty  payable (Credit)")
    WebElement glAccountDropdownValuePE;

    @FindBy(xpath = "(//input[@placeholder='Manual'])")
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


    //---------------------EXTRA INVOICE---------------------

    @FindBy(id = "select-Client")
    WebElement clientDropdownEI;

    @FindBy(xpath = "//li[text()='A.I. Trading GmbH']")
    WebElement clientDropdownValueEI;

    @FindBy(xpath = "//input[@name='invoice_date']")
    WebElement invoiceDateEI;

    @FindBy(xpath = "//input[@name='inv']")
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

    @FindBy(xpath = "//div[contains(text(),'Extra Invoice Created Successfully')]")
    WebElement extraInvoiceSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    @FindBy(xpath = "//div[contains(text(),'Unable to connect to Exact')]")
    WebElement errorAlertMessage;

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

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
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

    public void selectAmazonBrokerageInvoiceType() {
        selectDropdownValue(invoiceTypeDropdown, invoiceAmzBrokerageTypeDropdownValue);
    }

    public void selectAmazonDutyInvoiceType() {
        selectDropdownValue(invoiceTypeDropdown, invoiceAmzDutyTypeDropdownValue);
    }

    public void enterRemarks(String text) {
        remarksField.sendKeys(text);
    }

    private void selectDate(WebElement element, String day, String month, String year) {
        actions.click(element).sendKeys(day).sendKeys(month).sendKeys(Keys.TAB).sendKeys(year).perform();
    }

    public void enterIntlEuInvDate(String day, String month, String year) {
        selectDate(invDate, day, month, year);
    }

    public void enterPurchaseEntryDate(String day, String month, String year) {
        selectDate(invoiceDatePE, day, month, year);
    }

    public void enterExtraInvoiceDate(String day, String month, String year) {
        //wait.until(ExpectedConditions.visibilityOf(invoiceDateEI));
        wait.until(ExpectedConditions.elementToBeClickable(invoiceDateEI));
        selectDate(invoiceDateEI, day, month, year);
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
        executor.executeScript("arguments[0].scrollIntoView(true);", pidDropdown5);
    }

    public void scrollToElementInContainer() {
        executor.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", productListContainer, pidDropdown5);
    }

    public void selectDropdownByIndex( int index, WebElement valueElement, String productName, WebElement scrollContainer) throws InterruptedException {
        WebElement dropdown = pidDropdownsList.get(index - 1); // 1-based to 0-based

        // Scroll into view inside container
        executor.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", scrollContainer, dropdown);
        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
        Thread.sleep(1000);
        executor.executeScript("arguments[0].scrollIntoView(true);", valueElement);
        wait.until(ExpectedConditions.elementToBeClickable(valueElement)).click();

        log.info("Selected Product " + productName + " in dropdown #" + index);
    }

    public void selectINTLPidByIndex(int index) throws InterruptedException {
        selectDropdownByIndex( index, pidINTLDropdownValue, "INTL Product", productListContainer);
    }

    public void selectEUPidByIndex(int index) throws InterruptedException {
        selectDropdownByIndex( index, pidEUDropdownValue, "EU Product", productListContainer);
    }

    public void selectVat() {
        selectDropdownValue(vatDropdown, vatDropdownValue);
    }

    //-------------------------------------------------------------- selectDropdownByIndexValue Methods

    public void selectDropdownByIndexValue(int index, String valueText, WebElement scrollContainer) throws InterruptedException {
        WebElement dropdown = pidDropdownsList.get(index - 1); // 1-based to 0-based

        // Scroll to dropdown
        executor.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", productListContainer, dropdown);
        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();

        wait.until(ExpectedConditions.visibilityOf(pidDropdownsListBox));

        //wait.until(ExpectedConditions.visibilityOf(pidDropdownsListBoxOption));

        wait.until(ExpectedConditions.visibilityOfAllElements(pidDropdownsListBoxOption));

        Thread.sleep(500);

        // Find and click value
        WebElement value = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='" + valueText + "']")));

        executor.executeScript("arguments[0].scrollIntoView(true);", value);
        wait.until(ExpectedConditions.elementToBeClickable(value)).click();

        log.info("Selected value '" + valueText + "' at dropdown #" + index);
    }

    public void selectDropdownByIndexValueForPE(int index, String valueText, WebElement scrollContainer) {
        WebElement dropdown = glAccountDropdownListPE.get(index - 1); // 1-based to 0-based

        // Scroll to dropdown
        executor.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", productListContainer, dropdown);
        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();

        wait.until(ExpectedConditions.visibilityOf(pidDropdownsListBox));

        //wait.until(ExpectedConditions.visibilityOf(pidDropdownsListBoxOption));

        wait.until(ExpectedConditions.visibilityOfAllElements(pidDropdownsListBoxOption));

        // Find and click value
        //WebElement value = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='" + valueText + "']")));

        WebElement value = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'" + valueText + "')]")));

        executor.executeScript("arguments[0].scrollIntoView(true);", value);
        wait.until(ExpectedConditions.elementToBeClickable(value)).click();

        log.info("Selected GL Account value '" + valueText + "' at dropdown #" + index);
    }

    public void selectDropdownByIndexValueGeneric(
            int index,
            List<WebElement> dropdownList,
            String valueText,
            WebElement scrollContainer,
            String contextLabel
    ) {
        WebElement dropdown = dropdownList.get(index - 1); // Convert 1-based to 0-based index

        // Scroll to dropdown
        executor.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", scrollContainer, dropdown);
        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();

        wait.until(ExpectedConditions.visibilityOf(pidDropdownsListBox));
        wait.until(ExpectedConditions.visibilityOfAllElements(pidDropdownsListBoxOption));

        // Handle contains vs exact match based on context (optional)
        By valueLocator = By.xpath("//li[contains(text(),'" + valueText + "')]");

        WebElement value = wait.until(ExpectedConditions.presenceOfElementLocated(valueLocator));
        executor.executeScript("arguments[0].scrollIntoView(true);", value);
        wait.until(ExpectedConditions.elementToBeClickable(value)).click();

        log.info("Selected " + contextLabel + " value '" + valueText + "' at dropdown #" + index);
    }

    public void selectPEglAccountByIndexValue(int index, String valueText, WebElement scrollContainer) {
        selectDropdownByIndexValueGeneric(index, glAccountDropdownListPE, valueText, scrollContainer, "GL Account");
    }

    public void selectEUPidByIndex(int index, String valueText, WebElement scrollContainer) throws InterruptedException {
        selectDropdownByIndexValueGeneric(index, pidDropdownsList, valueText, scrollContainer, "EU Product");
    }

    public void selectINTLPidByIndex(int index, String valueText, WebElement scrollContainer) throws InterruptedException {
        selectDropdownByIndexValueGeneric(index, pidDropdownsList, valueText, scrollContainer, "INTL Product");
    }

    //-------------------------------------------------------------- selectVatDropdownByIndexValue

    public void selectVatDropdownByIndexValue(int index, String valueText, WebElement scrollContainer) {
        WebElement vatDropdown = vatDropdownList.get(index - 1); // 1-based to 0-based

        // Scroll into view and click the VAT dropdown
        executor.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", productListContainer, vatDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(vatDropdown)).click();

        // Force click via JS to avoid label overlap
       // executor.executeScript("arguments[0].click();", vatDropdown);

        // Now locate the VAT value dynamically
        WebElement value = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='" + valueText + "']")));

        wait.until(ExpectedConditions.visibilityOfAllElements(vatDropdownList));

        executor.executeScript("arguments[0].scrollIntoView(true);", value);
        wait.until(ExpectedConditions.elementToBeClickable(value)).click();

        log.info("Selected VAT value '" + valueText + "' at dropdown #" + index);
    }

    //-------------------------------------------------------------- enterSaleAmountByRowIndex---------------------

    public void enterSaleAmountByRowIndex(int rowIndex, String amountValue, WebElement scrollContainer) throws InterruptedException {
        WebElement saleInput = scrollContainer.findElement(
                By.xpath(".//input[@name='products[" + (rowIndex - 1) + "].sale']")
        );
        wait.until(ExpectedConditions.visibilityOf(saleInput));
        Thread.sleep(500);
        // Clear and enter value
        actions.click(saleInput).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        saleInput.sendKeys(amountValue);

        log.info("Entered Sale Amount '" + amountValue + "' at #" + rowIndex);
    }

    //--------------------------------------------------------------

    public void enterAmountEURByRowIndex(int rowIndex, String amountValue, WebElement scrollContainer) throws InterruptedException {

        WebElement amountEurInput = scrollContainer.findElement(
                By.xpath(".//input[@name='ledgers[" + (rowIndex - 1) + "].amountEur']")
        );
        wait.until(ExpectedConditions.visibilityOf(amountEurInput));
        Thread.sleep(1000);

        amountEurInput.sendKeys(amountValue);

        log.info("Entered Amount EUR '" + amountValue + "' at #" + rowIndex);
    }

    public void enterAmountEInvoiceByRowIndex(int rowIndex, String amountValue, WebElement scrollContainer) throws InterruptedException {

        WebElement amountEurInput = scrollContainer.findElement(
                By.xpath(".//input[@name='products[" + (rowIndex - 1) + "].amount']")
        );
        wait.until(ExpectedConditions.visibilityOf(amountEurInput));
        Thread.sleep(1000);

        amountEurInput.sendKeys(amountValue);

        log.info("Entered Amount '" + amountValue + "' at #" + rowIndex);
    }

/*    public void selectINTLPiD() {
        selectDropdownValueByIndex(pidDropdownsList, pidINTLDropdownValue);
    }

    public void selectEUPiD() {
        selectDropdownValueByIndex(pidDropdownsList, pidEUDropdownValue);
    }*/

    public List<WebElement> getPidDropdownList() {
        return pidDropdownsList;
    }

    public WebElement getProductListContainer() {
        return productListContainer;
    }

    public int getPidDropdownsCount() {
        return pidDropdownsList.size();
    }

    public int getGlAccountDropdownsCount() {
        return glAccountDropdownListPE.size();
    }

    public List<WebElement> getGlAccountDropdownListPE() {
        return glAccountDropdownListPE;
    }

    public WebElement getAddRowButton() {
        return addRowButton;
    }

    //-------------------------------------------------------------- clickAddRowAndWaitForNew All Methods---------------------

    public void clickAddRowAndWaitForNewRow() {
        int oldCount = getPidDropdownsCount();
        wait.until(ExpectedConditions.elementToBeClickable(addRowButton)).click();
        log.info("Clicked Add Row button in INTL or EU INV.");

        wait.until(driver -> getPidDropdownsCount() > oldCount);
        log.info("Verified new row added successfully in INTL or EU INV.");

        log.info("New product row added in INTL or EU INV. Total products now: " + getPidDropdownsCount());

        // Optional: wait until the last dropdown is clickable
        WebElement newDropdown = pidDropdownsList.get(pidDropdownsList.size() - 1);
        wait.until(ExpectedConditions.elementToBeClickable(newDropdown));
    }

    public void clickAddRowAndWaitForNewRowPE() {
        int oldCount = getGlAccountDropdownsCount();
        wait.until(ExpectedConditions.elementToBeClickable(addRowButton)).click();
        log.info("Clicked Add Row button in Purchase Entry.");

        wait.until(driver -> getGlAccountDropdownsCount() > oldCount);
        log.info("Verified new row added successfully.");

        log.info("New product row added. Total products now: " + getGlAccountDropdownsCount());

        // Optional: wait until the last dropdown is clickable
        WebElement newDropdown = glAccountDropdownListPE.get(glAccountDropdownListPE.size() - 1);
        wait.until(ExpectedConditions.elementToBeClickable(newDropdown));
    }

    public void clickAddRowAndWaitForNewRowGeneric(
            Supplier<Integer> getDropdownCount,
            Supplier<List<WebElement>> getDropdownList,
            WebElement addButton,
            String contextLabel
    ) {
        int oldCount = getDropdownCount.get();
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        log.info("Clicked Add Row button in " + contextLabel + ".");

        wait.until(driver -> getDropdownCount.get() > oldCount);
        log.info("Verified new row added successfully in " + contextLabel + ".");

        log.info("New product row added in " + contextLabel + ". Total rows now: " + getDropdownCount.get());

        // Wait until the new dropdown is clickable
        WebElement newDropdown = getDropdownList.get().get(getDropdownList.get().size() - 1);
        wait.until(ExpectedConditions.elementToBeClickable(newDropdown));
    }

    //-----------------------------------------------------------------------------------

    public void clickPidDropdownDescription() {
        wait.until(ExpectedConditions.elementToBeClickable(pidDropdownDescription)).click();
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

    public boolean isSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(successAlertMessage)).isDisplayed();
    }

    public String getSuccessAlertMessage() {
        return successAlertMessage.getText();
    }

    public boolean isExtraInvSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(extraInvoiceSuccessAlertMessage)).isDisplayed();
    }

    public String getExtraInvSuccessAlertMessage() {
        return extraInvoiceSuccessAlertMessage.getText();
    }


    public void clickOnAlertPopupCrossIcon() {
        wait.until(ExpectedConditions.visibilityOf(successAlertCrossIcon)).click();
    }

    //---------------------EXTRA INV---------------------

    public void selectExtraInvClient() {
        selectDropdownValue(clientDropdownEI, clientDropdownValueEI);
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

    public boolean isPidDropdownDisabled() {
        String ariaDisabled = pidDropdown.getAttribute("aria-disabled");
        String classAttr = pidDropdown.getAttribute("class");

        return "true".equalsIgnoreCase(ariaDisabled) || classAttr.contains("Mui-disabled");
    }

    //---------------------------------------PURCHASE ENTRY METHODS---------------------

    public String getGlAccountsSectionColHeading() {
        return glAccountsSectionHeading.getText();
    }

    public boolean isGlAccountsSectionColHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(glAccountsSectionHeading)).isDisplayed();
    }

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

    // Method to enter invoice number into the invoiceNumber field
    public void enterPurchaseEntryNumber(String invoice) {
        invoiceNumberPE.sendKeys(invoice);
    }

    public void enterPurchaseEntryTotalAmount(String text) {
        totalAmount.sendKeys(text);
    }

    public void uploadInvoicePDF(String filePath) throws InterruptedException {
        //WebElement fileInput = driver.findElement(By.id("invoice_pdf"));
        attachPdfPE.sendKeys(filePath);
        log.info("Uploaded PDF file: " + filePath);
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

    public String getErrorAlertMessage() {
        return errorAlertMessage.getText();
    }

    public boolean isErrorAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(errorAlertMessage)).isDisplayed();
    }
}
