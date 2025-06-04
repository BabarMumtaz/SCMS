package com.LilyCargo.Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreightTestPage {

	WebDriver driver;
	JavascriptExecutor executor;
	Actions actions;
	WebDriverWait wait;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public FreightTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//h2[text()='Booked Freights']")
	WebElement heading;

	@FindBy(xpath = "//button[text()='Create Freight']")
	WebElement createFreight;

	@FindBy(xpath = "//input[@name='FNO']")
	WebElement fNO;

	@FindBy(xpath = "//input[@name='Loaded']")
	WebElement etdDatePicker;

	@FindBy(xpath = "//input[@name='Arrival']")
	WebElement etaDatePicker;

	@FindBy(xpath = "//input[@name='BLNo']")
	WebElement bLNO;

	@FindBy(xpath = "//input[@name='houseBLNo']")
	WebElement hBLNO;

	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[1]")
	WebElement clientDrop;

	@FindBy(xpath = "//li[contains(.,'Amazon EU SARL, Dutch Branch')]")
	WebElement clientDropValue;

	@FindBy(xpath = "(//div[@id='select-[object Object]'])]")
	WebElement serviceTypeDrop;

	@FindBy(xpath = "//li[contains(.,'Clear')]")
	WebElement serviceDropValue;

	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[2]")
	WebElement shipperDrop;

	@FindBy(xpath = "//li[text()='Speed Arrow Logistic Service Limited']")
	WebElement shipperDropValue;

	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[3]")
	WebElement cOODrop;

	@FindBy(xpath = "//li[text()='BELGIUM - BE']")
	WebElement cOODropValue;

	@FindBy(xpath = "(//div[@id='select-[object Object]'])[2]")
	WebElement containerDrop;

	@FindBy(xpath = "//li[contains(.,'45HQ')]")
	WebElement containerDropValue;

	@FindBy(xpath = "//input[@name='Contents']")
	WebElement contents;

	@FindBy(xpath = "//input[@name='Weights']")
	WebElement weights;

	@FindBy(xpath = "//input[@name='volume']")
	WebElement measurements;

	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[4]")
	WebElement portOfLoadingDrop;

	@FindBy(xpath = "//li[contains(.,'Brandenburg international / DE BER')]")
	WebElement portOfLoadingDropValue;

	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[5]")
	WebElement portOfDischargeDrop;

	@FindBy(xpath = "//li[contains(.,'Noibai International Airport / VNHAN')]")
	WebElement portOfDischargeDropValue;

	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[6]")
	WebElement carrierCompanyDrop;

	@FindBy(xpath = "//li[text()='China Eastern Airlines']")
	WebElement carrierCompanyDropValue;

	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[7]")
	WebElement exportCompanyDrop;

	@FindBy(xpath = "//li[contains(.,'CREATIVE LABS PTE LTD C/O Chin')]")
	WebElement exportCompanyDropValue;

	@FindBy(xpath = "(//div[@id='select-[object Object]'])[3]")
	WebElement freightWayDrop;

	@FindBy(xpath = "//li[text()='Air']")
	WebElement freightWayDropValue;

	@FindBy(xpath = "//input[@name='BondedLocation']")
	WebElement bondedLocation;

	@FindBy(xpath = "//button[text()='Save & Return']")
	WebElement saveReturnFreight;

	@FindBy(xpath = "//button[text()='Save & Next']")
	WebElement saveNextFreight;

	@FindBy(css = ".custom-status")
	WebElement customDocStatusBtn;

	@FindBy(xpath = "//div[@id='select-Custom Doc Status']")
	WebElement customDocStatusDrop;

	@FindBy(xpath = "//li[text()='sent']")
	WebElement customDocStatusDropValue;

	@FindBy(css = ".purchase-stage")
	WebElement purchaseStepBtn;

	@FindBy(xpath = "//input[@name='AdminFee']")
	WebElement administrationFee;

	@FindBy(css = ".sale-stage")
	WebElement saleStepBtn;

	@FindBy(xpath = "//input[@name='DutyEUR']")
	WebElement duty;
	
	@FindBy(css = "div[class='createFlight-title'] p")
	WebElement editPageID;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	// Method to capture the page heading
	public String getHeading() {
		return heading.getText();
	}

	public void clickCreateFreightBtn() {
		createFreight.click();
	}

	public void enterFNO(String text) {
		fNO.sendKeys(text);
	}

    // Date picker helper
    private void selectDate(WebElement element, String day, String month, String year) {
        actions.click(element).sendKeys(day).sendKeys(month).sendKeys(Keys.TAB).sendKeys(year).perform();
    }

    public void selectETDDate(String day, String month, String year) {
        selectDate(etdDatePicker, day, month, year);
    }

    public void selectETADate(String day, String month, String year) {
        selectDate(etaDatePicker, day, month, year);
    }

	public void enterBLNO(String text) {
		bLNO.sendKeys(text);
	}

	public void enterHouseBLNO(String text) {
		actions.click(hBLNO).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
		.perform();
		hBLNO.sendKeys(text);
	}

	public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
		dropdown.click();
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
		dropdownValue.click();
	}

	public void selectClient() {
		selectDropdownValue(clientDrop, clientDropValue);
	}

	public void selectServiceType() {
		selectDropdownValue(serviceTypeDrop, serviceDropValue);
	}

	public void selectShipper() {
		selectDropdownValue(shipperDrop, shipperDropValue);
	}

	public void selectCOO() {
		selectDropdownValue(cOODrop, cOODropValue);
	}

	public void selectContainer() {
		selectDropdownValue(containerDrop, containerDropValue);
	}

	public void enterContents(String text) {
		contents.sendKeys(text);
	}

	public void enterWeights(String text) {
		weights.sendKeys(text);
	}

	public void enterMeasurements(String text) {
		measurements.sendKeys(text);
	}

	public void selectPortOfLoading() {
		selectDropdownValue(portOfLoadingDrop, portOfLoadingDropValue);
	}

	public void selectPortOfDischarge() {
		selectDropdownValue(portOfDischargeDrop, portOfDischargeDropValue);
	}

	public void scrollToElement() {
		executor.executeScript("arguments[0].scrollIntoView(true);", carrierCompanyDrop);
	}

	public void selectCarrierCompany() {
		selectDropdownValue(carrierCompanyDrop, carrierCompanyDropValue);
	}

	public void selectExportCompany() {
		selectDropdownValue(exportCompanyDrop, exportCompanyDropValue);
	}

	public void selectFreightWay() {
		selectDropdownValue(freightWayDrop, freightWayDropValue);
	}

	public void enterBondedLocation(String text) {
		actions.click(bondedLocation).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
		.perform();
		bondedLocation.sendKeys(text);
	}

	public void clearBondedLocation() {
		actions.click(bondedLocation).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
	}

	public void clickSaveReturnFreightBtn() {
		wait.until(ExpectedConditions.visibilityOf(saveReturnFreight)).click();
	}

	public void clickSaveNextFreightBtn() {
		wait.until(ExpectedConditions.visibilityOf(saveNextFreight)).click();
	}

	public void clickCustomDocStatusBtn() {
		wait.until(ExpectedConditions.visibilityOf(customDocStatusBtn)).click();
	}

	public void selectCustomDocStatus() {
		selectDropdownValue(customDocStatusDrop, customDocStatusDropValue);
	}

	public void clickPurchaseStepBtn() {
		wait.until(ExpectedConditions.visibilityOf(purchaseStepBtn)).click();
	}

	public void enterAdminFee(String text) {
		actions.click(administrationFee).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
		.perform();
		administrationFee.sendKeys(text);
	}

	public void clickSaleStepBtn() {
		wait.until(ExpectedConditions.visibilityOf(saleStepBtn)).click();
	}

	public void enterDuty(String text) {
		actions.click(duty).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
		.perform();
		duty.sendKeys(text);
	}

	public boolean isEditPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(editPageID)).isDisplayed();
	}

	public String getEditFreightID() {
		return wait.until(ExpectedConditions.visibilityOf(editPageID)).getText();
	}
}
