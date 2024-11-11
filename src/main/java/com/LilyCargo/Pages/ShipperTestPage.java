package com.LilyCargo.Pages;

import com.github.javafaker.Faker;
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

public class ShipperTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Faker faker;

    // Constructor that will be automatically called as soon as the object of the
    // class is created
    public ShipperTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        faker = new Faker(new Locale.Builder().setLanguage("nl").build());
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Shippers']")
    WebElement shipperPageHeading;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Add Shipper']")
    WebElement addShipperBtn;

    @CacheLookup
    @FindBy(xpath = "//h5[text()='Shipper']")
    WebElement shipperAddPageHeading;

    @CacheLookup
    @FindBy(xpath = "//input[@name='storeFront']")
    WebElement storeFront;

    @CacheLookup
    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement exportCompanyDropdown;

    @CacheLookup
    @FindBy(xpath = "//li[contains(.,'HT GARDEN LEISURE IMPORT AND EXPORT CO.,LTD')]")
    WebElement exportCompanyDropDownValue;

    @CacheLookup
    @FindBy(xpath = "//input[@name='name']")
    WebElement shipperName;

    @CacheLookup
    @FindBy(xpath = "//input[@name='address1']")
    WebElement shipperAddress1;

    @CacheLookup
    @FindBy(xpath = "//input[@name='address2']")
    WebElement shipperAddress2;

    @CacheLookup
    @FindBy(xpath = "//input[@name='zipCity']")
    WebElement zipCity;

    @CacheLookup
    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement countryDropDown;

    @CacheLookup
    @FindBy(xpath = "//li[contains(.,'CANADA')]")
    WebElement countryDropDownValue;

    @CacheLookup
    @FindBy(xpath = "//input[@name='email1']")
    WebElement shipperEmail1;

    @CacheLookup
    @FindBy(xpath = "//input[@name='email2']")
    WebElement shipperEmail2;

    @CacheLookup
    @FindBy(xpath = "//input[@name='tel1']")
    WebElement shipperTelephoneNumber1;

    @CacheLookup
    @FindBy(xpath = "//input[@name='tel2']")
    WebElement shipperTelephoneNumber2;

    @CacheLookup
    @FindBy(xpath = "//input[@name='masterId']")
    WebElement shipperMasterId;

    @CacheLookup
    @FindBy(xpath = "//input[@name='iorId']")
    WebElement shipperIorId;

    @CacheLookup
    @FindBy(xpath = "//input[@name='shipperId']")
    WebElement shipperId;

    @CacheLookup
    @FindBy(xpath = "//input[@name='emails[0].label']")
    WebElement extraEmailLabel;

    @CacheLookup
    @FindBy(xpath = "//input[@name='emails[0].value']")
    WebElement extraEmailValue;

    @CacheLookup
    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[12]")
    WebElement extraAddressFieldCross;

    @CacheLookup
    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[12]")
    WebElement extraPhoneFieldCross;

    @CacheLookup
    @FindBy(xpath = "//input[@name='scmEmails']")
    WebElement shipperSCMEmail;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement saveShipperCancel;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveShipperBack;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveShipperNew;

    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement alertPopupDP;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    // Method to capture the page heading
    public String getPageHeading() {
        return shipperPageHeading.getText();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(shipperPageHeading)).isDisplayed();
    }

    public void clickAddShipperBtn() {
        addShipperBtn.click();
    }

    public void enterShipperStore(String text) {
        storeFront.sendKeys(text);
    }

    public String getAddPageHeading() {
        return shipperAddPageHeading.getText();
    }

    public boolean isAddPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(shipperAddPageHeading)).isDisplayed();
    }

    public void enterShipperName(String text) {
        shipperName.sendKeys(text);
    }

    public void enterShipperTelephoneNumber1(String text) {
        shipperTelephoneNumber1.sendKeys(text);
    }

    // Method to generate a Dutch phone number without dashes
    public String getDutchPhoneNumber() {
        String dutchPhoneNumber = faker.phoneNumber().phoneNumber();

        // Replace unwanted characters and ensure it starts with +31
        dutchPhoneNumber = dutchPhoneNumber.replaceAll("[^\\d+]", ""); // Keep only digits and the plus sign
        if (!dutchPhoneNumber.startsWith("+31")) {
            dutchPhoneNumber = "+31" + dutchPhoneNumber.substring(1); // Ensure it starts with +31
        }

        return dutchPhoneNumber;
    }

    public void enterShipperDutchPhoneNumber() {
        String dutchPhoneNumber = getDutchPhoneNumber();
        shipperTelephoneNumber1.sendKeys(dutchPhoneNumber);
    }

    public void enterShipperDutchPhoneNumber2() {
        actions.click(shipperTelephoneNumber2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .perform();
        String dutchPhoneNumber = getDutchPhoneNumber();
        shipperTelephoneNumber2.sendKeys(dutchPhoneNumber);
    }

    public void enterShipperAddress1(String text) {
        shipperAddress1.sendKeys(text);
    }

    public void enterAddress2(String text) {
        actions.click(shipperAddress2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        shipperAddress2.sendKeys(text);
    }

    public void enterShipperZipCity(String text) {
        zipCity.sendKeys(text);
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void selectCountry() {
        selectDropdownValue(countryDropDown, countryDropDownValue);
    }

    public void selectExportCompany() {
        selectDropdownValue(exportCompanyDropdown, exportCompanyDropDownValue);
    }

    public void enterShipperEmail1(String text) {
        shipperEmail1.sendKeys(text);
    }

    public void enterShipperEmail2(String text) {
        actions.click(shipperEmail2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .perform();
        shipperEmail2.sendKeys(text);
    }

    public void enterExtraEmailLabel(String text) {
        extraEmailLabel.sendKeys(text);
    }

    public void enterExtraEmailValue(String text) {
        extraEmailValue.sendKeys(text);
    }

    public void clickExtraAddressFieldCross() {
        extraAddressFieldCross.click();
    }

    public void clickExtraPhoneFieldCross() {
        wait.until(ExpectedConditions.visibilityOf(extraPhoneFieldCross)).click();
    }

    public void enterShipperSCMEmail(String text) {
        shipperSCMEmail.sendKeys(text);
    }

    public void clickSaveShipperBack() {
        saveShipperBack.click();
    }

    public void clickSaveShipperNew() {
        saveShipperNew.click();
    }

    public void clickOnAlertPopupDP() {
        wait.until(ExpectedConditions.visibilityOf(alertPopupDP)).click();
    }
}