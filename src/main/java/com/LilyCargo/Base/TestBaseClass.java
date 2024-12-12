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

import com.LilyCargo.Listeners.WebEventListener;
import com.LilyCargo.Pages.LoginTestPage;
import com.LilyCargo.Pages.MenuBarTestPage;
import com.LilyCargo.Pages.FreightTestPage;
import com.LilyCargo.Pages.FreightListingTestPage;
import com.LilyCargo.Pages.FreightDetailTestPage;
import com.LilyCargo.Util.TestUtilClass;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static Logger log;
	public static JavascriptExecutor js;
	public static Faker faker;
	WebDriverWait wait;

	// Page Object references
	public static LoginTestPage loginPage;
	public static MenuBarTestPage menuBar;
	public static FreightTestPage bookedFreights;
	public static FreightListingTestPage freightListing;
	public static FreightDetailTestPage freightDetail;

	public TestBaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\Config\\configFile.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		log = LogManager.getLogger(TestBaseClass.class);

		String browserName = prop.getProperty("browser");

		if ("chrome".equalsIgnoreCase(browserName)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Initiated Chrome Driver");
		} else if ("firefox".equalsIgnoreCase(browserName) || "FF".equalsIgnoreCase(browserName)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Initiated Firefox Driver");
		} else {
			log.error("Browser not supported: " + browserName);
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}

		driver.get(prop.getProperty("url"));
		log.info("Opened URL in the browser");

		// Create the event listener
		eventListener = new WebEventListener();

		// Decorate the WebDriver with the event listener using EventFiringDecorator
		// with generics
		driver = new EventFiringDecorator<WebDriver>(eventListener).decorate(driver);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtilClass.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtilClass.IMPLICIT_WAIT));

		// Initialize common utilities
		js = (JavascriptExecutor) driver;
		faker = new Faker();

		// Initialize Page Objects
		loginPage = PageFactory.initElements(driver, LoginTestPage.class);
		menuBar = PageFactory.initElements(driver, MenuBarTestPage.class);
		bookedFreights = PageFactory.initElements(driver, FreightTestPage.class);
		freightListing = PageFactory.initElements(driver, FreightListingTestPage.class);
		freightDetail = PageFactory.initElements(driver, FreightDetailTestPage.class);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
}
