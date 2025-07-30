package com.LilyCargo.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static com.LilyCargo.Base.TestBaseClass.log;

public class ClientTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the
    // class is created
    public ClientTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//h2[text()='Clients']")
    WebElement clientPageHeading;

    @FindBy(xpath = "//button[text()='Add Client']")
    WebElement addClientBtn;

    @FindBy(xpath = "//h5[text()='Client']")
    WebElement clientAddPageHeading;

    @FindBy(xpath = "//input[@name='name']")
    WebElement clientName;

    @FindBy(xpath = "//input[@name='contactPerson']")
    WebElement contactPerson;

    @FindBy(xpath = "//input[@name='address1']")
    WebElement clientAddress1;

    @FindBy(xpath = "//input[@name='address2']")
    WebElement clientAddress2;

    @FindBy(xpath = "//input[@name='email1']")
    WebElement clientEmail1;

    @FindBy(xpath = "//input[@name='financeEmail']")
    WebElement clientFinancialEmail;

    @FindBy(xpath = "//input[@name='exportEmail']")
    WebElement clientFiscalMattersEmail1;

    @FindBy(xpath = "//input[@name='ceoEmail']")
    WebElement clientCeoEmail1;

    @FindBy(xpath = "//input[@name='tel']")
    WebElement clientTelephoneNumber1;

    @FindBy(xpath = "//input[@name='tel2']")
    WebElement clientTelephoneNumber2;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement regionDropDown;

    @FindBy(xpath = "//li[text()='nl']")
    WebElement regionDropDownValue;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[2]")
    WebElement countryDropDown;

    @FindBy(xpath = "//li[contains(.,'UNITED KINGDOM')]")
    WebElement countryDropDownValue;

    @FindBy(xpath = "//input[@name='zipCity']")
    WebElement clientZipCity;

    @FindBy(xpath = "//input[@name='vat']")
    WebElement clientVat;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[3]")
    WebElement clientLfrDropDown;

    @FindBy(xpath = "//li[contains(.,'NL LMLOG Fiscal Rep (Import)')]")
    WebElement clientLfrDropDownValue;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraEmailFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraAddressFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraPhoneFieldCross;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveClientBack;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveClientNew;

    @FindBy(xpath = "//button[text()='Duplicate']")
    WebElement duplicateClient;

    @FindBy(xpath = "//div[contains(text(),'Client successfully created.')]")
    WebElement addClientSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Client successfully updated.')]")
    WebElement updateClientSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement clientAlertPopupLP;

    @FindBy(xpath = "//input[@name='scmEmails']")
    WebElement scmEmails;

    @FindBy(xpath = "//input[@name='customsReleaseEmails']")
    WebElement customsReleaseEmails;

    @FindBy(xpath = "//input[@name='billingEmails']")
    WebElement billingEmails;

    @FindBy(xpath = "//table[@id='grid']/tbody/tr")
    List<WebElement> clientRows;

    @FindBy(xpath = "//h5[text()='Client']")
    WebElement clientEditPageHeading;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    // Method to capture the page heading
    public String getPageHeading() {
        return clientPageHeading.getText();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(clientPageHeading)).isDisplayed();
    }

    public void clickAddClientBtn() {
        addClientBtn.click();
    }

    public String getAddPageHeading() {
        return clientAddPageHeading.getText();
    }

    public boolean isAddPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(clientAddPageHeading)).isDisplayed();
    }

    public void enterClientAddress1(String text) {
        clientAddress1.sendKeys(text);
    }

    public void enterClientAddress2(String text) {
        actions.click(clientAddress2).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        clientAddress2.sendKeys(text);
    }

    public void enterClientName(String text) {
        clientName.sendKeys(text);
    }

    public void updatedClientName(String text) {
        actions.click(clientName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        clientName.sendKeys(text);
    }

    public void enterContactPerson(String text) {
        contactPerson.sendKeys(text);
    }

    public void enterClientEmail1(String text) {
        clientEmail1.sendKeys(text);
    }

    public void enterClientFinancialEmail(String text) {
        clientFinancialEmail.sendKeys(text);
    }

    public void enterClientFiscalMattersEmail(String text) {
        clientFiscalMattersEmail1.sendKeys(text);
    }

    public void enterClientCeoEmail(String text) {
        clientCeoEmail1.sendKeys(text);
    }

    // Method to enter invoice number into the invoiceNumber field
    public void enterClientDutchPhoneNumber(String phoneNumber) {
        clientTelephoneNumber1.sendKeys(phoneNumber);
    }
    public void enterClientDutchPhoneNumber2(String phoneNumber) {
        clientTelephoneNumber2.sendKeys(phoneNumber);
    }

    public void enterClientZipCity(String text) {
        clientZipCity.sendKeys(text);
    }

    public void enterVat(String text) {
        clientVat.sendKeys(text);
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void selectRegion() {
        selectDropdownValue(regionDropDown, regionDropDownValue);
    }

    public void selectCountry() {
        selectDropdownValue(countryDropDown, countryDropDownValue);
    }

    public void selectLfr() {
        selectDropdownValue(clientLfrDropDown, clientLfrDropDownValue);
    }

    public void enterScmEmail(String text) {
        scmEmails.sendKeys(text);
    }

    public void enterCustomsReleaseEmail(String text) {
        customsReleaseEmails.sendKeys(text);
    }

    public void enterBillingEmail(String text) {
        billingEmails.sendKeys(text);
    }


    //--------------------------------------------------------------------------------------------

    // Method to select a dropdown value by visible text
    public void selectDropdownByText(WebElement dropdownElement, String value) {
        dropdownElement.click(); // open the dropdown
        WebElement dropdownOption = wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath("//li[contains(text(),'" + value + "')]"))));
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownOption);
        dropdownOption.click();
    }

    public void addClientData(String Name, String ContactPerson, String Address1, String Email1, String FinancialEmail,
                              String FiscalMattersEmail1, String CeoEmail1, String TelephoneNumber1, String RegionDropDown,
                              String CountryDropDown, String ZipCity, String Vat, String LfrDropDown, String ScmEmails, String CustomsReleaseEmails, String BillingEmails) {
        clientName.sendKeys(Name);
        contactPerson.sendKeys(ContactPerson);
        clientAddress1.sendKeys(Address1);
        clientEmail1.sendKeys(Email1);
        clientFinancialEmail.sendKeys(FinancialEmail);
        clientFiscalMattersEmail1.sendKeys(FiscalMattersEmail1);
        clientCeoEmail1.sendKeys(CeoEmail1);
        clientTelephoneNumber1.sendKeys(TelephoneNumber1);
        selectDropdownByText(regionDropDown, RegionDropDown);
        selectDropdownByText(countryDropDown, CountryDropDown);
        clientZipCity.sendKeys(ZipCity);
        clientVat.sendKeys(Vat);
        selectDropdownByText(clientLfrDropDown, LfrDropDown);
        clickExtraEmailFieldCross();
        clickExtraAddressFieldCross();
        clickExtraPhoneFieldCross();
        scmEmails.sendKeys(ScmEmails);
        customsReleaseEmails.sendKeys(CustomsReleaseEmails);
        billingEmails.sendKeys(BillingEmails);

        clickSaveClientBack();
    }

    //--------------------------------------------------------------------------------------------

    public void clickExtraEmailFieldCross() {
        extraEmailFieldCross.click();
    }

    public void clickExtraAddressFieldCross() {
        wait.until(ExpectedConditions.visibilityOf(extraAddressFieldCross)).click();
    }

    public void clickExtraPhoneFieldCross() {
        wait.until(ExpectedConditions.visibilityOf(extraPhoneFieldCross)).click();
    }

    public void clickSaveClientBack() {
        saveClientBack.click();
    }

    public void clickSaveClientNew() {
        saveClientNew.click();
    }

    public void clickDuplicateBtn() {
        duplicateClient.click();
    }

    public String getClientSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(addClientSuccessAlertMessage)).getText();
    }

    public boolean isClientSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addClientSuccessAlertMessage)).isDisplayed();
    }

    public boolean isUpdateClientSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(updateClientSuccessAlertMessage)).isDisplayed();
    }

    public String getUpdatedClientSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(updateClientSuccessAlertMessage)).getText();
    }

    public void clickOnAlertPopupLP() {
        wait.until(ExpectedConditions.visibilityOf(clientAlertPopupLP)).click();
    }

    // Generic method to hover over a row and click the requested icon (view/edit)
    public void hoverAndClickIconOnRow(int rowIndex, String action) {
        WebElement row = clientRows.get(rowIndex);
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

    public String getEditPageHeading() {
        return clientEditPageHeading.getText();
    }

    public boolean isEditPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(clientEditPageHeading)).isDisplayed();
    }
}
