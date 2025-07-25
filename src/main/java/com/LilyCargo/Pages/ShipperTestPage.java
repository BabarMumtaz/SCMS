package com.LilyCargo.Pages;

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

public class ShipperTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the
    // class is created
    public ShipperTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//h2[text()='Shippers']")
    WebElement shipperPageHeading;

    @FindBy(xpath = "//button[text()='Add Shipper']")
    WebElement addShipperBtn;

    @FindBy(xpath = "//h5[text()='Shipper']")
    WebElement shipperAddPageHeading;

    @FindBy(xpath = "//input[@name='storeFront']")
    WebElement storeFront;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement exportCompanyDropdown;

    @FindBy(xpath = "//li[contains(.,'HT GARDEN LEISURE IMPORT AND EXPORT CO.,LTD')]")
    WebElement exportCompanyDropDownValue;

    @FindBy(xpath = "//input[@name='name']")
    WebElement shipperName;

    @FindBy(xpath = "//input[@name='address1']")
    WebElement shipperAddress1;

    @FindBy(xpath = "//input[@name='address2']")
    WebElement shipperAddress2;

    @FindBy(xpath = "//input[@name='zipCity']")
    WebElement zipCity;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[2]")
    WebElement countryDropDown;

    @FindBy(xpath = "//li[contains(.,'CANADA')]")
    WebElement countryDropDownValue;

    @FindBy(xpath = "//input[@name='email1']")
    WebElement shipperEmail1;

    @FindBy(xpath = "//input[@name='email2']")
    WebElement shipperEmail2;

    @FindBy(xpath = "//input[@name='tel1']")
    WebElement shipperTelephoneNumber1;

    @FindBy(xpath = "//input[@name='tel2']")
    WebElement shipperTelephoneNumber2;

    @FindBy(xpath = "//input[@name='masterId']")
    WebElement shipperMasterId;

    @FindBy(xpath = "//input[@name='iorId']")
    WebElement shipperIorId;

    @FindBy(xpath = "//input[@name='shipperId']")
    WebElement shipperId;

    @FindBy(xpath = "//input[@name='emails[0].label']")
    WebElement extraEmailLabel;

    @FindBy(xpath = "//input[@name='emails[0].value']")
    WebElement extraEmailValue;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[12]")
    WebElement extraAddressFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[12]")
    WebElement extraPhoneFieldCross;

    @FindBy(xpath = "//input[@name='scmEmails']")
    WebElement shipperSCMEmail;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement saveShipperCancel;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveShipperBack;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveShipperNew;

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

    public String getAddPageHeading() {
        return shipperAddPageHeading.getText();
    }

    public boolean isAddPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(shipperAddPageHeading)).isDisplayed();
    }

    public void enterShipperStore(String text) {
        storeFront.sendKeys(text);
    }

    public void enterShipperName(String text) {
        shipperName.sendKeys(text);
    }

    public void enterShipperTelephoneNumber1(String text) {
        shipperTelephoneNumber1.sendKeys(text);
    }

    public void enterShipperDutchPhoneNumber(String phoneNumber) {
        shipperTelephoneNumber1.sendKeys(phoneNumber);
    }

    public void enterShipperDutchPhoneNumber2(String phoneNumber) {
        shipperTelephoneNumber2.sendKeys(phoneNumber);
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
}