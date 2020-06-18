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

public class ServiceRequestPage extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Service Requests')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleServiceRequestsPageTitle;

    WebDriver driver;

    public ServiceRequestPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public boolean verifyServiceRequestPageDisplayed() throws Exception {
        Thread.sleep(10000);
        return checkElement(eleServiceRequestsPageTitle);
    }
}