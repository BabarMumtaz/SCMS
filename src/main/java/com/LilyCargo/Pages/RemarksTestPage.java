package com.LilyCargo.Pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemarksTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

    public RemarksTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//img[@alt='Add']")
    WebElement remarksAddIcon;

    @FindBy(xpath = "//button[text()='Customs Remarks']")
    WebElement customsRemarksTab;

    @FindBy(xpath = "//button[text()='Sales Remarks']")
    WebElement salesRemarksTab;

    @FindBy(xpath = "//textarea[@name='remarks']")
    WebElement RemarksPopupTextField;

    @FindBy(xpath = "//input[@name='cRemarksDate']")
    WebElement customsRemarksDateField;

    @FindBy(id = "select-Set Time")
    WebElement customsRemarksTimeField;

    @FindBy(xpath = "//li[text()='two days']")
    WebElement customsRemarksTimeOptions;

    /** ---------- Methods ---------- */

    public void clickOnCustomsRemarksTab() {
        wait.until(ExpectedConditions.visibilityOf(customsRemarksTab)).click();
    }

    public void clickSalesRemarksTab() {
        wait.until(ExpectedConditions.elementToBeClickable(salesRemarksTab)).click();
    }

    public void clickOnRemarksAddIcon() {
        wait.until(ExpectedConditions.visibilityOf(remarksAddIcon)).click();
    }

    public void enterRemarksText(String text) {
        RemarksPopupTextField.sendKeys(text);
    }

    private void selectDateUsingKeys(WebElement element, String day, String month, String year) {
        actions.click(element).sendKeys(day).sendKeys(month).sendKeys(year).perform();
    }

    public void selectCustomsRemarksDate(String day, String month, String year) {
        selectDateUsingKeys(customsRemarksDateField, day, month, year);
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void selectCustomsRemarksTime() {
        selectDropdownValue(customsRemarksTimeField, customsRemarksTimeOptions);
    }
}
