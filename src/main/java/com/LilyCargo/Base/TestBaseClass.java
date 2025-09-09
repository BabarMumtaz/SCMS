package com.LilyCargo.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import com.LilyCargo.Pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LilyCargo.Listeners.WebEventListener;
import com.LilyCargo.Util.TestUtilClass;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Listeners;

@Listeners({com.LilyCargo.Listeners.AllureReportListener.class})
public class TestBaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static Logger log = LogManager.getLogger(TestBaseClass.class);
	public static JavascriptExecutor js;
	public static Faker faker;
	private static WebDriverWait wait;

	public static PageObjectManager pageObjectManager;

	public TestBaseClass() {
		if (prop == null) {
			loadProperties();
		}
	}

	private void loadProperties() {
		String configPath = System.getProperty("user.dir")
				+ "/src/main/java/com/LilyCargo/Config/configFile.properties";
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
		log.info("Initializing WebDriver...");
		String browserName = prop.getProperty("browser", "chrome").toLowerCase();

		// Force WebDriverManager to work offline (cached drivers only)
		System.setProperty("wdm.offline", "true");
		System.setProperty("wdm.forceCache", "true");

		switch (browserName) {
			case "chrome":
				driver = WebDriverManager.chromedriver().create();
				log.info("Chrome Driver initiated.");
				break;

			case "firefox":
				driver = WebDriverManager.firefoxdriver().create();
				log.info("Firefox Driver initiated.");
				break;

			default:
				log.error("Unsupported browser: " + browserName);
				throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtilClass.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtilClass.IMPLICIT_WAIT));

		log.info("Browser initialized.");

		// Event listener for WebDriver logs
		eventListener = new WebEventListener();
		driver = new EventFiringDecorator<>(eventListener).decorate(driver);

		js = (JavascriptExecutor) driver;
		faker = new Faker();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
}
