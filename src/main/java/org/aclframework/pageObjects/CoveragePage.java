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

public class CoveragePage extends Page {

    @FindBy(xpath = "(//div[contains(@class, 'nav-tab-bar')]/div/div/button)[2]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement tabCoverage;

    WebDriver driver;

    public CoveragePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public void gotoCoverageTab() throws InterruptedException {
        Thread.sleep(5000);
        clickElement(tabCoverage);
    }

    public void enterCoverageDetails() throws InterruptedException {
        Thread.sleep(10000);
    }
}
