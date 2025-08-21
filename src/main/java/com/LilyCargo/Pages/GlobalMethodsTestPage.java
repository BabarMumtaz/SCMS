package com.LilyCargo.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class GlobalMethodsTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    WebDriverWait wait;
    Actions actions;
    Logger log = LogManager.getLogger(GlobalMethodsTestPage.class);

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */
    public GlobalMethodsTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    /** ---------- Locators ---------- */

    @FindBy(css = ".d-inline.main-title")
    WebElement mainPageHeading;

    @FindBy(xpath = "//h5[1]")
    WebElement addPageHeading;

    @FindBy(xpath = "//button[starts-with(text(), 'Add')]")
    WebElement addButtonXpath;

    @FindBy(id = "select-Gender")
    WebElement userGenderDropDown;

    @FindBy(xpath = "//table[@id='grid']/tbody/tr")
    List<WebElement> listingRows;

    @FindBy(xpath = "//table[@id='grid']/tbody/tr[1]/td[1]")
    WebElement firstCellLV;

    @FindBy(xpath = "//img[@alt='View']")
    WebElement viewIcon;

    @FindBy(xpath = "//img[@alt='Edit']")
    WebElement editIcon;

    @FindBy(xpath = "//p[text()='Edit']")
    WebElement editBtn;

    @FindBy(xpath = "//img[@alt='Download']")
    WebElement exportIcon;

    @FindBy(xpath = "//img[@alt='filter']")
    WebElement filterIcon;

    @FindBy(xpath = "//div[text()='Apply filter']")
    WebElement filterSidePanelHeading;

    @FindBy(xpath = "//input[@name='Inactive']")
    WebElement inactiveCheckbox;

    @FindBy(xpath = "//input[@name='blocked']")
    WebElement blockedCheckbox;

    @FindBy(xpath = "//button[text()='Apply']")
    WebElement filterApplyBtn;

    @FindBy(xpath = "//button[text()='Reset']")
    WebElement filterResetBtn;

    @FindBy(xpath = "//table//tr/td[last()]")
    List<WebElement> statusColumnElements;

    @FindBy(xpath = "//table//tr[1]/td[last()]")
    WebElement statusColumnFirstRow;


    @FindBy(xpath = "//label[text()='Export Company']/following::div[@role='button']")
    WebElement exportCompanyDropDown;

    @FindBy(xpath = "//label[text()='Country']/following::div[@role='button']")
    WebElement countryDropDown;

    @FindBy(xpath = "//label[text()='Region']/following::div[@role='button']")
    WebElement regionDropDown;

    @FindBy(xpath = "//label[text()='LFR']/following::div[@role='button']")
    WebElement lfrDropDown;

    @FindBy(id = "select-Status")
    WebElement userStatusDropDown;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])")
    List<WebElement> extraFieldCrossIcon;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraEmailFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[12]")
    WebElement extraAddressFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[13]")
    WebElement extraPhoneFieldCross;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveAndBackBtn;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveAndNewBtn;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement alertPopupListingPage;

    @FindBy(xpath = "//div[contains(text(),'successfully ')]")
    WebElement alertPopupText;


    /** ---------- Methods ---------- */

    public String getMainPageHeadingText() {
        return wait.until(ExpectedConditions.visibilityOf(mainPageHeading)).getText().trim();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButtonXpath)).click();
    }

    public String getAddPageHeading() {
        return addPageHeading.getText();
    }

    // ===== 2. Generic Dynamic Heading Method =====
    /**
     * Get the heading text for a given page.
     * Supports both h2 tag heading.
     * @param headingText Visible heading text on the page.
     * @return The heading WebElement.
     */
    private WebElement getPageHeading(String headingText) {
        String headingXpath = String.format("//h2[text()='%s']", headingText);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(headingXpath)));
    }

    /**
     * Get the heading text for verification.
     * @param headingText The expected heading text.
     * @return The actual heading text.
     */
    public String getPageHeadingText(String headingText) {
        return getPageHeading(headingText).getText();
    }

    // Generic method to hover over a row and click the requested icon (view/edit)
    public void hoverAndClickIconOnRow(int rowIndex, String action) {
        WebElement row = listingRows.get(rowIndex);
        row.click();
        actions.moveToElement(row).perform();
        log.info("🖱️ Hovered on row index: " + rowIndex);

        String iconTitle = action.equalsIgnoreCase("view") ? "View" : "Edit";
        try {
            //WebElement icon = row.findElement(By.cssSelector("button[title='" + iconTitle + "']"));
            WebElement icon = row.findElement(By.xpath("//img[@alt='" + iconTitle + "']"));
            wait.until(ExpectedConditions.elementToBeClickable(icon)).click();
            log.info("✅ Clicked " + iconTitle + " icon on row index: " + rowIndex);
        } catch (Exception e) {
            log.error("❌ Failed to click '" + iconTitle + "' icon on row " + rowIndex, e);
        }
    }

    public void hoverOnListing1stRow() {
        wait.until(ExpectedConditions.visibilityOf(firstCellLV));
        firstCellLV.click();
        actions.moveToElement(firstCellLV).perform();

    }

    public void clickOnViewIcon() {
        wait.until(ExpectedConditions.visibilityOf(viewIcon)).click();
    }

    public void clickOnEditIcon() {
        wait.until(ExpectedConditions.visibilityOf(editIcon)).click();
    }

    public void clickOnEditBtn() {
        editBtn.click();
    }

    public boolean isViewPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(editBtn)).isDisplayed();
    }

    public String getFilterSidePanelHeading() {
        return filterSidePanelHeading.getText();
    }

    public boolean isFilterSidePanelHeading() {
        return wait.until(ExpectedConditions.visibilityOf(filterSidePanelHeading)).isDisplayed();
    }

    public void applyStatusFilter(String status) {
        wait.until(ExpectedConditions.elementToBeClickable(filterIcon)).click();
        WebElement statusOption = driver.findElement(By.xpath("//span[text()='Show "+status+" items']"));
        wait.until(ExpectedConditions.elementToBeClickable(statusOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(filterApplyBtn)).click();

        log.info("🔍 Applied filter for status: " + status);
    }

    /**
     * Checks if all visible status entries match the expected filter status.
     * @param expectedStatus The expected status: "Active", "Inactive", or "Blocked"
     * @return true if all rows match the expected status
     */
    public boolean isAllRowsMatchingStatus(String expectedStatus) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(statusColumnElements));
        Thread.sleep(1000);
        for (WebElement statusElement : statusColumnElements) {
            String actualStatus = statusElement.getText().trim();
            if (!actualStatus.equalsIgnoreCase(expectedStatus)) {
                log.warn("❌ Status mismatch found: Expected = " + expectedStatus + ", Found = " + actualStatus);
                return false;
            }
        }

        log.info("✅ All listed records have status: " + expectedStatus);
        return true;
    }

    // ===== 2. Generic Success Alert Method ===== Finds a success alert message containing the given text.
    public WebElement getSuccessAlertElement(String alertText) {
        String alertXpath = String.format("//div[contains(text(),'%s')]", alertText);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(alertXpath)));
    }

    //Gets the text of a success alert.
    public String getSuccessAlertText(String alertText) {
        return getSuccessAlertElement(alertText).getText();
    }

     // Checks if a success alert is displayed.
    public boolean isSuccessAlertDisplayed(String alertText) {
        try {
            return getSuccessAlertElement(alertText).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // ===== Generic Success Alert Method ===== Gets the text of the success alert automatically.
    public String getAlertPopupText() {
/*        wait.until(ExpectedConditions.textToBePresentInElement(alertPopupText, "successfully"));
        return alertPopupText.getText().trim();*/
        return wait.until(ExpectedConditions.visibilityOf(alertPopupText)).getText().trim();
    }

    // Checks if a success alert is displayed.
    public boolean isSuccessAlertDisplayedNew() {
        try {
            return alertPopupText.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

/*    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }*/


    public void selectDropdownOption(WebElement dropdown, String optionText) {
        try {
            // Click to open the dropdown
            wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
            log.info("🔽 Opened dropdown");

/*            // Build XPath dynamically based on visible text  String optionXPath = "//li[text()='" + optionText + "']";
            String optionXPath = "//li[contains(text(),'" + optionText + "')]";
            WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXPath)));

            executor.executeScript("arguments[0].scrollIntoView(true);", optionElement);

            // Click the desired option
            optionElement.click();*/

            WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(text(),'" + optionText + "')]"))));
            executor.executeScript("arguments[0].scrollIntoView(true);", dropdownOption);
            dropdownOption.click();

            log.info("✅ Selected option: " + optionText);
        } catch (Exception e) {
            log.warn("⚠️ Could not select option '" + optionText + "' from dropdown: " + e.getMessage());
        }
    }

    // Method for Status dropdown
    public void selectStatus(String status) {
        selectDropdownOption(userStatusDropDown, status);
    }

    public void selectGender(String gender) {
        selectDropdownOption(userGenderDropDown, gender);
    }

    public void selectCountryName(String country) {
        selectDropdownOption(countryDropDown, country);
    }

    public void selectRegion(String region) {
        selectDropdownOption(regionDropDown, region);
    }

    public void selectExportCompany(String exportCompany) {
        selectDropdownOption(exportCompanyDropDown, exportCompany);
    }

    public void selectLfr(String lfr) {
        selectDropdownOption(lfrDropDown, lfr);
    }

    public void clickExtraEmailFieldCross() {
        extraEmailFieldCross.click();
    }

    public void clickExtraAddressFieldCross() {
        wait.until(ExpectedConditions.visibilityOf(extraAddressFieldCross)).click();
    }

    public void clickExtraPhoneFieldCross() {
        wait.until(ExpectedConditions.visibilityOf(extraPhoneFieldCross)).click();
    }

    public void clickSaveAndBackBtn() {
        saveAndBackBtn.click();
    }

    public void clickSaveAndNewBtn() {
        saveAndNewBtn.click();
    }

    public void clickOnAlertPopupLP() {
        wait.until(ExpectedConditions.visibilityOf(alertPopupListingPage)).click();
    }

    public void clickAllDynamicCrossIcons() {
        for (int i = 0; i < 3; i++) {
            if (extraFieldCrossIcon.size() > 10) {
                extraFieldCrossIcon.get(10).click();

                // Wait for DOM update
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            } else {
                break; // Safety break if index 10 doesn't exist
            }
        }
    }

    // Switch to a new tab
    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}