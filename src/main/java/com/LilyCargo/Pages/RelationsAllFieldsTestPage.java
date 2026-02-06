package com.LilyCargo.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RelationsAllFieldsTestPage {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    JavascriptExecutor executor;
    Logger log = LogManager.getLogger(RelationsAllFieldsTestPage.class);

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

    public RelationsAllFieldsTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        this.executor = (JavascriptExecutor) this.driver;
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//label[text()='Ticker']/following::input[1]")
    WebElement tickerField;

    @FindBy(xpath = "//label[contains(text(), 'Name')]/following::input[1]")
    WebElement nameField;

    @FindBy(xpath = "//label[starts-with(text(), 'Company')]/following::input[1]")
    WebElement companyNameField;

    @FindBy(xpath = "//label[starts-with(text(), 'Short')]/following::input[1]")
    WebElement shortNameField;

    @FindBy(xpath = "//label[text()='Entity Name']/following::input[1]")
    WebElement entityNameField;

    @FindBy(xpath = "//label[text()='Contact Person']/following::input[1]")
    WebElement contactPersonField;

    @FindBy(xpath = "//label[starts-with(text(), 'Telephone')]/following::input[1]")
    WebElement telephoneNumber1Field;

    @FindBy(xpath = "//label[text()='Telephone Number 2']/following::input[1]")
    WebElement telephoneNumber2Field;

    @FindBy(xpath = "//label[text()='Telephone Number 3']/following::input[1]")
    WebElement telephoneNumber3Field;

    @FindBy(xpath = "//label[starts-with(text(), 'Email')]/following::input[1]")
    WebElement emailField;

    @FindBy(xpath = "//label[text()='Email 2']/following::input[1]")
    WebElement email2Field;

    @FindBy(xpath = "//label[text()='Email 3']/following::input[1]")
    WebElement email3Field;

    @FindBy(xpath = "//label[text()='Finance Email']/following::input[1]")
    WebElement financeEmailField;

    @FindBy(xpath = "//label[text()='Fiscal Matters Email']/following::input[1]")
    WebElement fiscalMattersField;

    @FindBy(xpath = "//label[text()='Ceo Email']/following::input[1]")
    WebElement ceoEmailField;

    @FindBy(xpath = "//label[starts-with(text(), 'Address')]/following::input[1]")
    WebElement address1Field;

    @FindBy(xpath = "//label[text()='Address 2']/following::input[1]")
    WebElement address2Field;

    @FindBy(xpath = "//label[text()='Agreement Notes']/following::input[1]")
    WebElement agreementNotesField;

    @FindBy(xpath = "//label[starts-with(text(), 'Note')]/following::input[1]")
    WebElement noteField;

    @FindBy(xpath = "//label[text()='Note 2']/following::input[1]")
    WebElement note2Field;

    @FindBy(xpath = "//label[text()='Zip City']/following::input[1]")
    WebElement zipCityField;

    @FindBy(xpath = "//label[starts-with(text(), 'Eori')]/following::input[1]")
    WebElement eoriNumberField;

    @FindBy(xpath = "//label[starts-with(text(), 'Vat')]/following::input[1]")
    WebElement vatNumberField;

    @FindBy(xpath = "//label[text()='WeChat 1']/following::input[1]")
    WebElement weChatField;

    @FindBy(xpath = "//label[text()='WeChat 2']/following::input[1]")
    WebElement weChat2Field;

    @FindBy(xpath = "//label[contains(text(), 'Code')]/following::input[1]")
    WebElement codeField;

    @FindBy(xpath = "//label[contains(text(), 'Country')]/following::input[1]")
    WebElement countryNameDropdown;

    @FindBy(xpath = "//label[contains(text(), 'Abbreviation')]/following::input[1]")
    WebElement abbreviationField;

    @FindBy(xpath = "//label[text()='Organization']/following::input[1]")
    WebElement organizationField;

    @FindBy(xpath = "//label[text()='Branch']/following::input[1]")
    WebElement branchField;

    @FindBy(xpath = "//label[text()='Cell']/following::input[1]")
    WebElement cellField;

    @FindBy(xpath = "//label[text()='Position']/following::input[1]")
    WebElement positionField;

    @FindBy(xpath = "//input[@name='payroll_ends']")
    WebElement payrollEndsDate;

    @FindBy(xpath = "//input[@name='office_access_start']")
    WebElement officeAccessStartDate;

    @FindBy(xpath = "//input[@name='office_access_end']")
    WebElement officeAccessEndDate;

    @FindBy(xpath = "//input[@name='date']")
    WebElement dateField;

    @FindBy(xpath = "//input[@name='timeEntrance']")
    WebElement timeEntranceField;

    @FindBy(xpath = "//label[text()='Location']/following::div[@role='button']")
    WebElement locationDropdown;

    @FindBy(xpath = "//label[text()='Appointment With']/following::input[1]")
    WebElement appointmentWithField;

    @FindBy(xpath = "//label[text()='SCM Emails']/following::input[1]")
    WebElement scmEmails;

    @FindBy(xpath = "//label[text()='Customs Release Emails']/following::input[1]")
    WebElement customsReleaseEmails;

    @FindBy(xpath = "//label[text()='Billing Emails']/following::input[1]")
    WebElement billingEmails;

    @FindBy(xpath = "//input[@name='intraVatFilingEmails']")
    WebElement intraVatFilingEmails;

    @FindBy(xpath = "//label[text()='Store Front']/following::input[1]")
    WebElement storeFrontField;

    @FindBy(xpath = "//button[text()='Duplicate']")
    WebElement duplicateButton;

    @FindBy(xpath = "//label[text()='Export Company']/following::div[@role='button']")
    WebElement exportCompanyDropDown;

    @FindBy(xpath = "//label[text()='Country']/following::div[@role='button']")
    WebElement countryDropDown;

    @FindBy(xpath = "//label[text()='Region']/following::div[@role='button']")
    WebElement regionDropDown;

    @FindBy(xpath = "//label[text()='LFR']/following::div[@role='button']")
    WebElement lfrDropDown;

    @FindBy(id = "select-Status")
    WebElement userStatusDropDown;

    @FindBy(xpath = "//input[@name='emails[0].label']")
    WebElement extraEmailLabel;

    @FindBy(xpath = "//input[@name='emails[0].value']")
    WebElement extraEmailValue;

    @FindBy(xpath = "//label[contains(text(), 'Location')]//following::input[1]")
    WebElement lmTeamLocation;

    @FindBy(xpath = "//label[contains(text(), 'Manager')]//following::input[1]")
    WebElement managerDropdown;

    /** ---------- Methods ---------- */

    public void enterTicker(String text) {
        tickerField.sendKeys(text);
    }

    public void enterName(String text) {
        nameField.sendKeys(text);
    }

    public void updateName(String text) {
        actions.click(nameField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        nameField.sendKeys(text);
    }

    public void enterShortName(String text) {
        shortNameField.sendKeys(text);
    }

    public void enterCompanyName(String text) {
        companyNameField.sendKeys(text);
    }

    public void enterEntityName(String text) {
        entityNameField.sendKeys(text);
    }

    public void enterContactPerson(String text) {
        contactPersonField.sendKeys(text);
    }

    public void enterTelephoneNumber(String phoneNumber) {
        telephoneNumber1Field.sendKeys(phoneNumber);
    }

    public void enterTelephoneNumber2(String phoneNumber) {
        telephoneNumber2Field.sendKeys(phoneNumber);
    }

    public void enterEmail(String text) {
        emailField.sendKeys(text);
    }

    public void enterEmail2(String text) {
        email2Field.sendKeys(text);
    }

    public void enterFinanceEmail(String text) {
        financeEmailField.sendKeys(text);
    }

    public void enterFiscalMattersEmail(String text) {
        fiscalMattersField.sendKeys(text);
    }

    public void enterCeoEmail(String text) {
        ceoEmailField.sendKeys(text);
    }

    public void enterAddress1(String text) {
        address1Field.sendKeys(text);
    }

    public void enterAddress2(String text) {
        actions.click(address2Field).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        address2Field.sendKeys(text);
    }

    public void enterZipCity(String text) {
        zipCityField.sendKeys(text);
    }

    public void enterEoriNumber(String text) {
        eoriNumberField.sendKeys(text);
    }

    public void enterVatNumber(String text) {
        vatNumberField.sendKeys(text);
    }

    public void updateVatNumber(String text) {
        actions.click(vatNumberField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        vatNumberField.sendKeys(text);
    }

    public void enterWeChat(String text) {
        weChatField.sendKeys(text);
    }

    public void enterWeChat2(String text) {
        weChat2Field.sendKeys(text);
    }

    public void enterAgreementNotes(String text) {
        agreementNotesField.sendKeys(text);
    }

    public void enterNote(String text) {
        noteField.sendKeys(text);
    }

    public void enterNote2(String text) {
        note2Field.sendKeys(text);
    }

    public void enterCode(String text) {
        codeField.sendKeys(text);
    }

    public void enterAbbreviation(String text) {
        abbreviationField.sendKeys(text);
    }

    public void enterOrganization(String text) {
        organizationField.sendKeys(text);
    }

    public void enterBranch(String text) { branchField.sendKeys(text); }

    public void enterCell(String text) { cellField.sendKeys(text); }

    public void enterPosition(String text) { positionField.sendKeys(text); }

    // For <input type="date">
    private void selectDate(WebElement element, LocalDate date) {
        String dateValue = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")); // required format
        element.clear();
        element.sendKeys(dateValue);
    }

    public void selectVisitorsDate() {
        selectDate(dateField, LocalDate.now().plusDays(3));
    }

    public void selectOfficeAccessStartDate() {
        selectDate(officeAccessStartDate, LocalDate.now());
    }

    public void selectOfficeAccessEndDate() {
        selectDate(officeAccessEndDate, LocalDate.now().plusYears(1));;
    }

    public void enterAppointmentWith(String text) {
        appointmentWithField.sendKeys(text);
    }

    public void enterStoreFront(String text) {
        storeFrontField.sendKeys(text);
    }

    public void enterMultipleEmails(WebElement emailField, String... emails) {
        String joinedEmails = String.join(";", emails);
        emailField.clear();
        emailField.sendKeys(joinedEmails);
    }

    // Convenience methods for each field
    public void enterScmEmails(String... emails) {
        enterMultipleEmails(scmEmails, emails);
    }

    public void enterCustomsReleaseEmails(String... emails) {
        enterMultipleEmails(customsReleaseEmails, emails);
    }

    public void enterBillingEmails(String... emails) {
        enterMultipleEmails(billingEmails, emails);
    }

    public void enterIntraVatFilingEmails(String... emails) {
        enterMultipleEmails(intraVatFilingEmails, emails);
    }

    public void clickDuplicateBtn() { duplicateButton.click(); }

    public void addClientData(String Name, String ContactPerson, String Address1, String Email1, String FinancialEmail,
                              String FiscalMattersEmail1, String CeoEmail1, String TelephoneNumber1, String RegionDropDown,
                              String CountryDropDown, String ZipCity, String Vat, String LfrDropDown, String ScmEmails, String CustomsReleaseEmails, String BillingEmails) {
        nameField.sendKeys(Name);
        contactPersonField.sendKeys(ContactPerson);
        address1Field.sendKeys(Address1);
        emailField.sendKeys(Email1);
        financeEmailField.sendKeys(FinancialEmail);
        fiscalMattersField.sendKeys(FiscalMattersEmail1);
        ceoEmailField.sendKeys(CeoEmail1);
        telephoneNumber1Field.sendKeys(TelephoneNumber1);
        selectDropdownByText(regionDropDown, RegionDropDown);
        selectDropdownByText(countryDropDown, CountryDropDown);
        zipCityField.sendKeys(ZipCity);
        vatNumberField.sendKeys(Vat);
        selectDropdownByText(lfrDropDown, LfrDropDown);
        scmEmails.sendKeys(ScmEmails);
        customsReleaseEmails.sendKeys(CustomsReleaseEmails);
        billingEmails.sendKeys(BillingEmails);
    }

    // Method to select a dropdown value by visible text
    public void selectDropdownByText(WebElement dropdownElement, String optionText) {
        dropdownElement.click(); // open the dropdown
        log.info("🔽 Opened dropdown");
        WebElement dropdownOption = wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath("//li[contains(text(),'" + optionText + "')]"))));
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownOption);
        dropdownOption.click();
        log.info("✅ Selected option: " + optionText);
    }

    public void selectLocation(String location) {
        selectDropdownByText(locationDropdown, location);
    }

    public void selectLmTeamLocation(String lmLocation) {
        selectDropdownByText(lmTeamLocation, lmLocation);
    }

    public void selectManager(String manager) {
        selectDropdownByText(managerDropdown, manager);
    }

    public void searchAndSelectCountry(String countryName) {
        selectDropdownByText(countryNameDropdown, countryName);
    }

    public void enterExtraEmailLabel(String text) {
        extraEmailLabel.sendKeys(text);
    }

    public void enterExtraEmailValue(String text) {
        extraEmailValue.sendKeys(text);
    }

}
