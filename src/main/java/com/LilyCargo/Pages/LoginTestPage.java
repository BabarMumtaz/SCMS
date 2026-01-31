package com.LilyCargo.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestPage {

	WebDriver driver;
	WebDriverWait wait;

    public LoginTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

	// Web elements
	@CacheLookup
	@FindBy(xpath = "//input[@id='mui-1']")
	WebElement usernameInput;

	@CacheLookup
	@FindBy(xpath = "//input[@id='mui-2']")
	WebElement passwordInput;

	@CacheLookup
	@FindBy(css = "button[type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//p[text()='These credentials do not match our records.']")
	WebElement errorMessage;

	@FindBy(className = "logout")
	WebElement logoutButton;

	@FindBy(xpath = "//h2[text()='Cockpit']")
	WebElement landingPageHeading;

// ------------------------------------------------------------------------------------------------------------------------------------------------------------//

	// Login method
	public void login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
	}

	// Logout method
	public void logout() {
		wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
	}

	// Check login success
	public boolean isLoginSuccessful() {
		return wait.until(ExpectedConditions.visibilityOf(landingPageHeading)).isDisplayed();
	}

	// Check login failure
	public boolean isLoginFailed() {
		return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
	}

	// Get error message text
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
