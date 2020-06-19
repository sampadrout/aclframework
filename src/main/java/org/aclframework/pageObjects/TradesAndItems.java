package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.aclframework.helpers.Page;
import org.aclframework.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static org.aclframework.logger.LoggingManager.logMessage;

public class TradesAndItems extends  Page {

    @FindBy(xpath = "//h1[contains(text(),'Trades, Items, & Brands')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleTradeAndItemsTabTitle;

    @FindBy(xpath = "//div[contains(@class, 'ClickableContainer')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement selectAppliance;

    @FindBy(xpath = "(//h2[contains(@class, 'mx-groupbox-header')])[2]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement expandItemAppliance;

    @FindBy(xpath = "//span[contain(text(), 'Cooktop - Electric')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement selectItemName;

    @FindBy(xpath = "(//h2[contains(text(), 'Appliance')])[2]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement expandBrandAppliance;

    @FindBy(xpath = "//span[contains(text(), 'Haier')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement selectBrandName;

    @FindBy(xpath = "//button[text()='Continue']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleContinue;

    @FindBy(xpath = "//button[text()='Save and Continue']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleSaveAndContinueBtn;

    WebDriver driver;
    WaitUtils waitUtils;

    public TradesAndItems(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public boolean verifyTradeAndItemsTabTitleDisplayed() throws Exception {
        Thread.sleep(10000);
        return checkElement(eleTradeAndItemsTabTitle);
    }

    public void enterTradeAndItemsDetails() throws InterruptedException {
        Thread.sleep(5000);
        clickElement(selectAppliance);
        Thread.sleep(10000);
        clickElement(eleContinue);
        Thread.sleep(10000);
        clickElement(eleSaveAndContinueBtn);
        Thread.sleep(10000);
        clickElement(eleSaveAndContinueBtn);
        Thread.sleep(10000);
        clickElement(eleSaveAndContinueBtn);
        Thread.sleep(10000);
    }
}