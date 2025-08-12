package com.LilyCargo.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WarehousesTestPage {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the class is created
    public WarehousesTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver); 
    }

    /** ---------- Locators ---------- */


    @FindBy(xpath = "//button[text()='Add Warehouse']")
    WebElement addWarehouseBtn;

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

    @FindBy(xpath = "//input[@name='zip_city']")
    WebElement warehouseZipCity;

    @FindBy(xpath = "//input[@name='tel']")
    WebElement warehouseTelephoneNumber1;

    @FindBy(xpath = "//input[@name='tel2']")
    WebElement warehouseTelephoneNumber2;

    @FindBy(xpath = "//input[@name='agreement_notes']")
    WebElement warehouseAgreementNotes;

    /** ---------- Methods ---------- */

    public void clickAddWarehouseBtn() {
        addWarehouseBtn.click();
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

}
