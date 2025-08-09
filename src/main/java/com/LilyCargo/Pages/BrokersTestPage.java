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

public class BrokersTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the class is created
    public BrokersTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//h2[text()='Brokers']")
    WebElement brokersPageHeading;

    @FindBy(xpath = "//button[text()='Add Broker']")
    WebElement addBrokersBtn;

    @FindBy(xpath = "//h5[text()='Broker']")
    WebElement brokersAddPageHeading;

    @FindBy(xpath = "//input[@name='name']")
    WebElement brokersName;

    @FindBy(xpath = "//input[@name='entityName']")
    WebElement brokersEntityName;

    @FindBy(xpath = "//input[@name='contactPerson']")
    WebElement contactPerson;

    @FindBy(xpath = "//input[@name='telNo']")
    WebElement brokersTelephoneNumber1;

    @FindBy(xpath = "//input[@name='email']")
    WebElement brokersEmail;

    @FindBy(xpath = "//input[@name='address1']")
    WebElement brokersAddress1;

    @FindBy(xpath = "//input[@name='address2']")
    WebElement brokersAddress2;

    @FindBy(xpath = "//input[@name='zip_city']")
    WebElement brokersZipCity;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement countryDropDown;

    @FindBy(xpath = "//li[contains(.,'MARSHAL ISLANDS')]")
    WebElement countryDropDownValue;

    @FindBy(xpath = "//input[@name='vat']")
    WebElement brokersVat;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraEmailFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraAddressFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraPhoneFieldCross;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveBrokersBack;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveBrokersNew;

    @FindBy(xpath = "//div[contains(text(),'Broker successfully created.')]")
    WebElement addBrokersSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Broker successfully updated.')]")
    WebElement updateBrokersSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement brokersAlertPopupLP;

    /** ---------- Methods ---------- */

    // Method to capture the page heading
    public String getPageHeading() {
        return brokersPageHeading.getText();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(brokersPageHeading)).isDisplayed();
    }

    public void clickAddBrokersBtn() {
        addBrokersBtn.click();
    }

    public String getAddPageHeading() {
        return brokersAddPageHeading.getText();
    }

    public boolean isAddPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(brokersAddPageHeading)).isDisplayed();
    }

    public void enterBrokersName(String text) {
        brokersName.sendKeys(text);
    }

    public void enterBrokersEntityName(String text) {
        brokersEntityName.sendKeys(text);
    }

    public void enterContactPerson(String text) {
        contactPerson.sendKeys(text);
    }

    public void enterBrokersDutchPhoneNumber(String phoneNumber) {
        brokersTelephoneNumber1.sendKeys(phoneNumber);
    }

    public void enterBrokersEmail(String text) {
        brokersEmail.sendKeys(text);
    }

    public void enterBrokersAddress1(String text) {
        brokersAddress1.sendKeys(text);
    }

    public void enterBrokersAddress2(String text) {
        actions.click(brokersAddress2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        brokersAddress2.sendKeys(text);
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void enterBrokersZipCity(String text) {
        brokersZipCity.sendKeys(text);
    }

    public void selectCountry() {
        selectDropdownValue(countryDropDown, countryDropDownValue);
    }

    public void enterBrokersVat(String text) {
        brokersVat.sendKeys(text);
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

    public void clickSaveBrokersBack() {
        saveBrokersBack.click();
    }

    public void clickSaveBrokersNew() {
        saveBrokersNew.click();
    }

    public String getBrokersSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(addBrokersSuccessAlertMessage)).getText();
    }

    public boolean isBrokersSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addBrokersSuccessAlertMessage)).isDisplayed();
    }

    public boolean isUpdateBrokersSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(updateBrokersSuccessAlertMessage)).isDisplayed();
    }

    public String getUpdatedBrokersSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(updateBrokersSuccessAlertMessage)).getText();
    }

    public void clickOnAlertPopupLP() {
        wait.until(ExpectedConditions.visibilityOf(brokersAlertPopupLP)).click();
    }


}
