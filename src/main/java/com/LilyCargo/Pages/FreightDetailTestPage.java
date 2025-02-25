package com.LilyCargo.Pages;

import java.time.Duration;

import com.LilyCargo.Util.WaitUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FreightDetailTestPage {

	WebDriver driver;
	JavascriptExecutor executor;
	Actions actions;
	WebDriverWait wait;
	Logger log = LogManager.getLogger(FreightDetailTestPage.class);
	private WaitUtil waitUtil; // Use WaitUtil instead of WebDriverWait

	// Constructor
	public FreightDetailTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}

	@CacheLookup
	@FindBy(xpath = "(//div[@class='ft-edit-wrapper'])[1]")
	WebElement editFreightIconDP;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
	WebElement alertPopupDP;

	//-------------------------------------CREATE SUBFID ----------------------------------------------------------

	@CacheLookup
	@FindBy(className = "fid-add-btn btn btn-primary")
	WebElement subFidAddIcon;

	@CacheLookup
	@FindBy(xpath = "//div[text()='Create Sub Freight']")
	WebElement createSubFidPopupHeading;

	@CacheLookup
	@FindBy(xpath = "//input[contains(@id,'selectable-')]")
	WebElement subFidShipperDrop;

	@CacheLookup
	@FindBy(xpath = "//li[text()='Speed Arrow Logistic Service Limited']")
	WebElement subFidShipperDropValue;

	@CacheLookup
	@FindBy(xpath = "//div[contains(@id,'select-NoTC ')]")
	WebElement subFidNoTcDrop;

	@CacheLookup
	@FindBy(xpath = "//li[text()='TC1']")
	WebElement subFidNoTcDropValue;

	@CacheLookup
	@FindBy(xpath = "//input[@name='hbl_no']")
	WebElement subFidHblNo;

	@CacheLookup
	@FindBy(xpath = "//input[@name='client_ref']")
	WebElement subFidClientRef;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement submitSubFidButton;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelSubFidButton;

	@CacheLookup
	@FindBy(className = "btn-close")
	WebElement SubFidPopupCloseIcon;

	//-----------------------------------------------------------------------------------------------

	@CacheLookup
	@FindBy(xpath = "//button[text()='Submit MRN #']")
	WebElement submitMRNTask;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Upload']")
	WebElement uploadMrnButton;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitMrnButton;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelMrnButton;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Remarks']")
	WebElement remarksTab;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Incidents Registration']")
	WebElement incidentsRegistrationTab;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Fyco Data']")
	WebElement fycoDataTab;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Billing Center']")
	WebElement billingCenterTab;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Cargo Data']")
	WebElement cargoDataTab;

	@CacheLookup
	@FindBy(className = "//div[@class='MuiTabs-scroller MuiTabs-fixed css-1anid1y']")
	WebElement freightTabHorizontalScroll;

	//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	public boolean isEditFreightIconDisplayed() {
		waitUtil.waitUntilVisible(editFreightIconDP);
		return wait.until(ExpectedConditions.visibilityOf(editFreightIconDP)).isDisplayed();
	}

	public void clickOnEditFreightIconDP() {
		wait.until(ExpectedConditions.visibilityOf(editFreightIconDP)).click();
	}

	public void clickOnAlertPopupDP() {
		wait.until(ExpectedConditions.visibilityOf(alertPopupDP)).click();
	}

	public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
		dropdown.click();
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
		dropdownValue.click();
	}

	public void clickSubFidAddIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(subFidAddIcon)).click();
	}

	public String getCreateSubFidPopupHeading() {
		return createSubFidPopupHeading.getText();
	}

	public boolean isCreateSubFidPopupHeadingDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(createSubFidPopupHeading)).isDisplayed();
	}

	public void selectSubFidShipper() {
		selectDropdownValue(subFidShipperDrop, subFidShipperDropValue);
	}

	public void selectSubFidNoTc() {
		selectDropdownValue(subFidNoTcDrop, subFidNoTcDropValue);
	}

	public void enterSubFidHblNo(String text) {
		subFidHblNo.sendKeys(text);
	}

	public void enterSubFidClientRef(String text) {
		subFidClientRef.sendKeys(text);
	}

	public void clickSubmitSubFidButton() {
		wait.until(ExpectedConditions.elementToBeClickable(submitSubFidButton)).click();
	}

	public void scrollToBottom() {
		wait.until(ExpectedConditions.visibilityOf(submitMRNTask)); // Ensure visibility
		executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitMRNTask);
		wait.until(ExpectedConditions.elementToBeClickable(submitMRNTask));
	}

	public void clickSubmitMrnTask() {
		wait.until(ExpectedConditions.elementToBeClickable(submitMRNTask)).click();
	}

	public void clickUploadMrnButton() {
		wait.until(ExpectedConditions.elementToBeClickable(uploadMrnButton)).click();
	}

	public void clickSubmitMrnButton() {
		wait.until(ExpectedConditions.elementToBeClickable(submitMrnButton)).click();
	}

	public void clickCancelMrnButton() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelMrnButton)).click();
	}

	public boolean isRemarksTabDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(remarksTab)).isDisplayed();
	}
	public void clickRemarksTab() {
		wait.until(ExpectedConditions.elementToBeClickable(remarksTab)).click();
	}

	public boolean isIncidentsRegistrationTabDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(incidentsRegistrationTab)).isDisplayed();
	}

	public void clickIncidentsRegistrationTab() {
		wait.until(ExpectedConditions.elementToBeClickable(incidentsRegistrationTab)).click();
	}

	public boolean isFycoDataTabDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(fycoDataTab)).isDisplayed();
	}

	public void clickFycoDataTab() {
		wait.until(ExpectedConditions.elementToBeClickable(fycoDataTab)).click();
	}

	public boolean isBillingCenterTabDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(billingCenterTab)).isDisplayed();
	}

	public void clickBillingCenterTab() {
		wait.until(ExpectedConditions.elementToBeClickable(billingCenterTab)).click();
	}

	public boolean isCargoDataTabDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(cargoDataTab)).isDisplayed();
	}

	public void clickCargoDataTab() {
		wait.until(ExpectedConditions.elementToBeClickable(cargoDataTab)).click();
	}

/*	public void scrollToRight() {
		wait.until(ExpectedConditions.visibilityOf(freightTabHorizontalScroll)); // Ensure visibility
		//executor.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
		executor.executeScript("argument[0].scrollIntoView()", cargoDataTab);
		wait.until(ExpectedConditions.elementToBeClickable(cargoDataTab));
	}*/

	public void scrollToRight() {
		// Ensure the freightTabHorizontalScroll element is visible before attempting to scroll
		wait.until(ExpectedConditions.visibilityOf(freightTabHorizontalScroll));

		// Scroll the cargoDataTab into view
		executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", cargoDataTab);

		// Wait until the cargoDataTab is clickable
		wait.until(ExpectedConditions.elementToBeClickable(cargoDataTab));
	}
}
