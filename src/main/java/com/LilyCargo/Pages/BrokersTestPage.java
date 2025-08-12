package com.LilyCargo.Pages;

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
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the class is created
    public BrokersTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

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

    @FindBy(xpath = "//input[@name='zipCity']")
    WebElement brokersZipCity;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement countryDropDown;

    @FindBy(xpath = "//li[contains(.,'MARSHAL ISLANDS')]")
    WebElement countryDropDownValue;

    @FindBy(xpath = "//input[@name='vat']")
    WebElement brokersVat;

    /** ---------- Methods ---------- */

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

    public void enterBrokersZipCity(String text) {
        brokersZipCity.sendKeys(text);
    }

    public void enterBrokersVat(String text) {
        brokersVat.sendKeys(text);
    }

}
