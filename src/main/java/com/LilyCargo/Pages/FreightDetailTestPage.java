package com.LilyCargo.Pages;

import java.time.Duration;
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

	//	 ------------------------------------------------------------------------------------------------------------------------------------------------


	public boolean isEditFreightIconDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(editFreightIconDP)).isDisplayed();
	}

	public void clickOnEditFreightIconDP() {
		wait.until(ExpectedConditions.visibilityOf(editFreightIconDP)).click();
	}

	public void clickOnAlertPopupDP() {
		wait.until(ExpectedConditions.visibilityOf(alertPopupDP)).click();
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

}
