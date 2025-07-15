package com.LilyCargo.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExportCompaniesTestPage {
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the
    // class is created
    public ExportCompaniesTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//h2[text()='Export Companies']")
    WebElement exportCompanyPageHeading;

    @FindBy(xpath = "//button[text()='Add Export Company']")
    WebElement addExportCompanyBtn;

    @FindBy(xpath = "//h5[text()='Export Company']")
    WebElement exportCompanyAddPageHeading;

    @FindBy(xpath = "//input[@name='name']")
    WebElement exportCompanyName;

    @FindBy(xpath = "//input[@name='contactPerson']")
    WebElement contactPerson;

    @FindBy(xpath = "//input[@name='email']")
    WebElement exportCompanyEmail1;

    @FindBy(xpath = "//input[@name='address1']")
    WebElement exportCompanyAddress1;

    @FindBy(xpath = "//input[@name='address2']")
    WebElement exportCompanyAddress2;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement countryDropDown;

    @FindBy(xpath = "//li[contains(.,'MARSHAL ISLANDS')]")
    WebElement countryDropDownValue;

    @FindBy(xpath = "//input[@name='zipCity']")
    WebElement exportCompanyZipCity;

    @FindBy(xpath = "//input[@name='telephone1']")
    WebElement exportCompanyTelephoneNumber1;

    @FindBy(xpath = "//input[@name='telephone2']")
    WebElement exportCompanyTelephoneNumber2;

    @FindBy(xpath = "//input[@name='agreement_notes']")
    WebElement exportCompanyAgreementNotes;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraEmailFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraAddressFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraPhoneFieldCross;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveExportCompanyBack;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveExportCompanyNew;

    @FindBy(xpath = "//div[contains(text(),'Export Company successfully created.')]")
    WebElement addExportCompanySuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Export Company successfully updated.')]")
    WebElement updateExportCompanySuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement exportCompanyAlertPopupLP;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    // Method to capture the page heading
    public String getPageHeading() {
        return exportCompanyPageHeading.getText();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(exportCompanyPageHeading)).isDisplayed();
    }

    public void clickAddExportCompanyBtn() {
        addExportCompanyBtn.click();
    }

    public String getAddPageHeading() {
        return exportCompanyAddPageHeading.getText();
    }

    public boolean isAddPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(exportCompanyAddPageHeading)).isDisplayed();
    }

    public void enterExportCompanyName(String text) {
        exportCompanyName.sendKeys(text);
    }

    public void enterContactPerson(String text) {
        contactPerson.sendKeys(text);
    }

    public void enterExportCompanyEmail1(String text) {
        exportCompanyEmail1.sendKeys(text);
    }

    public void enterExportCompanyAddress1(String text) {
        exportCompanyAddress1.sendKeys(text);
    }

    public void enterExportCompanyAddress2(String text) {
        actions.click(exportCompanyAddress2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        exportCompanyAddress2.sendKeys(text);
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void selectCountry() {
        selectDropdownValue(countryDropDown, countryDropDownValue);
    }

    public void enterExportCompanyZipCity(String text) {
        exportCompanyZipCity.sendKeys(text);
    }

    public void enterExportCompanyDutchPhoneNumber(String phoneNumber) {
        exportCompanyTelephoneNumber1.sendKeys(phoneNumber);
    }
    public void enterExportCompanyDutchPhoneNumber2(String phoneNumber) {
        exportCompanyTelephoneNumber2.sendKeys(phoneNumber);
    }

    public void enterExportCompanyAgreementNotes(String text) {
        exportCompanyAgreementNotes.sendKeys(text);
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

    public void clickSaveExportCompanyBack() {
        saveExportCompanyBack.click();
    }

    public void clickSaveExportCompanyNew() {
        saveExportCompanyNew.click();
    }

    public String getExportCompanySuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(addExportCompanySuccessAlertMessage)).getText();
    }

    public boolean isExportCompanySuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addExportCompanySuccessAlertMessage)).isDisplayed();
    }

    public boolean isUpdateExportCompanySuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(updateExportCompanySuccessAlertMessage)).isDisplayed();
    }

    public String getUpdatedExportCompanySuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(updateExportCompanySuccessAlertMessage)).getText();
    }

    public void clickOnAlertPopupLP() {
        wait.until(ExpectedConditions.visibilityOf(exportCompanyAlertPopupLP)).click();
    }
}
