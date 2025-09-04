package com.LilyCargo.Pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
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
	Logger log = LogManager.getLogger(FreightTestPage.class);

	/** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

	public FreightTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}

	/** ---------- Locators ---------- */

	@FindBy(xpath = "//h2[text()='Booked Freights']")
	WebElement pageHeading;

	@FindBy(className = "createFlight-title")
	WebElement addPageHeading;

	@FindBy(xpath = "//button[text()='Create Freight']")
	WebElement createFreight;

	@FindBy(xpath = "//input[@name='FNO']")
	WebElement fNO;

	@FindBy(xpath = "//input[@name='Loaded']")
	WebElement etdDatePicker;

	@FindBy(xpath = "//input[@name='Arrival']")
	WebElement etaDatePicker;

	@FindBy(xpath = "//input[@name='ContainerNo']")
	WebElement containerNo;

	@FindBy(xpath = "//input[@name='BLNo']")
	WebElement bLNO;

	@FindBy(xpath = "//input[@name='houseBLNo']")
	WebElement hblNo;

	@FindBy(xpath = "//label[contains(text(), 'Client')]//following::input[1]")
	WebElement clientDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Client Reference')]/following::div[1]")
	WebElement clientReference;

	@FindBy(xpath = "//label[contains(text(), 'Service Type')]/following::div[@role='button'][1]")
	WebElement serviceTypeDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Shipper')]//following::input[1]")
	WebElement shipperDropDown;

	@FindBy(xpath = "//label[contains(text(), 'COO')]//following::input[1]")
	WebElement cOODropDown;

	@FindBy(xpath = "//label[contains(text(), 'Container Type')]/following::div[@role='button'][1]")
	WebElement containerDropDown;

	@FindBy(xpath = "//input[@name='Contents']")
	WebElement contents;

	@FindBy(xpath = "//input[@name='Weights']")
	WebElement weights;

	@FindBy(xpath = "//input[@name='volume']")
	WebElement measurements;

	@FindBy(xpath = "//label[contains(text(), 'Port Of Loading')]//following::input[1]")
	WebElement portOfLoadingDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Port Of Discharge')]//following::input[1]")
	WebElement portOfDischargeDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Carrier Company')]//following::input[1]")
	WebElement carrierCompanyDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Export Company')]//following::input[1]")
	WebElement exportCompanyDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Freight Way')]/following::div[@role='button'][1]")
	WebElement freightWayDropDown;

	@FindBy(xpath = "//label[contains(text(), 'VesselFlag')]//following::input[1]")
	WebElement vesselFlagDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Airline Flag')]//following::input[1]")
	WebElement airlineFlagDropDown;

	@FindBy(xpath = "//input[@name='Delivery']")
	WebElement deliveryField;

	@FindBy(xpath = "//input[@name='BondedLocation']")
	WebElement bondedLocation;

	@FindBy(xpath = "//button[text()='Save & Return']")
	WebElement saveReturnFreight;

	@FindBy(xpath = "//button[text()='Save & Next']")
	WebElement saveNextFreight;

	@FindBy(xpath = "//label[text()='Vessel Name']")
	WebElement vesselNameField;

	@FindBy(xpath = "//input[@name='Serv_Voyage']")
	WebElement servVoyageField;

	@FindBy(xpath = "//input[@name='IMO_No']")
	WebElement imoNoField;

	@FindBy(xpath = "//input[@name='Airflight_No']")
	WebElement airFlightNoField;

	@FindBy(xpath = "//input[@name='Cut_Off_Date']")
	WebElement cutOffDateField;

	@FindBy(xpath = "//input[@name='Cut_Off_Time']")
	WebElement cutOffTimeField;

	@FindBy(xpath = "//label[contains(text(), 'Logistics Type')]/following::div[@role='button'][1]")
	WebElement logisticsTypeDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Warehouse Name')]//following::input[1]")
	WebElement warehouseNameDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Notify Party')]//following::input[1]")
	WebElement notifyPartyDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Broker')]//following::input[1]")
	WebElement brokerDropDown;

	@FindBy(xpath = "//label[contains(text(), 'LFR')]//following::input[1]")
	WebElement lfrDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Freight Manager')]//following::input[1]")
	WebElement freightManagerDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Logistics')]//following::input[1]")
	WebElement logisticsDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Customs')]/following::div[@role='button'][1]")
	WebElement customsDropDown;

	@FindBy(xpath = "//input[@name='PreviousDocumentNumber']")
	WebElement previousDocumentNumberField;

	@FindBy(xpath = "//input[@name='InvoiceNo']")
	WebElement invoiceNoField;

	@FindBy(xpath = "//input[@name='ValueinEUR']")
	WebElement invoiceValueInEURField;

	@FindBy(xpath = "//label[contains(text(), 'Vat Procedure')]/following::div[@role='button'][1]")
	WebElement vatProcedureDropDown;

	@FindBy(xpath = "//input[@name='thc_inv_imp']")
	WebElement thcInvImpDateField;

	@FindBy(xpath = "//input[@name='pin_code']")
	WebElement pinCodeField;

	@FindBy(xpath = "//input[@name='pin_expire']")
	WebElement pinExpireDateField;

	@FindBy(xpath = "//input[@name='trucking_date']")
	WebElement truckingDateField;

	@FindBy(xpath = "//input[@name='InvoiceDate']")
	WebElement invoiceDateField;

	@FindBy(xpath = "//label[contains(text(), 'Trucking Co')]//following::input[1]")
	WebElement truckingCoDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Freight Book')]//following::input[1]")
	WebElement freightBookDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Additional Party')]//following::input[1]")
	WebElement additionalPartyDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Adjust Operator')]/following::div[@role='button']")
	WebElement adjustOperatorDropDown;

	@FindBy(css = ".custom-status")
	WebElement customDocStatusBtn;

	@FindBy(xpath = "//label[contains(text(), 'Custom Doc Status')]/following::div[@role='button'][1]")
	WebElement customDocStatusDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Customs Clearance')]/following::div[@role='button']")
	WebElement customsClearanceDropDown;

	@FindBy(css = ".purchase-stage")
	WebElement purchaseStepBtn;

	@FindBy(xpath = "//input[@name='AdminFee']")
	WebElement administrationFee;

	@FindBy(xpath = "//input[@name='AirportHandlingFee']")
	WebElement airportHandlingFee;

	@FindBy(xpath = "//input[@name='ArrivalStorageFee']")
	WebElement arrivalStorageFee;

	@FindBy(xpath = "//input[@name='GasMeasurementCharge']")
	WebElement gasMeasurementCharge;

	@FindBy(xpath = "//input[@name='freight_purchase_usd']")
	WebElement freightPurchaseUsdFee;

	@FindBy(css = ".sale-stage")
	WebElement saleStepBtn;

	@FindBy(xpath = "//input[@name='LogisticsCharges']")
	WebElement deliveryCharges;

	@FindBy(xpath = "//input[@name='DutyEUR']")
	WebElement duty;

	@FindBy(xpath = "//input[@name='VatEur']")
	WebElement vatEurFee;

	@FindBy(xpath = "//input[@name='FreightCharge']")
	WebElement freightCharge;

	@FindBy(xpath = "//input[@name='freight_sale_usd']")
	WebElement freightSaleUsdFee;
	
	@FindBy(css = "div[class='createFlight-title'] p")
	WebElement editPageID;

	/** ---------- Methods ---------- */

	// Method to capture the page heading
	public String getHeading() {
		return pageHeading.getText();
	}

	public String getAddPageHeading() {
		return addPageHeading.getText();
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

	public void selectCutOffDate(String day, String month, String year) {
		selectDate(cutOffDateField, day, month, year);
	}

	public void selectCutOffTime(String time) {
		cutOffTimeField.clear();
		cutOffTimeField.sendKeys(time);
	}

	public void selectDeliveryDate(String day, String month, String year) {
		selectDate(deliveryField, day, month, year);
	}

	public void selectTHCInvImpDate(String day, String month, String year) {
		selectDate(thcInvImpDateField, day, month, year);
	}

	public void selectPinExpireDate(String day, String month, String year) {
		selectDate(pinExpireDateField, day, month, year);
	}

	public void selectTruckingDate(String day, String month, String year) {
		selectDate(truckingDateField, day, month, year);
	}

	public void selectInvoiceDate(String day, String month, String year) {
		selectDate(invoiceDateField, day, month, year);
	}

	public void enterBLNO(String text) {
		bLNO.sendKeys(text);
	}

	public void enterHouseBLNO(String text) {
		actions.click(hblNo).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
		.perform();
		hblNo.sendKeys(text);
	}

	public void enterClientReference(String text) {
		clientReference.sendKeys(text);
	}

	public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
		dropdown.click();
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
		dropdownValue.click();
	}

	public void selectDropdownByText(WebElement dropdownElement, String optionText) {
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click(); // open the dropdown
		log.info("🔽 Opened dropdown");
		WebElement dropdownOption = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//li[contains(text(),'" + optionText + "')]"))));
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownOption);
		dropdownOption.click();
		log.info("✅ Selected option: " + optionText);
	}

	public void selectClient(String client) {
		selectDropdownByText(clientDropDown, client);
	}

	public void selectServiceType(String serviceType) {
		selectDropdownByText(serviceTypeDropDown, serviceType);
	}

	public void selectShipper(String shipper) {
		selectDropdownByText(shipperDropDown, shipper);
	}

	public void selectCOO(String coo) {
		selectDropdownByText(cOODropDown, coo);
	}

	public void selectContainerType(String containerType) {
		selectDropdownByText(containerDropDown, containerType);
	}

	public void selectPortOfLoading(String portOfLoading) {
		selectDropdownByText(portOfLoadingDropDown, portOfLoading);
	}

	public void selectPortOfDischarge(String portOfDischarge) {
		selectDropdownByText(portOfDischargeDropDown, portOfDischarge);
	}

	public void selectCarrierCompany(String carrierCompany) {
		selectDropdownByText(carrierCompanyDropDown, carrierCompany);
	}

	public void selectExportCompany(String exportCompany) {
		selectDropdownByText(exportCompanyDropDown, exportCompany);
	}

	public void selectFreightWay(String freightWay) {
		selectDropdownByText(freightWayDropDown, freightWay);
	}

	public void selectVesselFlag(String vesselFlag) {
		selectDropdownByText(vesselFlagDropDown, vesselFlag);
	}

	public void selectAirlineFlag(String airlineFlag) {
		selectDropdownByText(airlineFlagDropDown, airlineFlag);
	}

	public void selectLogisticsType(String logisticsType) {
		selectDropdownByText(logisticsTypeDropDown, logisticsType);
	}

	public void selectWarehouseName(String warehouseName) {
		selectDropdownByText(warehouseNameDropDown, warehouseName);
	}

	public void selectNotifyParty(String notifyParty) {
		selectDropdownByText(notifyPartyDropDown, notifyParty);
	}

	public void selectBroker(String broker) {
		selectDropdownByText(brokerDropDown, broker);
	}

	public void selectLFR(String lfr) {
		selectDropdownByText(lfrDropDown, lfr);
	}

	public void selectFreightManager(String freightManager) {
		selectDropdownByText(freightManagerDropDown, freightManager);
	}

	public void selectLogistics(String logistics) {
		selectDropdownByText(logisticsDropDown, logistics);
	}

	public void selectCustoms(String customs) {
		selectDropdownByText(customsDropDown, customs);
	}

	public void selectVatProcedure(String vatProcedure) {
		selectDropdownByText(vatProcedureDropDown, vatProcedure);
	}

	public void selectTruckingCo(String truckingCo) {
		selectDropdownByText(truckingCoDropDown, truckingCo);
	}

	public void selectFreightBook(String freightBook) {
		selectDropdownByText(freightBookDropDown, freightBook);
	}

	public void selectAdditionalParty(String additionalParty) {
		selectDropdownByText(additionalPartyDropDown, additionalParty);
	}

	public void selectAdjustOperator(String adjustOperator) {
		selectDropdownByText(adjustOperatorDropDown, adjustOperator);
	}

	public void selectCustomDocStatus(String customDocStatus) {
		selectDropdownByText(customDocStatusDropDown, customDocStatus);
	}

	public void selectCustomsClearanceServices(String customsClearance) {
		selectDropdownByText(customsClearanceDropDown, customsClearance);
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



	public void scrollToElement() {
		executor.executeScript("arguments[0].scrollIntoView(true);", carrierCompanyDropDown);
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

	public void enterDelivery(String text) {
		deliveryField.sendKeys(text);
	}

	public void enterVesselName(String text) {
		vesselNameField.sendKeys(text);
	}

	public void enterServVoyage(String text) {
		servVoyageField.sendKeys(text);
	}

	public void enterIMONo(String text) {
		imoNoField.sendKeys(text);
	}

	public void enterAirFlightNo(String text) {
		airFlightNoField.sendKeys(text);
	}

	public void enterPreviousDocumentNumber(String text) {
		previousDocumentNumberField.sendKeys(text);
	}

	public void enterInvoiceNo(String text) {
		invoiceNoField.sendKeys(text);
	}

	public void enterInvoiceValueInEUR(String text) {
		invoiceValueInEURField.sendKeys(text);
	}

	public void enterPinCode(String text) {
		pinCodeField.sendKeys(text);
	}

	public void enterAirportHandlingFee(String text) {
		airportHandlingFee.sendKeys(text);
	}

	public void enterArrivalStorageFee(String text) {
		arrivalStorageFee.sendKeys(text);
	}

	public void enterGasMeasurementCharge(String text) {
		gasMeasurementCharge.sendKeys(text);
	}

	public void enterFreightPurchaseUsdFee(String text) {
		freightPurchaseUsdFee.sendKeys(text);
	}

	public void enterDeliveryCharges(String text) {
		deliveryCharges.sendKeys(text);
	}

	public void enterVatEurFee(String text) {
		vatEurFee.sendKeys(text);
	}

	public void enterFreightCharge(String text) {
		freightCharge.sendKeys(text);
	}

	public void enterFreightSaleUsdFee(String text) {
		freightSaleUsdFee.sendKeys(text);
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
