package com.LilyCargo.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RelationsAllFieldsTestPage {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */
    public RelationsAllFieldsTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

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

    @FindBy(xpath = "//input[@name='office_access_start']")
    WebElement officeAccessStartDate;

    @FindBy(xpath = "//input[@name='office_access_end']")
    WebElement officeAccessEndDate;

    @FindBy(xpath = "//label[text()='Appointment With']/following::input[1]")
    WebElement appointmentWithField;

    @FindBy(xpath = "//label[text()='SCM Emails']/following::input[1]")
    WebElement scmEmails;

    @FindBy(xpath = "//label[text()='Customs Release Emails']/following::input[1]")
    WebElement customsReleaseEmails;

    @FindBy(xpath = "//label[text()='Billing Emails']/following::input[1]")
    WebElement billingEmails;

    @FindBy(xpath = "//label[text()='Store Front']/following::input[1]")
    WebElement storeFrontField;

    /** ---------- Methods ---------- */

    public void enterName(String text) {
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

    public void enterEmail(String text) {
        emailField.sendKeys(text);
    }

    public void enterEmail2(String text) {
        email2Field.sendKeys(text);
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

    public void enterBranch(String text) {
        branchField.sendKeys(text);
    }

    public void enterCell(String text) {
        cellField.sendKeys(text);
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

}
