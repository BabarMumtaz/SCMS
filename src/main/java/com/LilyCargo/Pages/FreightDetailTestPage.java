package com.LilyCargo.Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LilyCargo.Util.WaitUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FreightDetailTestPage {

	WebDriver driver;
	JavascriptExecutor executor;
	Actions actions;
	private WaitUtil waitUtil; // Use WaitUtil instead of WebDriverWait
	Logger log = LogManager.getLogger(FreightDetailTestPage.class);

	// Constructor
	public FreightDetailTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.waitUtil = new WaitUtil(driver); // Initialize WaitUtil
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}

	@CacheLookup
	@FindBy(xpath = "//div[@class='ft-edit-wrapper'][1]" )
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

	@CacheLookup
	@FindBy(id = "jfkgabhog")
	WebElement addFreightSuccessAlertMessage;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
	WebElement successAlertCrossIcon;


	//	 ------------------------------------------------------------------------------------------------------------------------------------------------

//	public void switchToNewTab() {
//	    String originalWindow = driver.getWindowHandle(); // Store the original tab
//
//	    // Wait for the new tab to open
//	    waitUtil.waitForNumberOfWindows(2);
//
//	    // Get all open tab handles
//	    Set<String> windowHandles = driver.getWindowHandles();
//	    for (String handle : windowHandles) {
//	        if (!handle.equals(originalWindow)) {
//	            driver.switchTo().window(handle); // Switch to the new tab
//	            break;
//	        }
//	    }
//
//	    // Wait for the Freight Details page to load completely
//	    waitUtil.waitForUrlToContain("/app/transactions/freights/details/");
//
//	    // Ensure the edit icon is visible before proceeding
//	    waitUtil.isVisible(editFreightIconDP);
//
//	    System.out.println("Switched to new tab: " + driver.getCurrentUrl()); // Debugging info
//	}

	public String getSuccessAlertMessage() {
		return  waitUtil.waitForElementToBeVisible(addFreightSuccessAlertMessage).getText();
	}

	public boolean isSuccessAlertMessageDisplayed() {
		return waitUtil.waitForElementToBeVisible(addFreightSuccessAlertMessage).isDisplayed();
	}

	public void clickOnAlertPopupCrossIcon() {
		waitUtil.click(successAlertCrossIcon);
	}

	public boolean isEditFreightIconDisplayed() {
		return waitUtil.isVisible(editFreightIconDP).isDisplayed();
	}

	public void clickOnEditFreightIconDP() {
		waitUtil.click(editFreightIconDP);
	}

	public void clickOnAlertPopupDP() {
		waitUtil.click(alertPopupDP);
	}

	public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
		waitUtil.click(dropdown);
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
		waitUtil.click(dropdownValue);
	}

	public void clickSubFidAddIcon() {
		waitUtil.click(subFidAddIcon);
	}

	public String getCreateSubFidPopupHeading() {
		return waitUtil.isVisible(createSubFidPopupHeading).getText();
	}

	public boolean isCreateSubFidPopupHeadingDisplayed() {
		return waitUtil.isVisible(createSubFidPopupHeading).isDisplayed();
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
		waitUtil.click(submitSubFidButton);
	}

	public void scrollToBottom() {
		waitUtil.isVisible(submitMRNTask); // Ensure visibility
		executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitMRNTask);
	}

	public void clickSubmitMrnTask() {
		waitUtil.click(submitMRNTask);
	}

	public void clickUploadMrnButton() {
		waitUtil.click(uploadMrnButton);
	}

	public void clickSubmitMrnButton() {
		waitUtil.click(submitMrnButton);
	}

	public void clickCancelMrnButton() {
		waitUtil.click(cancelMrnButton);
	}

	public boolean isRemarksTabDisplayed() {
		return waitUtil.isVisible(remarksTab).isDisplayed();
	}
	public void clickRemarksTab() {
		waitUtil.click(remarksTab);
	}

	public boolean isIncidentsRegistrationTabDisplayed() {
		return waitUtil.isVisible(incidentsRegistrationTab).isDisplayed();
	}

	public void clickIncidentsRegistrationTab() {
		waitUtil.click(incidentsRegistrationTab);
	}

	public boolean isFycoDataTabDisplayed() {
		return waitUtil.isVisible(fycoDataTab).isDisplayed();
	}

	public void clickFycoDataTab() {
		waitUtil.click(fycoDataTab);
	}

	public boolean isBillingCenterTabDisplayed() {
		return waitUtil.isVisible(billingCenterTab).isDisplayed();
	}

	public void clickBillingCenterTab() {
		waitUtil.click(billingCenterTab);
	}

	public boolean isCargoDataTabDisplayed() {
		return waitUtil.isVisible(cargoDataTab).isDisplayed();
	}

	public void clickCargoDataTab() {
		waitUtil.click(cargoDataTab);
	}

/*	public void scrollToRight() {
		wait.until(ExpectedConditions.visibilityOf(freightTabHorizontalScroll)); // Ensure visibility
		//executor.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
		executor.executeScript("argument[0].scrollIntoView()", cargoDataTab);
		wait.until(ExpectedConditions.elementToBeClickable(cargoDataTab));
	}*/

	public void scrollToRight() {
		// Ensure the freightTabHorizontalScroll element is visible before attempting to scroll
		waitUtil.isVisible(freightTabHorizontalScroll);

		// Scroll the cargoDataTab into view
		executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", cargoDataTab);

		// Wait until the cargoDataTab is clickable
		waitUtil.click(cargoDataTab);
	}
}
