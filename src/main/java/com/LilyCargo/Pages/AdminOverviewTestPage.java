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

public class AdminOverviewTestPage {
    WebDriver driver;
    JavascriptExecutor executor;
    WebDriverWait wait;
    Actions actions;
    Logger log = LogManager.getLogger(AdminOverviewTestPage.class);

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */
    public AdminOverviewTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//p[text()='User Management']")
    WebElement userManagementBtn;

    @FindBy(xpath = "//p[text()='My Profile']")
    WebElement myProfileBtn;

    @FindBy(xpath = "//button[text()='USERS']")
    WebElement userListingBtn;

    @FindBy(xpath = "//button[text()='Create User']")
    WebElement userCreateBtn;

    @FindBy(xpath = "//button[text()='Email All Active']")
    WebElement userEmailAllBtn;

    @FindBy(xpath = "//h4")
    WebElement profileSectionsHeading;

    @FindBy(xpath = "//input[@name='avatar']")
    WebElement userProfileImage;

    @FindBy(xpath = "//input[@name='name']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement userEmail;

    @FindBy(xpath = "//button[contains(text(),'Change Password')]")
    WebElement changePasswordBtn;

    @FindBy(xpath = "//input[@name='current_password']")
    WebElement userCurrentPassword;

    @FindBy(xpath = "//input[@name='password']")
    WebElement userPassword;

    @FindBy(xpath = "//input[@name='password_confirmation']")
    WebElement userConfirmPassword;

    @FindBy(xpath = "//div[@class=' css-ackcql']")
    WebElement userRolesDropDown;

    @FindBy(xpath = "//input[@name='department']")
    WebElement userDepartment;

    @FindBy(xpath = "//input[@name='designation']")
    WebElement userDesignation;

    @FindBy(xpath = "//input[@name='tel']")
    WebElement userTelephoneNumber;

    @FindBy(xpath = "//input[@name='address']")
    WebElement userAddress;

    @FindBy(xpath = "//h2[text()='Roles']")
    WebElement rolesPageHeading;

    @FindBy(xpath = "//button[text()='ROLES']")
    WebElement rolesListingBtn;

    @FindBy(xpath = "//button[text()='Create Role']")
    WebElement rolesCreateBtn;

    @FindBy(xpath = "//h5[text()='Role']")
    WebElement rolesAddPageHeading;

    @FindBy(xpath = "//input[@name='name']")
    WebElement rolesName;

    @FindBy(xpath = "//input[@name='assignAll']")
    WebElement rolesAssignAllCheckbox;

    @FindBy(xpath = "//input[@name='data[1].check']")
    WebElement rolesDashboardCheckbox;

    @FindBy(xpath = "//span[text()='Update ']")
    WebElement roleUpdatePageHeading;

    @FindBy(xpath = "//div[contains(text(),'Role successfully created.')]")
    WebElement addRoleSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Role successfully updated.')]")
    WebElement updateRoleSuccessAlertMessage;

    /** ---------- Methods ---------- */

    public void clickUserManagementBtn() {
        userManagementBtn.click();
    }

    public void clickAddUserBtn() {
        userCreateBtn.click();
    }

    public String getProfileSectionsHeadingText() {
        return wait.until(ExpectedConditions.visibilityOf(profileSectionsHeading)).getText().trim();
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

    public void enterUserCurrentPassword(String text) {
        userCurrentPassword.sendKeys(text);
    }

    public void enterUserPassword(String text) {
        userPassword.sendKeys(text);
    }

    public void enterUserConfirmPassword(String text) {
        userConfirmPassword.sendKeys(text);
    }

    public void clickChangePasswordBtn() {
        changePasswordBtn.click();
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

    /** ---------- Roles Methods ---------- */

    public void clickRoleListingBtn() {
        rolesListingBtn.click();
    }

    public String getRolePageHeading() {
        return rolesPageHeading.getText();
    }

    public boolean isRolePageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(rolesPageHeading)).isDisplayed();
    }

    public void clickAddRoleBtn() {
        rolesCreateBtn.click();
    }

    public String getRoleAddPageHeading() {
        return rolesAddPageHeading.getText();
    }

    public boolean isRoleAddPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(rolesAddPageHeading)).isDisplayed();
    }

    public void enterRoleName(String text) {
        wait.until(ExpectedConditions.visibilityOf(rolesDashboardCheckbox));
        rolesName.sendKeys(text);
    }

    public void clickRoleAssignAllCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(rolesAssignAllCheckbox)).click();
    }

    public void clickRoleDashboardCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(rolesDashboardCheckbox)).click();
    }

    public String getRoleUpdatePageHeading() {
        return roleUpdatePageHeading.getText();
    }

    public boolean isRoleUpdatePageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(roleUpdatePageHeading)).isDisplayed();
    }

    public String getRoleSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(addRoleSuccessAlertMessage)).getText();
    }

    public boolean isRoleSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addRoleSuccessAlertMessage)).isDisplayed();
    }

    public boolean isUpdateRoleSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(updateRoleSuccessAlertMessage)).isDisplayed();
    }

    public String getUpdatedRoleSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(updateRoleSuccessAlertMessage)).getText();
    }

    public void scrollToElement() {
        executor.executeScript("arguments[0].scrollIntoView(true);", rolesDashboardCheckbox);
    }


    public void clickMyProfileBtn() {
        myProfileBtn.click();
    }

    public void updateOperatorName(String text) {
        actions.click(userName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .perform();
        userName.sendKeys(text);
    }

}