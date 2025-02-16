package com.LilyCargo.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;
import java.util.List;
import java.util.Arrays;

import com.LilyCargo.Pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LilyCargo.Listeners.WebEventListener;
import com.LilyCargo.Util.TestUtilClass;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static Logger log = LogManager.getLogger(TestBaseClass.class);
	public static JavascriptExecutor js;
	public static Faker faker;
	private static WebDriverWait wait;

	// Page Object references
	public static LoginTestPage loginPage;
	public static MenuBarTestPage menuBar;
	public static FreightTestPage bookedFreights;
	public static FreightListingTestPage freightListing;
	public static FreightDetailTestPage freightDetail;
	public static CarriersTestPage carriersPage;
	public static CarrierListingTestPage carrierListing;
	public static ClientTestPage clientPage;
	public static ShipperTestPage shippersPage;
	public static RemarksTestPage remarksPage;
	public static IncidentsRegistrationTestPage incidentsRegistrationPage;
	public static FycoDataTestPage fycoDataPage;
	public static BillingCenterTestPage billingCenterPage;
	public static CargoDataTestPage cargoDataPage;

	public TestBaseClass() {
		if (prop == null) {
			loadProperties();
		}
	}

	private void loadProperties() {
		String configPath = System.getProperty("user.dir") + "/src/main/java/com/LilyCargo/Config/configFile.properties";
		try (FileInputStream ip = new FileInputStream(configPath)) {
			prop = new Properties();
			prop.load(ip);
			log.info("Configuration properties loaded successfully.");
		} catch (IOException e) {
			log.error("Error loading configuration file: " + configPath, e);
			throw new RuntimeException("Failed to load configuration properties.");
		}
	}

	public static void initialization() {
		if (driver != null) {
			log.warn("Driver already initialized. Skipping reinitialization.");
			return;
		}

		log = LogManager.getLogger(TestBaseClass.class);
		String browserName = prop.getProperty("browser", "chrome").toLowerCase();

		try {
			switch (browserName) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					log.info("Chrome Driver initiated.");
					break;
				case "firefox":
				case "ff":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					log.info("Firefox Driver initiated.");
					break;
				default:
					log.error("Unsupported browser: " + browserName);
					throw new IllegalArgumentException("Unsupported browser: " + browserName);
			}

			driver.get(prop.getProperty("url"));
			log.info("Navigated to URL: " + prop.getProperty("url"));

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtilClass.PAGE_LOAD_TIMEOUT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtilClass.IMPLICIT_WAIT));

			log.info("Browser initialized.");

			eventListener = new WebEventListener();
			driver = new EventFiringDecorator<>(eventListener).decorate(driver);

			js = (JavascriptExecutor) driver;
			faker = new Faker(new Locale.Builder().setLanguage("nl").build());
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Initialize Page Objects with Debug Logs
			try {
				log.info("Initializing Page Objects...");
				loginPage = PageFactory.initElements(driver, LoginTestPage.class);
				log.info("LoginTestPage initialized.");
/*				menuBar = PageFactory.initElements(driver, MenuBarTestPage.class);
				log.info("MenuBarTestPage initialized.");
				bookedFreights = PageFactory.initElements(driver, FreightTestPage.class);
				log.info("FreightTestPage initialized.");
				freightListing = PageFactory.initElements(driver, FreightListingTestPage.class);
				log.info("FreightListingTestPage initialized.");
				freightDetail = PageFactory.initElements(driver, FreightDetailTestPage.class);
				log.info("FreightDetailTestPage initialized.");
				carriersPage = PageFactory.initElements(driver, CarriersTestPage.class);
				log.info("CarriersTestPage initialized.");
				carrierListing = PageFactory.initElements(driver, CarrierListingTestPage.class);
				log.info("CarrierListingTestPage initialized.");
				clientPage = PageFactory.initElements(driver, ClientTestPage.class);
				log.info("ClientTestPage initialized.");
				shippersPage = PageFactory.initElements(driver, ShipperTestPage.class);
				log.info("ShipperTestPage initialized.");
				remarksPage = PageFactory.initElements(driver, RemarksTestPage.class);
				log.info("RemarksTestPage initialized.");
				incidentsRegistrationPage = PageFactory.initElements(driver, IncidentsRegistrationTestPage.class);
				log.info("IncidentsRegistrationTestPage initialized.");
				fycoDataPage = PageFactory.initElements(driver, FycoDataTestPage.class);
				log.info("FycoDataTestPage initialized.");
				billingCenterPage = PageFactory.initElements(driver, BillingCenterTestPage.class);
				log.info("BillingCenterTestPage initialized.");
				cargoDataPage = PageFactory.initElements(driver, CargoDataTestPage.class);
				log.info("CargoDataTestPage initialized.");
				log.info("All Page Objects initialized successfully.");*/
			} catch (Exception e) {
				log.error("Error initializing Page Objects", e);
				throw new RuntimeException("Page Object initialization failed", e);
			}
		} catch (Exception e) {
			log.error("Error during browser initialization", e);
			throw new RuntimeException("Browser initialization failed", e);
		}
	}
}


