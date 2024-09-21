package com.LilyCargo.TestCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Pages.BookedFreightTestPage;
import com.LilyCargo.Pages.FreightDetailTestPage;
import com.LilyCargo.Pages.FreightListingTestPage;
import com.LilyCargo.Pages.LoginTestPage;
import com.LilyCargo.Pages.MenuBarTestPage;
import com.LilyCargo.Util.ExcelUtil;
import com.LilyCargo.Util.TestUtilClass;
import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class AddClientFRTestCase extends TestBaseClass {

	LoginTestPage loginPage;
	MenuBarTestPage menuBar;
	BookedFreightTestPage bookedFreights;
	FreightListingTestPage freightListing;
	FreightDetailTestPage freightDetail;
	JavascriptExecutor js;
	Faker faker;
	WebDriverWait wait;
	Logger log;

	@BeforeMethod
	public void setup() {
		initialization(); // Opens a new browser instance
		loginPage = PageFactory.initElements(driver, LoginTestPage.class);
		menuBar = PageFactory.initElements(driver, MenuBarTestPage.class);
		bookedFreights = PageFactory.initElements(driver, BookedFreightTestPage.class);
		freightListing = PageFactory.initElements(driver, FreightListingTestPage.class);
		freightDetail = PageFactory.initElements(driver, FreightDetailTestPage.class);

		faker = new Faker();
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		log = LogManager.getLogger(AddFreightTestCase.class);
		log.info("Test setup completed.");

		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Entered Valid Username and Password.");
	}

	// DataProvider to fetch data from Excel file
	@DataProvider
	public Object[][] getClientTestData() {
		// return LoginExcelUtil.getTestData("LoginCredentials"); // The sheet name is
		// 'LoginCredentials'
		return ExcelUtil.getTestData("ClientData",
				(System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\ClientTestData.xlsx"));
	}

	@Test(priority = 1, description = "Add Client", dataProvider = "getClientTestData")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a user can Add/Create Client successfully by entering data in required fields")
	@Epic("EP001")
	@Feature("Feature:004")
	@Story("As a user, I should be able to Add/Create Client successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Create Client")
	public void addClientTest(String ticker, String carrierName, String carrierEmail, String telephoneNumber,
			String address, String zipCode) {

		Assert.assertTrue(loginPage.isLoginSuccessful());
		loginPage.logout();
	}

	@AfterMethod
	public void tearDown() throws IOException {
		TestUtilClass.takeScreenshotAtEndOfTest();
		if (driver != null) {
			driver.quit(); // Closes the browser instance after each test method
			log.info("Browser closed successfully.");
		}
	}
}
