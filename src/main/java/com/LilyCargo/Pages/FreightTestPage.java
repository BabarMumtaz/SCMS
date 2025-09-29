package com.LilyCargo.Pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.LilyCargo.Util.DropdownMethodUtil;
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
	DropdownMethodUtil dropdownUtil;
	Logger log = LogManager.getLogger(FreightTestPage.class);

	/** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

	public FreightTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
		this.dropdownUtil = new DropdownMethodUtil(driver, wait);
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

	@FindBy(xpath = "//label[text()='Client Reference']/following-sibling::div//input")
	WebElement clientReference;

	@FindBy(xpath = "//label[contains(text(), 'Service Type')]/following::div[@role='button'][1]")
	WebElement serviceTypeDropDown;

	@FindBy(xpath = "//label[contains(normalize-space(.), 'Shipper')]/following-sibling::div//input")
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

	@FindBy(xpath = "//label[contains(normalize-space(.), 'Export Company')]/following-sibling::div//input")
	WebElement exportCompanyDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Freight Way')]/following::div[@role='button'][1]")
	WebElement freightWayDropDown;

	@FindBy(xpath = "//label[contains(text(), 'Vessel Flag')]//following::input[1]")
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

	@FindBy(xpath = "//label[contains(text(), 'Vessel Name')]//following::input[1]")
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

	@FindBy(xpath = "//input[@name='ATA']")
	WebElement ataDatePicker;

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

	@FindBy(xpath = "//div[@name='logistic_id']")
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

	@FindBy(xpath = "//input[@type='number']")
	WebElement fidNumber;

	@FindBy(xpath = "//span[@id='btnGroupAddon']")
	WebElement fidSearchGoButton;

	@FindBy(xpath = "//div[contains(@id,'select-NoTC ')]")
	WebElement subFidNoTcDrop;

	/** ---------- Methods ---------- */

	// Method to capture the page heading
	public String getHeading() {
		return pageHeading.getText();
	}

	public String getAddPageHeading() {
		return addPageHeading.getText();
	}

	public String getFidNumberText() {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(fidNumber));
		String fidNumberText = element.getAttribute("value");

		// fallback to placeholder if value is empty
		if (fidNumberText == null || fidNumberText.isEmpty()) {
			fidNumberText = element.getAttribute("placeholder");
		}
		return fidNumberText;
	}

	public void enterFidNumber(String text) {
		fidNumber.sendKeys(text);
	}

	public void clickSearchGoBtn() {
		fidSearchGoButton.click();
	}

	public void clickCreateFreightBtn() {
		createFreight.click();
	}

	public void enterFNO(String text) {
		fNO.sendKeys(text);
	}

	// For <input type="date">
	private void selectDate(WebElement element, LocalDate date) {
		String dateValue = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")); // required format
		element.clear();
		element.sendKeys(dateValue);
	}

	private void selectDateUsingKeys(WebElement element, String day, String month, String year) {
		actions.click(element).sendKeys(day).sendKeys(month).sendKeys(year).perform();
	}

	public void selectEtdDate() {
		selectDate(etdDatePicker, LocalDate.now());
	}

	public void selectEtaDate() {
		selectDate(etaDatePicker, LocalDate.now().plusDays(10));
	}

	public void selectCutOffDate() {
		selectDate(cutOffDateField, LocalDate.now());
	}

	public void selectCutOffTime(String time) {
		cutOffTimeField.clear();
		cutOffTimeField.sendKeys(time);
	}

	public void selectAtaDate() {
		selectDate(ataDatePicker, LocalDate.now().plusDays(10));
	}

	public void selectDeliveryDate() {
		selectDate(deliveryField, LocalDate.now().plusDays(30));
	}

	public void selectTHCInvImpDate() {
		selectDate(thcInvImpDateField, LocalDate.now().plusMonths(1));
	}

	public void selectPinExpireDate() {
		selectDate(pinExpireDateField, LocalDate.now().plusYears(1));
	}

	public void selectTruckingDate() {
		selectDate(truckingDateField, LocalDate.now().plusMonths(1));
	}

	public void selectInvoiceDate() {
		selectDate(invoiceDateField, LocalDate.now());
	}

/*	This approach works fine in all date formats like dd/mm/yyyy or dd----yyyy

	public void selectCutOffDate(String day, String month, String year) {
		selectDateUsingKeys(cutOffDateField, day, month, year);
	}

	public void selectDeliveryDate(String day, String month, String year) {
		selectDateUsingKeys(deliveryField, day, month, year);
	}

	public void selectTHCInvImpDate(String day, String month, String year) {
		selectDateUsingKeys(thcInvImpDateField, day, month, year);
	}

	public void selectPinExpireDate(String day, String month, String year) {
		selectDateUsingKeys(pinExpireDateField, day, month, year);
	}

	public void selectTruckingDate(String day, String month, String year) {
		selectDateUsingKeys(truckingDateField, day, month, year);
	}

	public void selectInvoiceDate(String day, String month, String year) {
		selectDateUsingKeys(invoiceDateField, day, month, year);
	}*/

	public void enterContainerNumber(String text) {
		containerNo.sendKeys(text);
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
		actions.click(clientReference).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		clientReference.sendKeys(text);
	}

	public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
		dropdown.click();
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
		dropdownValue.click();
	}

/*	public void selectDropdownByText(WebElement dropdownElement, String optionText) {
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click(); // open the dropdown
		log.info("🔽 Opened dropdown");
		WebElement dropdownOption = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//li[contains(text(),'" + optionText + "')]"))));
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownOption);
		dropdownOption.click();
		log.info("✅ Selected option: " + optionText);
	}*/

	public void selectClient(String client) {
		dropdownUtil.selectDropdownByText(clientDropDown, client);
	}

	public void selectServiceType(String serviceType) {
		dropdownUtil.selectDropdownByText(serviceTypeDropDown, serviceType);
	}

	public void selectShipper(String shipper) {
		dropdownUtil.selectDropdownByText(shipperDropDown, shipper);
	}

	public void selectCOO(String coo) {
		dropdownUtil.selectDropdownByText(cOODropDown, coo);
	}

	public void selectContainerType(String containerType) {
		dropdownUtil.selectDropdownByText(containerDropDown, containerType);
	}

	public void selectPortOfLoading(String portOfLoading) {
		dropdownUtil.selectDropdownByText(portOfLoadingDropDown, portOfLoading);
	}

	public void selectPortOfDischarge(String portOfDischarge) {
		dropdownUtil.selectDropdownByText(portOfDischargeDropDown, portOfDischarge);
	}

	public void selectCarrierCompany(String carrierCompany) {
		dropdownUtil.selectDropdownByText(carrierCompanyDropDown, carrierCompany);
	}

	public void selectExportCompany(String exportCompany) {
		dropdownUtil.selectDropdownByText(exportCompanyDropDown, exportCompany);
	}

	public void selectFreightWay(String freightWay) {
		dropdownUtil.selectDropdownByText(freightWayDropDown, freightWay);
	}

	public void selectVesselFlag(String vesselFlag) {
		dropdownUtil.selectDropdownByText(vesselFlagDropDown, vesselFlag);
	}

	public void selectAirlineFlag(String airlineFlag) {
		dropdownUtil.selectDropdownByText(airlineFlagDropDown, airlineFlag);
	}

	public void selectLogisticsType(String logisticsType) {
		dropdownUtil.selectDropdownByText(logisticsTypeDropDown, logisticsType);
	}

	public void selectWarehouseName(String warehouseName) {
		dropdownUtil.selectDropdownByText(warehouseNameDropDown, warehouseName);
	}

	public void selectNotifyParty(String notifyParty) {
		dropdownUtil.selectDropdownByText(notifyPartyDropDown, notifyParty);
	}

	public void selectBroker(String broker) {
		dropdownUtil.selectDropdownByText(brokerDropDown, broker);
	}

	public void selectLFR(String lfr) {
		dropdownUtil.selectDropdownByText(lfrDropDown, lfr);
	}

	public void selectFreightManager(String freightManager) {
		dropdownUtil.selectDropdownByText(freightManagerDropDown, freightManager);
	}

	public void selectLogistics(String logistics) {
		dropdownUtil.selectDropdownByText(logisticsDropDown, logistics);
	}

	public void selectCustoms(String customs) {
		dropdownUtil.selectDropdownByText(customsDropDown, customs);
	}

	public void selectVatProcedure(String vatProcedure) {
		dropdownUtil.selectDropdownByText(vatProcedureDropDown, vatProcedure);
	}

	public void selectTruckingCo(String truckingCo) {
		dropdownUtil.selectDropdownByText(truckingCoDropDown, truckingCo);
	}

	public void selectFreightBook(String freightBook) {
		dropdownUtil.selectDropdownByText(freightBookDropDown, freightBook);
	}

	public void selectAdditionalParty(String additionalParty) {
		dropdownUtil.selectDropdownByText(additionalPartyDropDown, additionalParty);
	}

	public void selectAdjustOperator(String adjustOperator) {
		dropdownUtil.selectDropdownByText(adjustOperatorDropDown, adjustOperator);
	}

	public void selectCustomDocStatus(String customDocStatus) {
		dropdownUtil.selectDropdownByText(customDocStatusDropDown, customDocStatus);
	}

	public void selectCustomsClearanceServices(String customsClearance) {
		dropdownUtil.selectDropdownByText(customsClearanceDropDown, customsClearance);
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

	public void enterVesselName(String text) {
		vesselNameField.sendKeys(text);
	}

	public void enterServVoyage(String text) {
		servVoyageField.sendKeys(text);
	}

	public void enterImoNo(String text) {
		imoNoField.sendKeys(text);
	}

	public void enterAirFlightNo(String text) {
		airFlightNoField.sendKeys(text);
	}

	public void enterPreviousDocumentNumber(String text) {
		actions.click(previousDocumentNumberField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		previousDocumentNumberField.sendKeys(text);
	}

	public void enterInvoiceNo(String text) {
		actions.click(invoiceNoField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		invoiceNoField.sendKeys(text);
	}

	public void enterInvoiceValueInEUR(String text) {
		actions.click(invoiceValueInEURField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		invoiceValueInEURField.sendKeys(text);
	}

	public void enterPinCode(String text) {
		actions.click(pinCodeField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		pinCodeField.sendKeys(text);
	}

	public void enterAirportHandlingFee(String text) {
		actions.click(airportHandlingFee).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		airportHandlingFee.sendKeys(text);
	}

	public void enterArrivalStorageFee(String text) {
		actions.click(arrivalStorageFee).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		arrivalStorageFee.sendKeys(text);
	}

	public void enterGasMeasurementCharge(String text) {
		actions.click(gasMeasurementCharge).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		gasMeasurementCharge.sendKeys(text);
	}

	public void enterFreightPurchaseUsdFee(String text) {
		freightPurchaseUsdFee.sendKeys(text);
	}

	public void enterDeliveryCharges(String text) {
		actions.click(deliveryCharges).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		deliveryCharges.sendKeys(text);
	}

	public void enterVatEurFee(String text) {
		actions.click(vatEurFee).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
		vatEurFee.sendKeys(text);
	}

	public void enterFreightCharge(String text) {
		actions.click(freightCharge).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
				.perform();
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

	public void selectSubFidNoTc(String noTcValue) {
		dropdownUtil.selectDropdownByText(subFidNoTcDrop, noTcValue);
	}
}
