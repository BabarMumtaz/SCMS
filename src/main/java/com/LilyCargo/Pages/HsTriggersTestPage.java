package com.LilyCargo.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HsTriggersTestPage{

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */
    public HsTriggersTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//button[text()='CBAM HS']")
    WebElement cbamHsTab;

    @FindBy(xpath = "//button[text()='EUDR HS']")
    WebElement eudrHsTab;

    @FindBy(xpath = "//button[text()='MADB HS']")
    WebElement madbHsTab;

    @FindBy(xpath = "//button[text()='N851 HS']")
    WebElement n851HsTab;

    @FindBy(xpath = "//button[text()='OTHER HS']")
    WebElement otherHsTab;

    @FindBy(xpath = "//input[@name='hs_code']")
    WebElement hsCodeField;

    @FindBy(xpath = "//input[@name='a30_duty_percent']")
    WebElement a30DutyPercentField;

    @FindBy(xpath = "//input[@name='a35_duty_percent']")
    WebElement a35DutyPercentField;

    @FindBy(xpath = "//input[@name='other1']")
    WebElement other1Field;

    @FindBy(xpath = "//input[@name='other2']")
    WebElement other2Field;

    @FindBy(xpath = "//label[starts-with(text(), 'Remarks')]/following::input[1]")
    WebElement RemarksField;


    @FindBy(xpath = "//input[@name='direct_default_value']")
    WebElement directDefaultValueField;

    @FindBy(xpath = "//input[@name='indirect_default_value']")
    WebElement indirectDefaultValueField;

    @FindBy(xpath = "//input[@name='average_value']")
    WebElement averageValueField;


    @FindBy(xpath = "//input[@name='heading']")
    WebElement headingField;

    @FindBy(xpath = "//input[@name='sub_heading']")
    WebElement subHeadingField;

    @FindBy(xpath = "//input[@name='type_of_docs_needed']")
    WebElement typeOfDocsNeededField;


    @FindBy(xpath = "//input[@name='cn_eur_kg']")
    WebElement cnEurKgField;

    @FindBy(xpath = "//input[@name='in_eur_kg']")
    WebElement inEurKgField;

    @FindBy(xpath = "//input[@name='vn_eur_kg']")
    WebElement vnEurKgField;

    @FindBy(xpath = "//input[@name='id_eur_kg']")
    WebElement idEurKgField;

    @FindBy(xpath = "//input[@name='world_eur_kg']")
    WebElement worldEurKgField;


    @FindBy(xpath = "//input[@name='ny_code']")
    WebElement nyCodeField;

    @FindBy(xpath = "//input[@name='description']")
    WebElement descriptionField;

    @FindBy(xpath = "//input[@name='botanic_name']")
    WebElement botanicNameField;

    @FindBy(xpath = "//input[@name='remarks2']")
    WebElement remarks2Field;


    @FindBy(xpath = "//input[@name='note1']")
    WebElement note1Field;

    @FindBy(xpath = "//input[@name='note2']")
    WebElement note2Field;


    /** ---------- Methods ---------- */

    public void clickCbamHsTab() {
        wait.until(ExpectedConditions.visibilityOf(cbamHsTab)).click();
    }

    public void clickEudrHsTab() {
        wait.until(ExpectedConditions.visibilityOf(eudrHsTab)).click();
    }

    public void clickMadbHsTab() {
        wait.until(ExpectedConditions.visibilityOf(madbHsTab)).click();
    }

    public void clickN851HsTab() {
        wait.until(ExpectedConditions.visibilityOf(n851HsTab)).click();
    }

    public void clickOtherHsTab() {
        wait.until(ExpectedConditions.visibilityOf(otherHsTab)).click();
    }

    public void enterHsCode(String text) {
        wait.until(ExpectedConditions.visibilityOf(hsCodeField)).sendKeys(text);
    }

    public void enterA30DutyPercent(String text) {
        a30DutyPercentField.sendKeys(text);
    }

    public void enterA35DutyPercent(String text) {
        a35DutyPercentField.sendKeys(text);
    }

    public void enterOther1(String text) {
        other1Field.sendKeys(text);
    }

    public void enterOther2(String text) {
        other2Field.sendKeys(text);
    }

    public void enterRemarks(String text) {
        RemarksField.sendKeys(text);
    }


    public void enterDirectDefaultValue(String text) {
        directDefaultValueField.sendKeys(text);
    }

    public void enterIndirectDefaultValue(String text) {
        indirectDefaultValueField.sendKeys(text);
    }

    public void enterAverageValue(String text) {
        averageValueField.sendKeys(text);
    }


    public void enterHeading(String text) {
        headingField.sendKeys(text);
    }

    public void enterSubHeading(String text) {
        subHeadingField.sendKeys(text);
    }

    public void enterTypeOfDocsNeeded(String text) {
        typeOfDocsNeededField.sendKeys(text);
    }


    public void enterCnEurKg(String text) {
        wait.until(ExpectedConditions.visibilityOf(cnEurKgField)).sendKeys(text);
    }

    public void enterInEurKg(String text) {
        wait.until(ExpectedConditions.visibilityOf(inEurKgField)).sendKeys(text);
    }

    public void enterVnEurKg(String text) {
        wait.until(ExpectedConditions.visibilityOf(vnEurKgField)).sendKeys(text);
    }

    public void enterIdEurKg(String text) {
        wait.until(ExpectedConditions.visibilityOf(idEurKgField)).sendKeys(text);
    }

    public void enterWorldEurKg(String text) {
        wait.until(ExpectedConditions.visibilityOf(worldEurKgField)).sendKeys(text);
    }


    public void enterNyCode(String text) {
        wait.until(ExpectedConditions.visibilityOf(nyCodeField)).sendKeys(text);
    }

    public void enterDescription(String text) {
        descriptionField.sendKeys(text);
    }

    public void enterBotanicName(String text) {
        botanicNameField.sendKeys(text);
    }

    public void enterRemarks2(String text) {
        remarks2Field.sendKeys(text);
    }

    public void enterNote1(String text) {
        note1Field.sendKeys(text);
    }

    public void enterNote2(String text) {
        note2Field.sendKeys(text);
    }

}
