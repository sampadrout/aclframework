package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.aclframework.helpers.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.util.Map;

import static org.aclframework.logger.LoggingManager.logMessage;

public class LaborRates extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Labor Rates')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleLaborRatesTabTitle;

    @FindBy(xpath = "(//select[contains(@class, 'form-control')])[1]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement selectLaborTypeRepair;

    @FindBy(xpath = "(//div[contains(@class, 'mx-layoutgrid')]/div/div/div[contains(@class, 'mx-textbox')]/input)[1]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement enterLaborRateRepair;

    @FindBy(xpath = "(//select[contains(@class, 'form-control')])[2]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement selectLaborTypeInstallation;

    @FindBy(xpath = "(//div[contains(@class, 'mx-layoutgrid')]/div/div/div[contains(@class, 'mx-textbox')]/input)[2]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement enterLaborRateInstallation;

    @FindBy(xpath = "(//div[contains(@class, 'mx-layoutgrid')]/div/div/div[contains(@class, 'mx-textbox')]/input)[3]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement enterDiagnosticFee;

    @FindBy(xpath = "//button[text()='Save and Continue']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleSaveAndContinueBtn;

    WebDriver driver;

    public LaborRates(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public boolean verifyLaborRatesTabDisplayed() throws Exception {
        Thread.sleep(10000);
        return checkElement(eleLaborRatesTabTitle);
    }

    public void enterLaborRatesDetails() throws InterruptedException {
        Thread.sleep(5000);
        enterText(selectLaborTypeRepair, "Flat Rate");
        Thread.sleep(10000);
        enterText(enterLaborRateRepair, "150.00", "ENTER");
        Thread.sleep(10000);
        enterText(selectLaborTypeInstallation, "Flat Rate");
        Thread.sleep(10000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='100.00';", enterLaborRateInstallation);
        enterLaborRateInstallation.sendKeys(Keys.TAB);
//        enterText(enterLaborRateInstallation, "100", "ENTER");
        Thread.sleep(10000);
        enterText(enterDiagnosticFee, "158", "ENTER");
        Thread.sleep(15000);
        clickElement(eleSaveAndContinueBtn);
        Thread.sleep(10000);
    }
}