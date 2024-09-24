package com.LilyCargo.Pages;

import com.github.javafaker.Faker;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        faker = new Faker(new Locale.Builder().setLanguage("nl").build());
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------


    @CacheLookup
    @FindBy(xpath = "//h2[text()='Client']")
    WebElement clientPageHeading;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Add Client']")
    WebElement addClientBtn;

    @CacheLookup
    @FindBy(xpath = "//input[@name='name']")
    WebElement clientName;

    @CacheLookup
    @FindBy(xpath = "//input[@name='contactPerson']")
    WebElement contactPerson;

    @CacheLookup
    @FindBy(xpath = "//input[@name='address1']")
    WebElement clientAddress1;

    @CacheLookup
    @FindBy(xpath = "//input[@name='email1']")
    WebElement clientEmail1;

    @CacheLookup
    @FindBy(xpath = "//input[@name='financeEmail']")
    WebElement clientFinancialEmail;

    @CacheLookup
    @FindBy(xpath = "//input[@name='exportEmail']")
    WebElement clientFiscalMattersEmail1;

    @CacheLookup
    @FindBy(xpath = "//input[@name='ceoEmail']")
    WebElement clientCeoEmail1;

    @CacheLookup
    @FindBy(xpath = "//input[@name='tel']")
    WebElement clientTelephoneNumber1;

    @CacheLookup
    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement regionDropDown;

    @CacheLookup
    @FindBy(xpath = "//li[contains(.,'nl')]")
    WebElement regionDropDownValue;

    @CacheLookup
    @FindBy(xpath = "(//div[@id='select-[object Object]'])[2]")
    WebElement countryDropDown;

    @CacheLookup
    @FindBy(xpath = "//li[contains(.,'CANADA')]")
    WebElement countryDropDownValue;

    @CacheLookup
    @FindBy(xpath = "//input[@name='zipCity']")
    WebElement clientZipCity;

    @CacheLookup
    @FindBy(xpath = "//input[@name='vat']")
    WebElement clientVat;

    @CacheLookup
    @FindBy(xpath = "(//div[@id='select-[object Object]'])[3]")
    WebElement clientLfrDropDown;

    @CacheLookup
    @FindBy(xpath = "//li[contains(.,'NL LMBV B06 (IMPORT & Export)')]")
    WebElement clientLfrDropDownValue;

    @CacheLookup
    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraEmailFieldCross;

    @CacheLookup
    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraAddressFieldCross;

    @CacheLookup
    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraPhoneFieldCross;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveClientBack;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveClientNew;

    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement clientAlertPopupLP;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    // Method to capture the page heading
    public String getPageHeading() {
        return clientPageHeading.getText();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(clientPageHeading)).isDisplayed();
    }

    public void clickAddCarrierBtn() {
        addClientBtn.click();
    }

    public void addClientData(String Name, String ContactPerson, String Address1, String Email1, String FinancialEmail, String FiscalMattersEmail1, String CeoEmail1, String TelephoneNumber1,
                              String RegionDropDown, String CountryDropDown, String ZipCity, String Vat, String LfrDropDown) {
        clientName.sendKeys(Name);
        contactPerson.sendKeys(ContactPerson);
        clientAddress1.sendKeys(Address1);
        clientEmail1.sendKeys(Email1);
        clientFinancialEmail.sendKeys(FinancialEmail);
        clientFiscalMattersEmail1.sendKeys(FiscalMattersEmail1);
        clientCeoEmail1.sendKeys(CeoEmail1);
        clientTelephoneNumber1.sendKeys(TelephoneNumber1);
        regionDropDown.sendKeys(RegionDropDown);
        countryDropDown.sendKeys(CountryDropDown);
        clientZipCity.sendKeys(ZipCity);
        clientVat.sendKeys(Vat);
        clientLfrDropDown.sendKeys(LfrDropDown);
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

    public void clickOnAlertPopupLP() {
        wait.until(ExpectedConditions.visibilityOf(clientAlertPopupLP)).click();
    }

}
