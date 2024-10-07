package com.LilyCargo.Listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.LilyCargo.Base.TestBaseClass;

import io.qameta.allure.Attachment;

public class AllureReportListener extends TestBaseClass implements ITestListener {

	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		try {
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		} catch (Exception e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
			return new byte[0]; // Return empty array if screenshot capture fails
		}
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("Starting Test Suite '" + iTestContext.getName() + "'.......");

		// Ensure WebDriver is available before setting it in the context
		if (driver != null) {
			iTestContext.setAttribute("WebDriver", driver);
		} else {
			System.out.println("WebDriver instance is null in onStart.");
		}
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("Finished Test Suite '" + iTestContext.getName() + "'");
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("Starting Test Method '" + getTestMethodName(iTestResult) + "'");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Test Method '" + getTestMethodName(iTestResult) + "' passed.");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Test Method '" + getTestMethodName(iTestResult) + "' failed.");

		// Ensure WebDriver is available before attempting to capture a screenshot
		if (driver != null) {
			System.out.println("Attempting to capture screenshot for test method '" + getTestMethodName(iTestResult) + "'");
			saveScreenshotPNG(driver);
		} else {
			System.out.println("WebDriver instance is null, unable to capture screenshot for test method '" + getTestMethodName(iTestResult) + "'");
		}
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("Test Method '" + getTestMethodName(iTestResult) + "' skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test Method '" + getTestMethodName(iTestResult) + "' failed but within success percentage.");
	}

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
}
