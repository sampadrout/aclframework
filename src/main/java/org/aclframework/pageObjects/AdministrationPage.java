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

public class AdministrationPage extends Page {

    @FindBy(linkText = "Service Pros")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement linkServicePros;

    @FindBy(xpath = "//a[contains(text(), 'Items')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement linkItems;

    @FindBy(xpath = "//a[contains(text(), 'Brands')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement linkBrands;

    @FindBy(xpath = "//a[contains(text(), 'Job Cancel')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement linkJobCancel;

    @FindBy(xpath = "//a[contains(text(), 'Job Reassignment')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement linkJobReassignment;

    @FindBy(xpath = "//a[contains(text(), 'Job Reschedule')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement linkJobReschedule;

    @FindBy(xpath = "//a[contains(text(), 'Estimate Reject')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement linkEstimateReject;

    WebDriver driver;

    public AdministrationPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public void goToLink(String linkName) {
        if (linkName.equals("Service Pros")) {
            clickElement(linkServicePros);
        } else if (linkName.equals("Items")) {
            clickElement(linkItems);
        } else if (linkName.equals("Brands")) {
            clickElement(linkBrands);
        } else if (linkName.equals("Job Cancel")) {
            clickElement(linkJobCancel);
        } else if (linkName.equals("Job Reassignment")) {
            clickElement(linkJobReassignment);
        } else if (linkName.equals("Job Reschedule")) {
            clickElement(linkJobReschedule);
        } else {
            clickElement(linkEstimateReject);
        }
    }
}
