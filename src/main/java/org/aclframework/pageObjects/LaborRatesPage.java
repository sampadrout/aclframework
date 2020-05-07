package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.aclframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.aclframework.logger.LoggingManager.logMessage;

public class LaborRatesPage extends Page {

    @FindBy(xpath = "(//div[contains(@class, 'nav-tab-bar')]/div/div/button)[4]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement tabLaborRates;

    @FindBy(xpath = "//h2[contains(text(), 'Appliance')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement expandAppliance;

    @FindBy(xpath = "(//select[contains(@class, 'form-control')])[1]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement selectLaborType;

    @FindBy(xpath = "(//div[contains(@class, 'mx-layoutgrid')]/div/div/div[contains(@class, 'mx-textbox')]/input)[1]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement enterLaborRate;

    @FindBy(xpath = "(//div[contains(@class, 'mx-layoutgrid')]/div/div/div[contains(@class, 'mx-textbox')]/input)[2]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement enterDiagnosticFee;

    @FindBy(xpath = "(//div[contains(@class, 'mx-layoutgrid')]/div/div/div[contains(@class, 'mx-textbox')]/input)[3]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement enterLeadFee;

    @FindBy(xpath = "(//div[contains(@class, 'mx-layoutgrid')]/div/div/div[contains(@class, 'mx-textbox')]/input)[4]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement enterLoadPercentage;

    @FindBy(xpath = "//button[contains(@class, 'btn-success')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleSave;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleOK;

    WebDriver driver;

    public LaborRatesPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public void gotoLaborRatesTab() throws InterruptedException {
        Thread.sleep(15000);
        clickElement(tabLaborRates);
    }

    public void enterLaborRatesDetails() throws InterruptedException {
        Thread.sleep(30000);
        clickElement(expandAppliance);
        Thread.sleep(2000);
        enterText(selectLaborType, "Flat Rate");
        Thread.sleep(10000);
        enterText(enterLaborRate, "100");
        Thread.sleep(10000);
        enterText(enterDiagnosticFee, "60");
        Thread.sleep(10000);
        enterText(enterLeadFee, "25");
        Thread.sleep(10000);
        enterText(enterLoadPercentage, "10");
        Thread.sleep(10000);
        clickElement(eleSave);
        Thread.sleep(5000);
        clickElement(eleOK);
        Thread.sleep(5000);
    }
}
