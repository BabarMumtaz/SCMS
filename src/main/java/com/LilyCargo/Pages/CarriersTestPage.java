package com.LilyCargo.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarriersTestPage {

	WebDriver driver;
	Actions actions;

	// Constructor that will be automatically called as soon as the object of the class is created
	public CarriersTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}

	/** ---------- Locators ---------- */

	@FindBy(xpath = "//button[text()='Add Carrier']")
	WebElement addCarrierBtn;

	@FindBy(xpath = "//input[@name='ticker']")
	WebElement ticker;

	@FindBy(xpath = "//input[@name='name']")
	WebElement carrierName;

	@FindBy(xpath = "//input[@name='email1']")
	WebElement carrierEmail1;

	@FindBy(xpath = "//input[@name='email2']")
	WebElement carrierEmail2;

	@FindBy(xpath = "//input[@name='tel1']")
	WebElement telephoneNumber1;

	@FindBy(xpath = "//input[@name='tel2']")
	WebElement telephoneNumber2;

	@FindBy(xpath = "//input[@name='address1']")
	WebElement address1;

	@FindBy(xpath = "//input[@name='address2']")
	WebElement address2;

	@FindBy(xpath = "//input[@name='zipCity']")
	WebElement zipCity;

	@FindBy(xpath = "//input[@name='emails[0].label']")
	WebElement extraEmailLabel;

	@FindBy(xpath = "//input[@name='emails[0].value']")
	WebElement extraEmailValue;

	/** ---------- Methods ---------- */

	public void clickAddCarrierBtn() {
		addCarrierBtn.click();
	}

	public void enterTicker(String text) {
		ticker.sendKeys(text);
	}

	public void enterCarrierName(String text) {
		carrierName.sendKeys(text);
	}

	public void enterCarrierEmail(String text) {
		carrierEmail1.sendKeys(text);
	}

	public void enterCarrierEmail2(String text) {
		actions.click(carrierEmail2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		carrierEmail2.sendKeys(text);
	}

	public void enterTelephoneNumber1(String text) {
		telephoneNumber1.sendKeys(text);
	}

	public void enterCarrierDutchPhoneNumber(String phoneNumber) {
		telephoneNumber1.sendKeys(phoneNumber);
	}

	public void enterCarrierDutchPhoneNumber2(String phoneNumber) {
		telephoneNumber2.sendKeys(phoneNumber);
	}

	public void enterAddress1(String text) {
		address1.sendKeys(text);
	}

	public void enterAddress2(String text) {
		actions.click(address2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		address2.sendKeys(text);
	}

	public void enterZipCity(String text) {
		zipCity.sendKeys(text);
	}

	public void enterExtraEmailLabel(String text) {
		extraEmailLabel.sendKeys(text);
	}

	public void enterExtraEmailValue(String text) {
		extraEmailValue.sendKeys(text);
	}

}