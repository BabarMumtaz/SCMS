package com.LilyCargo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IntrastatsTestPage {

	WebDriver driver;

	public IntrastatsTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	@CacheLookup
	@FindBy(xpath = "//h2[text()='Intrastats']")
	WebElement intrastatsHeading;

	@CacheLookup
	@FindBy(className = "logout")
	WebElement logoutButton;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Create Freight']")
	WebElement CreateFreight;

	@CacheLookup
	@FindBy(xpath = "//input[@name='FNO']")
	WebElement FNO;

	@CacheLookup
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

	public void enterFNO(String text) {
		// Click on date picker
		FNO.sendKeys(text);
	}

	public void selectDate(String date) {
		// Click on date picker
		ETDdatePicker.click();
	}

}
