package com.LilyCargo.Pages;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class CarriersTestPage {

	WebDriver driver;
	JavascriptExecutor executor;
	Actions actions;
	WebDriverWait wait;
	Faker faker;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public CarriersTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
		faker = new Faker(new Locale.Builder().setLanguage("nl").build());
	}

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	@CacheLookup
	@FindBy(xpath = "//h2[text()='Carriers']")
	WebElement carrierPageHeading;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Add Carrier']")
	WebElement addCarrierBtn;

	@CacheLookup
	@FindBy(xpath = "//input[@name='ticker']")
	WebElement ticker;

	@CacheLookup
	@FindBy(xpath = "//input[@name='name']")
	WebElement carrierName;

	@CacheLookup
	@FindBy(xpath = "//input[@name='email1']")
	WebElement carrierEmail1;

	@CacheLookup
	@FindBy(xpath = "//input[@name='email2']")
	WebElement carrierEmail2;

	@CacheLookup
	@FindBy(xpath = "//input[@name='tel1']")
	WebElement telephoneNumber1;

	@CacheLookup
	@FindBy(xpath = "//input[@name='tel2']")
	WebElement telephoneNumber2;

	@CacheLookup
	@FindBy(xpath = "//input[@name='address1']")
	WebElement address1;

	@CacheLookup
	@FindBy(xpath = "//input[@name='address2']")
	WebElement address2;

	@CacheLookup
	@FindBy(xpath = "//input[@name='zipCity']")
	WebElement zipCity;

	@CacheLookup
	@FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
	WebElement countryDropDown;

	@CacheLookup
	@FindBy(xpath = "//li[contains(.,'CANADA')]")
	WebElement countryDropDownValue;

	@CacheLookup
	@FindBy(xpath = "//input[@name='emails[0].label']")
	WebElement extraEmailLabel;

	@CacheLookup
	@FindBy(xpath = "//input[@name='emails[0].value']")
	WebElement extraEmailValue;

	@CacheLookup
	@FindBy(xpath = "(//*[name()='svg'][@role='img'])[12]")
	WebElement extraAddressFieldCross;

	@CacheLookup
	@FindBy(xpath = "(//*[name()='svg'][@role='img'])[12]")
	WebElement extraPhoneFieldCross;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Save & Back']")
	WebElement saveCarrierBack;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Save & New']")
	WebElement saveCarrierNew;

	@FindBy(xpath = "//div[contains(text(),'Carrier successfully created.')]")
	WebElement addCarrierSuccessAlertMessage;

	@FindBy(xpath = "//div[contains(text(),'Carrier successfully updated.')]")
	WebElement updateCarrierSuccessAlertMessage;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
	WebElement alertPopupDP;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	// Method to capture the page heading
	public String getPageHeading() {
		return carrierPageHeading.getText();
	}

	public boolean isHeadingDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(carrierPageHeading)).isDisplayed();
	}

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

	/*
	 * public void enterTelephoneNumber2(String text) {
	 * actions.click(telephoneNumber2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(
	 * Keys.CONTROL).sendKeys(Keys.DELETE) .perform();
	 * telephoneNumber2.sendKeys(text); }
	 */

	// Method to generate a Dutch phone number without dashes
	public String getDutchPhoneNumber() {
		String dutchPhoneNumber = faker.phoneNumber().phoneNumber();

		// Replace unwanted characters and ensure it starts with +31
		dutchPhoneNumber = dutchPhoneNumber.replaceAll("[^\\d+]", ""); // Keep only digits and the plus sign
		if (!dutchPhoneNumber.startsWith("+31")) {
			dutchPhoneNumber = "+31" + dutchPhoneNumber.substring(1); // Ensure it starts with +31
		}

		return dutchPhoneNumber;
	}

	public void enterDutchPhoneNumber() {
		String dutchPhoneNumber = getDutchPhoneNumber();
		telephoneNumber1.sendKeys(dutchPhoneNumber);
	}

	public void enterDutchPhoneNumber2() {
		actions.click(telephoneNumber2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		String dutchPhoneNumber = getDutchPhoneNumber();
		telephoneNumber2.sendKeys(dutchPhoneNumber);
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

	public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
		dropdown.click();
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
		dropdownValue.click();
	}

	public void selectCountry() {
		selectDropdownValue(countryDropDown, countryDropDownValue);
	}

	public void enterExtraEmailLabel(String text) {
		extraEmailLabel.sendKeys(text);
	}

	public void enterExtraEmailValue(String text) {
		extraEmailValue.sendKeys(text);
	}

	public void clickExtraAddressFieldCross() {
		extraAddressFieldCross.click();
	}

	public void clickExtraPhoneFieldCross() {
		wait.until(ExpectedConditions.visibilityOf(extraPhoneFieldCross)).click();
	}

	public void clickSaveCarrierBack() {
		saveCarrierBack.click();
	}

	public void clickSaveCarrierNew() {
		saveCarrierNew.click();
	}

	public String getCarrierSuccessAlertMessage() {
		return wait.until(ExpectedConditions.visibilityOf(addCarrierSuccessAlertMessage)).getText();
	}

	public boolean isCarrierSuccessAlertMessageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(addCarrierSuccessAlertMessage)).isDisplayed();
	}

	public boolean isUpdateCarrierSuccessAlertMessageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(updateCarrierSuccessAlertMessage)).isDisplayed();
	}

	public String getUpdatedCarrierSuccessAlertMessage() {
		return wait.until(ExpectedConditions.visibilityOf(updateCarrierSuccessAlertMessage)).getText();
	}

	public void clickOnAlertPopupDP() {
		wait.until(ExpectedConditions.visibilityOf(alertPopupDP)).click();
	}
}