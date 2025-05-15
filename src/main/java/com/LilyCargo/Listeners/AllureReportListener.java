package com.LilyCargo.Listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class AllureReportListener implements ITestListener {

	// Get the test method name
	private static String getTestMethodName(ITestResult result) {
		return result.getMethod().getMethodName();
	}

	// Attach screenshot to Allure
	@Attachment(value = "Screenshot on Failure", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Attach failure reason to Allure
	@Attachment(value = "Failure Reason", type = "text/plain")
	public String saveFailureReason(Throwable throwable) {
		return throwable == null ? "No exception message" : throwable.toString();
	}

	@Attachment(value = "Execution Log", type = "text/plain")
	public byte[] attachLogFile() {
		try {
			String logPath = System.getProperty("user.dir") + "/logs/test-log.log";
			return java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(logPath));
		} catch (Exception e) {
			return ("Unable to attach log file: " + e.getMessage()).getBytes();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("❌ Test Failed: " + getTestMethodName(result));

		// Get WebDriver from context
		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");

		if (driver != null) {
			System.out.println("📸 Capturing screenshot for: " + getTestMethodName(result));
			saveScreenshotPNG(driver);
		} else {
			System.out.println("⚠️ WebDriver is null. Cannot capture screenshot.");
		}

		// Attach exception message
		saveFailureReason(result.getThrowable());
		attachLogFile();

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("🚀 Test Started: " + getTestMethodName(result));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("✅ Test Passed: " + getTestMethodName(result));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("⏩ Test Skipped: " + getTestMethodName(result));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("📘 Test Suite Started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("📕 Test Suite Finished: " + context.getName());
	}
}
