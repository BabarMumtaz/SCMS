package com.LilyCargo.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IntrastatsTestPage {

	WebDriver driver;
	JavascriptExecutor executor;
	WebDriverWait wait;

	public IntrastatsTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.executor = (JavascriptExecutor) this.driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//h2[text()='Intrastats']")
	WebElement intrastatsHeading;

	@FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
	WebElement lfrDropDown;

	@FindBy(xpath = "//li[contains(.,'NL LMLOG Fiscal Rep (Import)')]")
	WebElement lfrDropDownValue;

	@FindBy(xpath = "(//div[@id='select-[object Object]'])[2]")
	WebElement yearDropDown;

	@FindBy(xpath = "//li[contains(.,'2024')]")
	WebElement yearDropDownValue;

	@FindBy(xpath = "(//div[@id='select-[object Object]'])[3]")
	WebElement monthDropDown;

	@FindBy(xpath = "//li[contains(.,'1')]")
	WebElement monthDropDownValue;

	@FindBy(xpath = "(//div[@id='select-[object Object]'])[4]")
	WebElement zoneDropDown;

	//EU (All Except NL)
	@FindBy(xpath = "//li[contains(.,'NL')]")
	WebElement zoneDropDownValue;

	@FindBy(xpath = "(//input[@id='selectable-Client'])[1]")
	WebElement clientDropDown;

	@FindBy(xpath = "//li[contains(.,'Amazon EU SARL, Dutch Branch')]")
	WebElement clientDropDownValue;

	@FindBy(className = "Generate Data")
	WebElement generateDataButton;

	@FindBy(xpath = "//button[text()='Create Freight']")
	WebElement CreateFreight;

	@FindBy(xpath = "//input[@name='FNO']")
	WebElement FNO;

	@FindBy(xpath = "//input[@name='Loaded']")
	WebElement ETDdatePicker;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	// Method to capture the page heading
	public String getIntrastatsPageHeading() {
		return intrastatsHeading.getText();
	}

	// Method to click on Logout button
	public void clickLogout() {
		logoutButton.click();
	}

	public void clickCreateFreightBtn() {
		CreateFreight.click();
	}

	public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
		dropdown.click();
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
		dropdownValue.click();
	}

	public void selectCountry() {
		selectDropdownValue(countryDropDown, countryDropDownValue);
	}

}
