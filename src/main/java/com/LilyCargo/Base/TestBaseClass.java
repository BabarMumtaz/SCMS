package com.LilyCargo.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
import com.LilyCargo.Pages.LoginTestPage;
import com.LilyCargo.Pages.MenuBarTestPage;
import com.LilyCargo.Pages.FreightTestPage;
import com.LilyCargo.Pages.FreightListingTestPage;
import com.LilyCargo.Pages.FreightDetailTestPage;
import com.LilyCargo.Util.TestUtilClass;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static Logger log;
	public static JavascriptExecutor js;
	public static Faker faker;
	private static WebDriverWait wait;

	// Page Object references
	public static LoginTestPage loginPage;
	public static MenuBarTestPage menuBar;
	public static FreightTestPage bookedFreights;
	public static FreightListingTestPage freightListing;
	public static FreightDetailTestPage freightDetail;

	public TestBaseClass() {
		loadProperties();
	}

	private void loadProperties() {
		try (FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\Config\\configFile.properties")) {
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			log.error("Configuration file not found.", e);
		} catch (IOException e) {
			log.error("Error loading configuration file.", e);
		}
	}

	public static void initialization() {
		setupLogger();
		setupBrowser();
		configureDriver();
		initializeUtilitiesAndPages();
	}

	private static void setupLogger() {
		log = LogManager.getLogger(TestBaseClass.class);
	}

	private static void setupBrowser() {
		String browserName = prop.getProperty("browser", "chrome").toLowerCase();

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
	}

	private static void configureDriver() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtilClass.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtilClass.IMPLICIT_WAIT));

		eventListener = new WebEventListener();
		driver = new EventFiringDecorator<>(eventListener).decorate(driver);
	}

	private static void initializeUtilitiesAndPages() {
		js = (JavascriptExecutor) driver;
		faker = new Faker();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		loginPage = PageFactory.initElements(driver, LoginTestPage.class);
		menuBar = PageFactory.initElements(driver, MenuBarTestPage.class);
		bookedFreights = PageFactory.initElements(driver, FreightTestPage.class);
		freightListing = PageFactory.initElements(driver, FreightListingTestPage.class);
		freightDetail = PageFactory.initElements(driver, FreightDetailTestPage.class);

		log.info("Utilities and Page Objects initialized.");
	}

	public static WebDriverWait getWait() {
		return wait;
	}
}
