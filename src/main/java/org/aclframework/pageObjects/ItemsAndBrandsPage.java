package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.aclframework.helpers.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.aclframework.logger.LoggingManager.logMessage;

public class ItemsAndBrandsPage extends Page {

    @FindBy(xpath = "(//div[contains(@class, 'nav-tab-bar')]/div/div/button)[3]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement tabItemsAndBrands;

    @FindBy(xpath = "//h2[contains(text(), 'Trades')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement expandTrades;

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

    @FindBy(xpath = "//button[contains(@class, 'btn-success')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleSave;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleOK;

    WebDriver driver;

    public ItemsAndBrandsPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public void gotoItemsAndBrandsTab() throws InterruptedException {
        Thread.sleep(15000);
        clickElement(tabItemsAndBrands);
    }

    public void enterItemsAndBrandDetails() throws InterruptedException {
        Thread.sleep(10000);
        clickElement(expandTrades);
        Thread.sleep(2000);
//        clickElement("//a[@id='{value}']", "ssoButton", driver);
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", selectAppliance);
        clickElement(selectAppliance);
        Thread.sleep(2000);
        clickElement(expandItemAppliance);
        Thread.sleep(10000);
//        clickElement(selectItemName);
        Thread.sleep(10000);
        clickElement(expandBrandAppliance);
        Thread.sleep(10000);
//        clickElement(selectBrandName);
        Thread.sleep(10000);
        clickElement(eleSave);
        Thread.sleep(10000);
        clickElement(eleOK);
        Thread.sleep(10000);
    }
}
