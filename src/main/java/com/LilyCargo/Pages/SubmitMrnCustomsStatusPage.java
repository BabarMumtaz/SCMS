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

public class SubmitMrnCustomsStatusPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

    public SubmitMrnCustomsStatusPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//input[@name='mrn']")
    WebElement mrnNumberField;

    @FindBy(xpath = "//input[@name='remarks']")
    WebElement mrnRemarksTextField;

    @FindBy(xpath = "//input[@name='imaDate']")
    WebElement mrnDateField;

    @FindBy(xpath = "//div[@id='select-Customs Status']")
    WebElement customsStatusDropdown;

    @FindBy(xpath = "//li[text()='Clear']")
    WebElement customsStatusDropdownOptions;

    @FindBy(xpath = "//button[text()='Submit MRN & Customs Status']")
    WebElement submitMrnTask;

    @FindBy(xpath = "//button[text()='Upload']")
    WebElement uploadMrnButton;

    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteMrnButton;

    /** ---------- Methods ---------- */

    public void scrollToElement() {
        executor.executeScript("arguments[0].scrollIntoView(true);", submitMrnTask);
    }

    public void clickSubmitMrnTask() {
        wait.until(ExpectedConditions.visibilityOf(submitMrnTask)).click();
    }

    public void clickUploadMrnButton() {
        wait.until(ExpectedConditions.visibilityOf(uploadMrnButton)).click();
    }

    public void clickDeleteMrnButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteMrnButton)).click();
    }

    public void enterMrnNumber(String text) {
        mrnNumberField.sendKeys(text);
    }

    public WebElement getMrnInput() {
        return mrnNumberField;
    }

    public void enterMrnRemarks(String text) {
        mrnRemarksTextField.sendKeys(text);
    }

    private void selectDate(WebElement element, String day, String month, String year) {
        actions.click(element).sendKeys(day).sendKeys(month).sendKeys(year).perform();
    }

    public void selectMrnDate(String day, String month, String year) {
        selectDate(mrnDateField, day, month, year);
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void selectCustomsStatusDropdown() {
        selectDropdownValue(customsStatusDropdown, customsStatusDropdownOptions);
    }

}
