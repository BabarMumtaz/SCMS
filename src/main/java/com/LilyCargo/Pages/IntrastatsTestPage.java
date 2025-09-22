package com.LilyCargo.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IntrastatsTestPage {

	WebDriver driver;
	JavascriptExecutor executor;
	WebDriverWait wait;

	/** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

	public IntrastatsTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.executor = (JavascriptExecutor) this.driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	/** ---------- Locators ---------- */

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

	@FindBy(xpath = "//button[text()='Generate Data']")
	WebElement generateDataButton;

	@FindBy(xpath = "//td[text()='No data found']")
	WebElement noDataFoundText;

	@FindBy(xpath = "//table[@id='grid']//tbody/tr[1]/td[2]")
	WebElement listingMonthFirstCell;

	//id = download-dropdown
	@FindBy(xpath = "//img[@alt='Download']")
	WebElement exportIcon;

	@FindBy(xpath = "//a[text()='Freights Data']")
	WebElement freightDataExportOption;

	@FindBy(xpath = "//a[text()='Cargo Data']")
	WebElement cargoDataExportOption;

	/** ---------- Methods ---------- */

	public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
		dropdown.click();
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
		//String xpath = String.format("//li[normalize-space()='%s']", optionText);
		wait.until(ExpectedConditions.visibilityOf(dropdownValue)).click();
	}

	public void selectlfr() {
		selectDropdownValue(lfrDropDown, lfrDropDownValue);
	}

	public void selectYear() {
		selectDropdownValue(yearDropDown, yearDropDownValue);
	}

	public void selectMonth() {
		selectDropdownValue(monthDropDown, monthDropDownValue);
	}

	public void selectZone() {
		selectDropdownValue(zoneDropDown, zoneDropDownValue);
	}

	public void selectClient() {
		selectDropdownValue(clientDropDown, clientDropDownValue);
	}


	// Reusable Method to select dropdown
	private void selectDropdownOption(WebElement dropdown, String optionText) {
		dropdown.click();
		String xpath = String.format("//li[normalize-space()='%s']", optionText);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
	}

	//-------------------------------------------------------------------------


	// Reusable method to select client
	public void selectClient(String clientText) {
		clientDropDown.sendKeys(clientText);
		String xpath = String.format("//li[contains(text(),'%s')]", clientText);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
	}

	public void selectFields(String lfr, String zone, String year, String client) {
		selectDropdownOption(lfrDropDown, lfr);
		selectDropdownOption(zoneDropDown, zone);
		selectDropdownOption(yearDropDown, year);
		selectClient(client);
	}

	//----------------------------------------------------------

	// Method to click on Logout button
	public void clickGenerateDataButton() {
		generateDataButton.click();
	}

	public void clickExportIcon() {
		exportIcon.click();
	}

	public void clickFreightDataExportOption() {
		freightDataExportOption.click();
	}

	public void clickCargoDataExportOption() {
		cargoDataExportOption.click();
	}

	public void selectMonthAndGenerate(int month) throws InterruptedException {
		selectDropdownOption(monthDropDown, String.valueOf(month));
		executor.executeScript("arguments[0].scrollIntoView(true);", monthDropDownValue);
		wait.until(ExpectedConditions.visibilityOf(generateDataButton)).click();
		Thread.sleep(1500);
	}

	public boolean isNoDataFoundVisible() {
		try {
			return wait.until(ExpectedConditions.visibilityOf(noDataFoundText)).isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}

	public String getMonthFromFirstRow() {
		return wait.until(ExpectedConditions.visibilityOf(listingMonthFirstCell)).getText();
	}

}
