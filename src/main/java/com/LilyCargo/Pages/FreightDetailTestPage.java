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
	@FindBy(xpath = "//button[text()='Submit Mrn #']")
	WebElement submitMRN;

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
		log.info("Scrolling to the Submit MRN button...");
		wait.until(ExpectedConditions.visibilityOf(submitMRN)); // Ensure visibility
		executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitMRN);
		wait.until(ExpectedConditions.elementToBeClickable(submitMRN));
		log.info("Scrolled to Submit MRN button.");
	}

	public void clickSubmitMrnNo() {
		wait.until(ExpectedConditions.elementToBeClickable(submitMRN)).click();
		log.info("Clicked on Submit MRN button.");
	}
}
