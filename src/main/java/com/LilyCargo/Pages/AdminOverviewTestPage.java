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

public class AdminOverviewTestPage {
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Logger log = LogManager.getLogger(AdminOverviewTestPage.class);

    // Constructor that will be automatically called as soon as the object of the
    // class is created
    public AdminOverviewTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//h4[text()='Quick Actions']")
    WebElement adminOverviewPageHeading;

    @FindBy(xpath = "//p[text()='User Management']")
    WebElement userManagementBtn;

    @FindBy(xpath = "//p[text()='My Profile']")
    WebElement myProfileBtn;

    @FindBy(xpath = "//h2[text()='Users']")
    WebElement userPageHeading;

    @FindBy(xpath = "//h2[text()='Roles']")
    WebElement rolesPageHeading;

    @FindBy(xpath = "//button[text()='USERS']")
    WebElement userListingBtn;

    @FindBy(xpath = "//button[text()='ROLES']")
    WebElement rolesListingBtn;

    @FindBy(xpath = "//button[text()='Create User']")
    WebElement userCreateBtn;

    @FindBy(xpath = "//button[text()='Email All Active']")
    WebElement userEmailAllBtn;

    @FindBy(xpath = "//h5[text()='User']")
    WebElement userAddPageHeading;

    @FindBy(xpath = "//input[@name='avatar']")
    WebElement userProfileImage;

    @FindBy(xpath = "//input[@name='name']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement userEmail;

    @FindBy(xpath = "//input[@name='password']")
    WebElement userPassword;

    @FindBy(xpath = "//input[@name='password_confirmation']")
    WebElement userConfirmPassword;

    @FindBy(xpath = "//div[@class=' css-ackcql']")
    WebElement userRolesDropDown;

    @FindBy(xpath = "//div[contains(@class, 'css-1rhbuit-multiValue')]//di[contains(text(),'\" + role + \"')]")
    WebElement userRolesDropDownOptions;

    @FindBy(id = "select-Gender")
    WebElement userGenderDropDown;

    @FindBy(xpath = "//div[@id='menu-gender']//li[contains(text(),'gender')]")
    WebElement userGenderDropDownValue;

    @FindBy(xpath = "//input[@name='department']")
    WebElement userDepartment;

    @FindBy(xpath = "//input[@name='designation']")
    WebElement userDesignation;

    @FindBy(xpath = "//input[@name='tel']")
    WebElement userTelephoneNumber;

    @FindBy(xpath = "//input[@name='address']")
    WebElement userAddress;

    @FindBy(id = "select-Status")
    WebElement userStatusDropDown;

    @FindBy(xpath = "//div[@id=\"menu-active\"]//li[contains(text(),'status')]\n")
    WebElement userStatusDropDownValue;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveUserBack;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveUserNew;

    @FindBy(xpath = "//div[contains(text(),'User successfully created.')]")
    WebElement addUserSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'User successfully updated.')]")
    WebElement updateUserSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement userAlertPopupLP;

    @FindBy(xpath = "//table[@id='grid']/tbody/tr")
    List<WebElement> userRows;

    @FindBy(xpath = "//table[@id='grid']/tbody/tr[1]/td[1]")
    WebElement userNameCellLV;

    @FindBy(xpath = "//img[@alt='View']")
    WebElement viewUserIcon;

    @FindBy(xpath = "//img[@alt='Edit']")
    WebElement editUserIcon;

    @FindBy(xpath = "//p[text()='Edit']")
    WebElement editUserBtn;

    @FindBy(xpath = "//img[@alt='Download']")
    WebElement exportIcon;

    @FindBy(xpath = "//img[@alt='filter']")
    WebElement filterIcon;

    @FindBy(xpath = "//div[text()='Apply filter']")
    WebElement userFilterSidePanelHeading;

    @FindBy(xpath = "//input[@name='Inactive']")
    WebElement userInactiveCheckbox;

    @FindBy(xpath = "//input[@name='blocked']")
    WebElement userBlockedCheckbox;

    @FindBy(xpath = "//button[text()='Apply']")
    WebElement userFilterApplyBtn;

    @FindBy(xpath = "//button[text()='Reset']")
    WebElement userFilterResetBtn;

    @FindBy(xpath = "//table//tr/td[last()]")
    List<WebElement> statusColumnElements;

    @FindBy(xpath = "//table//tr[1]/td[last()]")
    WebElement statusColumnFirstRow;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    // Method to capture the page heading
    public String getOverviewPageHeading() {
        return adminOverviewPageHeading.getText();
    }

    public boolean isAdminOverviewPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(adminOverviewPageHeading)).isDisplayed();
    }

    public void clickUserManagementBtn() {
        userManagementBtn.click();
    }

    public String getUserPageHeading() {
        return userPageHeading.getText();
    }

    public boolean isUserPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(userPageHeading)).isDisplayed();
    }

    public void clickAddUserBtn() {
        userCreateBtn.click();
    }

    public String getUserAddPageHeading() {
        return userAddPageHeading.getText();
    }

    public boolean isUserAddPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(userAddPageHeading)).isDisplayed();
    }

    public String getUserUpdatePageHeading() {
        return userAddPageHeading.getText();
    }

    public boolean isUserUpdatePageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(userAddPageHeading)).isDisplayed();
    }

    public void addUserProfileImage(String filePath) {
        userProfileImage.sendKeys(filePath);
        log.info("Uploaded A file: " + filePath);
    }

    public void enterUserName(String text) {
        userName.sendKeys(text);
    }

    public void enterUserEmail1(String text) {
        userEmail.sendKeys(text);
    }

    public void enterUserAddress(String text) {
        userAddress.sendKeys(text);
    }

/*    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        wait.until(ExpectedConditions.visibilityOf(dropdownValue)).click();
    }*/

    public void enterUserPassword(String text) {
        userPassword.sendKeys(text);
    }

    public void enterUserConfirmPassword(String text) {
        userConfirmPassword.sendKeys(text);
    }

    public void enterUserDutchPhoneNumber(String phoneNumber) {
        userTelephoneNumber.sendKeys(phoneNumber);
    }

    public void enterUserDepartment(String text) {
        userDepartment.sendKeys(text);
    }

    public void enterUserDesignation(String text) {
        userDesignation.sendKeys(text);
    }

    public void selectRolesByTyping(String... rolesToSelect) {
        // Click the Roles dropdown
        userRolesDropDown.click();
        log.info("🔽 Opened Roles dropdown");


        for (String role : rolesToSelect) {
            WebElement inputBox = driver.switchTo().activeElement();
            inputBox.sendKeys(role);
            log.info("⌨️ Typed role: " + role);
            inputBox.sendKeys(Keys.ENTER);
            log.info("✅ Selected role: " + role);
        }
    }

    public void selectDropdownOption(WebElement dropdown, String optionText) {
        try {
            // Click to open the dropdown
            wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
            log.info("🔽 Opened dropdown");

            // Build XPath dynamically based on visible text
            String optionXPath = "//li[text()='" + optionText + "']";
            WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXPath)));

            // Click the desired option
            optionElement.click();
            log.info("✅ Selected option: " + optionText);
        } catch (Exception e) {
            log.warn("⚠️ Could not select option '" + optionText + "' from dropdown: " + e.getMessage());
        }
    }

    // Method for Gender dropdown
    public void selectGender(String gender) {
        selectDropdownOption(userGenderDropDown, gender);
    }

    // Method for Status dropdown
    public void selectStatus(String status) {
        selectDropdownOption(userStatusDropDown, status);
    }

    public void clickSaveUserBack() {
        saveUserBack.click();
    }

    public void clickSaveUserNew() {
        saveUserNew.click();
    }

    public String getUserSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(addUserSuccessAlertMessage)).getText();
    }

    public boolean isUserSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addUserSuccessAlertMessage)).isDisplayed();
    }

    public boolean isUpdateUserSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(updateUserSuccessAlertMessage)).isDisplayed();
    }

    public String getUpdatedUserSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(updateUserSuccessAlertMessage)).getText();
    }

    public void clickOnAlertPopupLP() {
        wait.until(ExpectedConditions.visibilityOf(userAlertPopupLP)).click();
    }

    // Generic method to hover over a row and click the requested icon (view/edit)
    public void hoverAndClickIconOnRow(int rowIndex, String action) {
        WebElement row = userRows.get(rowIndex);
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

    public void hoverOnUser1stRow() {
        wait.until(ExpectedConditions.visibilityOf(userNameCellLV));
        userNameCellLV.click();
        actions.moveToElement(userNameCellLV).perform();

    }

    public void clickOnViewUserIcon() {
        wait.until(ExpectedConditions.visibilityOf(viewUserIcon)).click();
    }

    public void clickOnEditUserIcon() {
        wait.until(ExpectedConditions.visibilityOf(editUserIcon)).click();
    }

    public void clickOnEditUserBtn() {
        editUserBtn.click();
    }

    public boolean isUserViewPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(editUserBtn)).isDisplayed();
    }

    public String getUserFilterSidePanelHeading() {
        return userFilterSidePanelHeading.getText();
    }

    public boolean isUserFilterSidePanelHeading() {
        return wait.until(ExpectedConditions.visibilityOf(userFilterSidePanelHeading)).isDisplayed();
    }

    public void applyStatusFilter(String status) {
        wait.until(ExpectedConditions.elementToBeClickable(filterIcon)).click();
        WebElement statusOption = driver.findElement(By.xpath("//span[text()='Show "+status+" items']"));
        wait.until(ExpectedConditions.elementToBeClickable(statusOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userFilterApplyBtn)).click();

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
}