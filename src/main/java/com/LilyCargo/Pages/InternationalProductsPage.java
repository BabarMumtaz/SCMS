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

public class InternationalProductsPage {
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the class is created
    public InternationalProductsPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//h2[text()='International Products']")
    WebElement internationalProductsPageHeading;

    @FindBy(xpath = "//button[text()='Add Product Service']")
    WebElement addInternationalProductsBtn;

    @FindBy(xpath = "//input[@name='pid']")
    WebElement pidfield;

    @FindBy(xpath = "//input[@name='lmgbr']")
    WebElement lmgbrField;

    @FindBy(xpath = "//input[@name='lmgbr_out']")
    WebElement lmgbrOutField;

    @FindBy(xpath = "//input[@name='description']")
    WebElement descriptionField;

    @FindBy(xpath = "//input[@name='sort']")
    WebElement sortField;

    @FindBy(xpath = "//input[@name='price']")
    WebElement priceField;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement vatCodeDropDown;

    @FindBy(xpath = "//li[contains(.,'2/21/21% BTW / Binnenland / 1A')]")
    WebElement vatCodeDropDownValue;

    @FindBy(xpath = "//div[@id='select-Status']")
    WebElement statusDropDown;

    @FindBy(xpath = "//li[contains(.,'Inactive')]")
    WebElement statusDropDownValue;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveIntlProductsBack;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveIntlProductsNew;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//div[contains(text(),'Product Service successfully created.')]")
    WebElement addIntlProductSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Product Service successfully updated.')]")
    WebElement updateIntlProductSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement alertPopupDP;


//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean isIntlProductsPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(internationalProductsPageHeading)).isDisplayed();
    }

    public String getIntlProductsPageHeading() {
        return internationalProductsPageHeading.getText();
    }

    public void clickAddIntlProductsBtn() {
        addInternationalProductsBtn.click();
    }

    public void enterPid(String text) {
        pidfield.sendKeys(text);
    }

    public void enterLmgbrIn(String text) {
        lmgbrField.sendKeys(text);
    }

    public void enterLmgbrOut(String text) {
        lmgbrOutField.sendKeys(text);
    }

    public void enterDescription(String text) {
        descriptionField.sendKeys(text);
    }

    public void enterAddress2(String text) {
        actions.click(descriptionField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        descriptionField.sendKeys(text);
    }

    public void enterSort(String text) {
        sortField.sendKeys(text);
    }

    public void enterPrice(String text) {
        priceField.sendKeys(text);
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        wait.until(ExpectedConditions.visibilityOf(dropdown)).click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        wait.until(ExpectedConditions.visibilityOf(dropdownValue)).click();
    }

    public void selectVatCode() {
        selectDropdownValue(vatCodeDropDown, vatCodeDropDownValue);
    }

    public void selectStatus() {
        selectDropdownValue(statusDropDown, statusDropDownValue);
    }

    public void clickSaveIntlProductBack() {
        saveIntlProductsBack.click();
    }

    public void clickSaveIntlProductNew() {
        saveIntlProductsNew.click();
    }

    public boolean isIntlProductSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addIntlProductSuccessAlertMessage)).isDisplayed();
    }

    public String getIntlProductSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(addIntlProductSuccessAlertMessage)).getText();
    }

    public boolean isUpdateIntlProductSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(updateIntlProductSuccessAlertMessage)).isDisplayed();
    }

    public String getUpdatedIntlProductSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(updateIntlProductSuccessAlertMessage)).getText();
    }

    public void clickOnAlertPopupDP() {
        wait.until(ExpectedConditions.visibilityOf(alertPopupDP)).click();
    }

}