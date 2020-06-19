package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.aclframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static org.aclframework.logger.LoggingManager.logMessage;

public class Coverage extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Coverage')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleCoverageTabTitle;

    @FindBy(xpath = "//label[contains(text(),'Find a State')]/following-sibling::div/span")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement dropDownState;

    @FindBy(xpath = "//input[contains(@type, 'search')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement inputSearch;

    @FindBy(xpath = "//div[contains(text(), 'California')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement searchedState;

    @FindBy(xpath = "//label[contains(text(),'Find a State')]/ancestor::div[contains(@class, 'spc_acWrap')]/button")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement addState;

    @FindBy(xpath = "//label[contains(text(),'Find a County')]/following-sibling::div/span")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement dropDownCounty;

    @FindBy(xpath = "//div[contains(text(), 'LOS ANGELES, California')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement searchedCounty;

    @FindBy(xpath = "//label[contains(text(),'Find a County')]/ancestor::div[contains(@class, 'spc_acWrap')]/button")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement addCounty;

    @FindBy(xpath = "//label[contains(text(),'Find a Zip Code')]/following-sibling::div/span")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement dropDownZipCode;

    @FindBy(xpath = "//div[contains(text(), '90503 - LOS ANGELES, California')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement searchedZipCode;

    @FindBy(xpath = "//label[contains(text(),'Find a Zip Code')]/ancestor::div[contains(@class, 'spc_acWrap')]/button")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement addZipCode;

    @FindBy(xpath = "//button[text()='Continue']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleContinue;

    @FindBy(xpath = "(//button[text()='Continue'])[2]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleContinueZipCodeSelection;

    @FindBy(xpath = "//button[text()='Save and Continue']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleSaveAndContinueBtn;

    WebDriver driver;

    public Coverage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public boolean verifyCoverageTabDisplayed() throws Exception {
        Thread.sleep(10000);
        return checkElement(eleCoverageTabTitle);
    }

    public void enterCoverageDetails() throws InterruptedException {
        Thread.sleep(5000);
        clickElement(dropDownState);
        Thread.sleep(2000);
        clickElement(inputSearch);
        Thread.sleep(2000);
        enterText(inputSearch, "California");
        Thread.sleep(2000);
        clickElement(searchedState);
        Thread.sleep(2000);
        clickElement(addState);
        Thread.sleep(5000);
        clickElement(eleContinue);
        Thread.sleep(5000);
        clickElement(dropDownCounty);
        Thread.sleep(2000);
        clickElement(inputSearch);
        Thread.sleep(2000);
        enterText(inputSearch, "Los Angeles");
        Thread.sleep(2000);
        clickElement(searchedCounty);
        Thread.sleep(2000);
        clickElement(addCounty);
        Thread.sleep(10000);
        clickElement(eleContinueZipCodeSelection);
        /*clickElement(dropDownZipCode);
        Thread.sleep(2000);
        clickElement(inputSearch);
        Thread.sleep(2000);
        enterText(inputSearch, "90503");
        Thread.sleep(2000);
        clickElement(searchedZipCode);
        Thread.sleep(2000);
        clickElement(addZipCode);*/
        Thread.sleep(10000);
        clickElement(eleSaveAndContinueBtn);
        Thread.sleep(5000);
    }
}