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

public class WarehousesTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the class is created
    public WarehousesTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver); 
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//h2[text()='Warehouses']")
    WebElement warehousePageHeading;

    @FindBy(xpath = "//button[text()='Add Warehouse']")
    WebElement addWarehouseBtn;

    @FindBy(xpath = "//h5[text()='Warehouse']")
    WebElement warehouseAddPageHeading;

    @FindBy(xpath = "//input[@name='company']")
    WebElement warehouseCompany;

    @FindBy(xpath = "//input[@name='contact_person']")
    WebElement contactPerson;

    @FindBy(xpath = "//input[@name='email']")
    WebElement warehouseEmail;

    @FindBy(xpath = "//input[@name='address']")
    WebElement warehouseAddress1;

    @FindBy(xpath = "//input[@name='address2']")
    WebElement warehouseAddress2;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement countryDropDown;

    @FindBy(xpath = "//li[contains(.,'MARSHAL ISLANDS')]")
    WebElement countryDropDownValue;

    @FindBy(xpath = "//input[@name='zip_city']")
    WebElement warehouseZipCity;

    @FindBy(xpath = "//input[@name='tel']")
    WebElement warehouseTelephoneNumber1;

    @FindBy(xpath = "//input[@name='tel2']")
    WebElement warehouseTelephoneNumber2;

    @FindBy(xpath = "//input[@name='agreement_notes']")
    WebElement warehouseAgreementNotes;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraEmailFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraAddressFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraPhoneFieldCross;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveWarehouseBack;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveWarehouseNew;

    @FindBy(xpath = "//div[contains(text(),'Warehouse successfully created.')]")
    WebElement addWarehouseSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Warehouse successfully updated.')]")
    WebElement updateWarehouseSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement warehouseAlertPopupLP;

    /** ---------- Methods ---------- */

    // Method to capture the page heading
    public String getPageHeading() {
        return warehousePageHeading.getText();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(warehousePageHeading)).isDisplayed();
    }

    public void clickAddWarehouseBtn() {
        addWarehouseBtn.click();
    }

    public String getAddPageHeading() {
        return warehouseAddPageHeading.getText();
    }

    public boolean isAddPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(warehouseAddPageHeading)).isDisplayed();
    }

    public void enterWarehouseCompany(String text) {
        warehouseCompany.sendKeys(text);
    }

    public void enterContactPerson(String text) {
        contactPerson.sendKeys(text);
    }

    public void enterWarehouseEmail(String text) {
        warehouseEmail.sendKeys(text);
    }

    public void enterWarehouseAddress1(String text) {
        warehouseAddress1.sendKeys(text);
    }

    public void enterWarehouseAddress2(String text) {
        actions.click(warehouseAddress2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        warehouseAddress2.sendKeys(text);
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void selectCountry() {
        selectDropdownValue(countryDropDown, countryDropDownValue);
    }

    public void enterWarehouseZipCity(String text) {
        warehouseZipCity.sendKeys(text);
    }

    public void enterWarehouseDutchPhoneNumber(String phoneNumber) {
        warehouseTelephoneNumber1.sendKeys(phoneNumber);
    }
    public void enterWarehouseDutchPhoneNumber2(String phoneNumber) {
        warehouseTelephoneNumber2.sendKeys(phoneNumber);
    }

    public void enterWarehouseAgreementNotes(String text) {
        warehouseAgreementNotes.sendKeys(text);
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

    public void clickSaveWarehouseBack() {
        saveWarehouseBack.click();
    }

    public void clickSaveWarehouseNew() {
        saveWarehouseNew.click();
    }

    public String getWarehouseSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(addWarehouseSuccessAlertMessage)).getText();
    }

    public boolean isWarehouseSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addWarehouseSuccessAlertMessage)).isDisplayed();
    }

    public boolean isUpdateWarehouseSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(updateWarehouseSuccessAlertMessage)).isDisplayed();
    }

    public String getUpdatedWarehouseSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(updateWarehouseSuccessAlertMessage)).getText();
    }

    public void clickOnAlertPopupLP() {
        wait.until(ExpectedConditions.visibilityOf(warehouseAlertPopupLP)).click();
    }
}
