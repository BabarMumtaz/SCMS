package com.LilyCargo.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FreightManagersTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the class is created
    public FreightManagersTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//h2[text()='Freight']")
    WebElement freightManagerPageHeading;

    @FindBy(xpath = "//button[text()='Add Freight Manager']")
    WebElement addFreightManagerBtn;

    @FindBy(xpath = "//h5[text()='Freight Manager']")
    WebElement freightManagerAddPageHeading;

    @FindBy(xpath = "//input[@name='name']")
    WebElement freightManagerName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement freightManagerEmail;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement freightManagerPhoneNumber;

    @FindBy(xpath = "//input[@name='emails[0].label']")
    WebElement freightManagerExtraEmailLabel;

    @FindBy(xpath = "//input[@name='emails[0].value']")
    WebElement freightManagerExtraEmailValue;

    @FindBy(xpath = "//input[@name='addresses[0].label']")
    WebElement freightManagerExtraAddressLabel;

    @FindBy(xpath = "//input[@name='addresses[0].value']")
    WebElement freightManagerExtraAddressValue;

    @FindBy(xpath = "//input[@name='phones[0].label']")
    WebElement freightManagerExtraPhoneLabel;

    @FindBy(xpath = "//input[@name='phones[0].value']")
    WebElement freightManagerExtraPhoneValue;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraEmailFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraAddressFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraPhoneFieldCross;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveFreightManagerBack;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveFreightManagerNew;

    @FindBy(xpath = "//div[contains(text(),'Freight Manager successfully created.')]")
    WebElement addFreightManagerSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Freight Manager successfully updated.')]")
    WebElement updateFreightManagerSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement freightManagerAlertPopupLP;

    /** ---------- Methods ---------- */

    public String getPageHeading() {
        return freightManagerPageHeading.getText();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(freightManagerPageHeading)).isDisplayed();
    }

    public void clickAddFreightManagerBtn() {
        addFreightManagerBtn.click();
    }

    public String getAddPageHeading() {
        return freightManagerAddPageHeading.getText();
    }

    public boolean isAddPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(freightManagerAddPageHeading)).isDisplayed();
    }

    public void enterFreightManagerName(String text) {
        freightManagerName.sendKeys(text);
    }

    public void enterFreightManagerEmail(String text) {
        freightManagerEmail.sendKeys(text);
    }

    public void enterFreightManagerDutchPhoneNumber(String phoneNumber) {
        freightManagerPhoneNumber.sendKeys(phoneNumber);
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

    public void clickSaveFreightManagerBack() {
        saveFreightManagerBack.click();
    }

    public void clickSaveFreightManagerNew() {
        saveFreightManagerNew.click();
    }

    public String getFreightManagerSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(addFreightManagerSuccessAlertMessage)).getText();
    }

    public boolean isFreightManagerSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addFreightManagerSuccessAlertMessage)).isDisplayed();
    }

    public boolean isUpdateFreightManagerSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(updateFreightManagerSuccessAlertMessage)).isDisplayed();
    }

    public String getUpdatedFreightManagerSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(updateFreightManagerSuccessAlertMessage)).getText();
    }

    public void clickOnAlertPopupLP() {
        wait.until(ExpectedConditions.visibilityOf(freightManagerAlertPopupLP)).click();
    }
}
