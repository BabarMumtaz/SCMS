package com.LilyCargo.Pages;

import com.github.javafaker.Faker;

import org.openqa.selenium.By;
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
import java.util.Locale;

public class ClientTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Faker faker;

    // Constructor that will be automatically called as soon as the object of the
    // class is created
    public ClientTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        faker = new Faker(new Locale.Builder().setLanguage("nl").build());
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//h2[text()='Clients']")
    WebElement clientPageHeading;

    @FindBy(xpath = "//button[text()='Add Client']")
    WebElement addClientBtn;

    @FindBy(xpath = "//input[@name='name']")
    WebElement clientName;

    @FindBy(xpath = "//input[@name='contactPerson']")
    WebElement contactPerson;

    @FindBy(xpath = "//input[@name='address1']")
    WebElement clientAddress1;

    @FindBy(xpath = "//input[@name='email1']")
    WebElement clientEmail1;

    @FindBy(xpath = "//input[@name='financeEmail']")
    WebElement clientFinancialEmail;

    @FindBy(xpath = "//input[@name='exportEmail']")
    WebElement clientFiscalMattersEmail1;

    @FindBy(xpath = "//input[@name='ceoEmail']")
    WebElement clientCeoEmail1;

    @FindBy(xpath = "//input[@name='tel']")
    WebElement clientTelephoneNumber1;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement regionDropDown;

    @FindBy(xpath = "//li[contains(.,'nl')]")
    WebElement regionDropDownValue;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[2]")
    WebElement countryDropDown;

    @FindBy(xpath = "//li[contains(.,'UNITED KINGDOM')]")
    WebElement countryDropDownValue;

    @FindBy(xpath = "//input[@name='zipCity']")
    WebElement clientZipCity;

    @FindBy(xpath = "//input[@name='vat']")
    WebElement clientVat;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[3]")
    WebElement clientLfrDropDown;

    @FindBy(xpath = "//li[contains(.,'NL LMBV B02 (IMPORT)')]")
    WebElement clientLfrDropDownValue;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraEmailFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraAddressFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraPhoneFieldCross;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveClientBack;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveClientNew;

    @FindBy(xpath = "//div[contains(text(),'Client successfully created.')]")
    WebElement addClientSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Client successfully updated.')]")
    WebElement updateClientSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement clientAlertPopupLP;

    @FindBy(xpath = "//input[@name='scmEmails']")
    WebElement scmEmails;

    @FindBy(xpath = "//input[@name='customsReleaseEmails']")
    WebElement customsReleaseEmails;

    @FindBy(xpath = "//input[@name='billingEmails']")
    WebElement billingEmails;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    // Method to capture the page heading
    public String getPageHeading() {
        return clientPageHeading.getText();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(clientPageHeading)).isDisplayed();
    }

    public void clickAddClientBtn() {
        addClientBtn.click();
    }

    // Method to select a dropdown value by visible text
    public void selectDropdownByText(WebElement dropdownElement, String value) {
        dropdownElement.click(); // open the dropdown
        WebElement dropdownOption = wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath("//li[contains(text(),'" + value + "')]"))));
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownOption);
        dropdownOption.click();
    }

    public void addClientData(String Name, String ContactPerson, String Address1, String Email1, String FinancialEmail,
                              String FiscalMattersEmail1, String CeoEmail1, String TelephoneNumber1, String RegionDropDown,
                              String CountryDropDown, String ZipCity, String Vat, String LfrDropDown, String ScmEmails, String CustomsReleaseEmails, String BillingEmails) {
        clientName.sendKeys(Name);
        contactPerson.sendKeys(ContactPerson);
        clientAddress1.sendKeys(Address1);
        clientEmail1.sendKeys(Email1);
        clientFinancialEmail.sendKeys(FinancialEmail);
        clientFiscalMattersEmail1.sendKeys(FiscalMattersEmail1);
        clientCeoEmail1.sendKeys(CeoEmail1);
        clientTelephoneNumber1.sendKeys(TelephoneNumber1);
        selectDropdownByText(regionDropDown, RegionDropDown);
        selectDropdownByText(countryDropDown, CountryDropDown);
        clientZipCity.sendKeys(ZipCity);
        clientVat.sendKeys(Vat);
        selectDropdownByText(clientLfrDropDown, LfrDropDown);
        clickExtraEmailFieldCross();
        clickExtraAddressFieldCross();
        clickExtraPhoneFieldCross();
        scmEmails.sendKeys(ScmEmails);
        customsReleaseEmails.sendKeys(CustomsReleaseEmails);
        billingEmails.sendKeys(BillingEmails);

        clickSaveClientBack();
    }

    public void clickExtraEmailFieldCross() {
        extraEmailFieldCross.click();
    }

    public void clickExtraAddressFieldCross() {
        wait.until(ExpectedConditions.visibilityOf(extraAddressFieldCross)).click();
    }

    public void clickExtraPhoneFieldCross() {
        wait.until(ExpectedConditions.visibilityOf(extraPhoneFieldCross)).click();
    }

    public void clickSaveClientBack() {
        saveClientBack.click();
    }

    public void clickSaveClientNew() {
        saveClientNew.click();
    }

    public String getClientSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(addClientSuccessAlertMessage)).getText();
    }

    public boolean isClientSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addClientSuccessAlertMessage)).isDisplayed();
    }

    public boolean isUpdateClientSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(updateClientSuccessAlertMessage)).isDisplayed();
    }

    public String getUpdatedClientSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(updateClientSuccessAlertMessage)).getText();
    }

    public void clickOnAlertPopupLP() {
        wait.until(ExpectedConditions.visibilityOf(clientAlertPopupLP)).click();
    }

}
