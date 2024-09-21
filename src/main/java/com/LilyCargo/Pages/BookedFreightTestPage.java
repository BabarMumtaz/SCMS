package com.LilyCargo.Pages;

import java.time.Duration;

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

public class BookedFreightTestPage {

	WebDriver driver;
	JavascriptExecutor executor;
	Actions actions;
	WebDriverWait wait;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public BookedFreightTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	@CacheLookup
	@FindBy(xpath = "//h2[text()='Booked Freights']")
	WebElement heading;

	@CacheLookup
	@FindBy(className = "logout")
	WebElement logoutButton;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Create Freight']")
	WebElement createFreight;

	@CacheLookup
	@FindBy(xpath = "//input[@name='FNO']")
	WebElement fNO;

	@CacheLookup
	@FindBy(xpath = "//input[@name='Loaded']")
	WebElement eTDdatePicker;

	@CacheLookup
	@FindBy(xpath = "//input[@name='Arrival']")
	WebElement eTAdatePicker;

	@CacheLookup
	@FindBy(xpath = "//input[@name='BLNo']")
	WebElement bLNO;

	@CacheLookup
	@FindBy(xpath = "//input[@name='houseBLNo']")
	WebElement hBLNO;

	@CacheLookup
	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[1]")
	WebElement clientDrop;

	@CacheLookup
	@FindBy(xpath = "//li[contains(.,'WTD Logistics HK Limited')]")
	WebElement clientDropValue;

	@CacheLookup
	@FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
	WebElement serviceTypeDrop;

	@CacheLookup
	@FindBy(xpath = "//li[contains(.,'Clear')]")
	WebElement serviceDropValue;

	@CacheLookup
	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[2]")
	WebElement shipperDrop;

	@CacheLookup
	@FindBy(xpath = "//li[text()='Speed Arrow Logistic Service Limited']")
	WebElement shipperDropValue;

	@CacheLookup
	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[3]")
	WebElement cOODrop;

	@CacheLookup
	@FindBy(xpath = "//li[text()='BELGIUM - BE']")
	WebElement cOODropValue;

	@CacheLookup
	@FindBy(xpath = "(//div[@id='select-[object Object]'])[2]")
	WebElement containerDrop;

	@CacheLookup
	@FindBy(xpath = "//li[contains(.,'45HQ')]")
	WebElement containerDropValue;

	@CacheLookup
	@FindBy(xpath = "//input[@name='Contents']")
	WebElement contents;

	@CacheLookup
	@FindBy(xpath = "//input[@name='Weights']")
	WebElement weights;

	@CacheLookup
	@FindBy(xpath = "//input[@name='volume']")
	WebElement measurements;

	@CacheLookup
	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[4]")
	WebElement portOfLoadingDrop;

	@CacheLookup
	@FindBy(xpath = "//li[contains(.,'Brandenburg international / DE BER')]")
	WebElement portOfLoadingDropValue;

	@CacheLookup
	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[5]")
	WebElement portOfDischargeDrop;

	@CacheLookup
	@FindBy(xpath = "//li[contains(.,'Noibai International Airport / VNHAN')]")
	WebElement portOfDischargeDropValue;

	@CacheLookup
	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[6]")
	WebElement carrierCompanyDrop;

	@CacheLookup
	@FindBy(xpath = "//li[text()='China Eastern Airlines']")
	WebElement carrierCompanyDropValue;

	@CacheLookup
	@FindBy(xpath = "(//input[@id='selectable-[object Object]'])[7]")
	WebElement exportCompanyDrop;

	@CacheLookup
	@FindBy(xpath = "//li[text()='Hang Zhou AnZhe Logistics and Technology']")
	WebElement exportCompanyDropValue;

	@CacheLookup
	@FindBy(xpath = "(//div[@id='select-[object Object]'])[3]")
	WebElement freightWayDrop;

	@CacheLookup
	@FindBy(xpath = "//li[text()='Air']")
	WebElement freightWayDropValue;

	@CacheLookup
	@FindBy(xpath = "//input[@name='BondedLocation']")
	WebElement bondedLocation;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Save & Return']")
	WebElement saveReturnFreight;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Save & Next']")
	WebElement saveNextFreight;

	@CacheLookup
	@FindBy(css = ".custom-status")
	WebElement customDocStatusBtn;

	@CacheLookup
	@FindBy(xpath = "//div[@id='select-Custom Doc Status']")
	WebElement customDocStatusDrop;

	@CacheLookup
	@FindBy(xpath = "//li[text()='sent']")
	WebElement customDocStatusDropValue;

	@CacheLookup
	@FindBy(css = ".purchase-stage")
	WebElement purchaseStepBtn;

	@CacheLookup
	@FindBy(xpath = "//input[@name='AdminFee']")
	WebElement administrationFee;

	@CacheLookup
	@FindBy(css = ".sale-stage")
	WebElement saleStepBtn;

	@CacheLookup
	@FindBy(xpath = "//input[@name='DutyEUR']")
	WebElement duty;
	
	@CacheLookup
	@FindBy(css = "div[class='createFlight-title'] p")
	WebElement editPageID;
	
//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	// Method to capture the page heading
	public String getHeading() {
		return heading.getText();
	}

	// Method to click on Logout button
	public void clickLogout() {
		logoutButton.click();
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
        selectDate(eTDdatePicker, day, month, year);
    }

    public void selectETADate(String day, String month, String year) {
        selectDate(eTAdatePicker, day, month, year);
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

}
