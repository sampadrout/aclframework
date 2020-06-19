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

public class Availability extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Availability')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleAvailabilityTabTitle;

    @FindBy(xpath = "//a[text()='Bulk Edit']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleBulkEditLink;

    @FindBy(xpath = "//h4[contains(text(),'Bulk Edit')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleBulkEditDlg;

    @FindBy(xpath = "//option[contains(text(), 'Time Slot')]/parent::select")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleTimeSlotDropdown;

    @FindBy(xpath = "//span[contains(text(), '{value}}')]/parent::div/div/input")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleDayChkBox;

    @FindBy(xpath = "//label[contains(text(),'Capacity')]/parent::div/div/input")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleCapacityEdit;

    @FindBy(xpath = "//button[text()='Apply Rule']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleApplyRuleBtn;

    @FindBy(xpath = "//button[text()='Confirm and Save']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleConfirmAndSaveBtn;

    @FindBy(xpath = "//p[contains(text(),'Onboarding complete.')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleOnboardingCompleteText;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleOKBtn;

    WebDriver driver;

    public Availability(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public boolean verifyAvailabilityTabDisplayed() throws Exception {
        Thread.sleep(10000);
        return checkElement(eleAvailabilityTabTitle);
    }

    public boolean verifyBulkEditDlgDisplayed() throws Exception {
        Thread.sleep(10000);
        return checkElement(eleBulkEditDlg);
    }

    public boolean verifyOnboardingCompleteTextDisplayed() throws Exception {
        Thread.sleep(10000);
        return checkElement(eleOnboardingCompleteText);
    }

    public void enterAvailabilityDetails() throws InterruptedException, Exception {
        Thread.sleep(5000);
        clickElement(eleBulkEditLink);
        Thread.sleep(5000);
        enterText(eleTimeSlotDropdown, "4 Hour");
        Thread.sleep(5000);
        clickElement("//span[contains(text(), '{value}')]/parent::div[contains(@class,'ClickableContainer')]","Monday", driver);
        Thread.sleep(2000);
        clickElement("//span[contains(text(), '{value}')]/parent::div[contains(@class,'ClickableContainer')]","Tuesday", driver);
        Thread.sleep(2000);
        clickElement("//span[contains(text(), '{value}')]/parent::div[contains(@class,'ClickableContainer')]","Wednesday", driver);
        Thread.sleep(2000);
        clickElement("//span[contains(text(), '{value}')]/parent::div[contains(@class,'ClickableContainer')]","Thursday", driver);
        Thread.sleep(2000);
        clickElement("//span[contains(text(), '{value}')]/parent::div[contains(@class,'ClickableContainer')]","Friday", driver);
        Thread.sleep(2000);
        clickElement("//span[contains(text(), '{value}')]/parent::div[contains(@class,'ClickableContainer')]","Saturday", driver);
        Thread.sleep(2000);
        clickElement("//span[contains(text(), '{value}')]/parent::div[contains(@class,'ClickableContainer')]","Sunday", driver);
        Thread.sleep(2000);
        clickElement("//span[contains(text(), '{value}')]/parent::div[contains(@class,'ClickableContainer')]","8am - 12pm", driver);
        Thread.sleep(2000);
        clickElement("//span[contains(text(), '{value}')]/parent::div[contains(@class,'ClickableContainer')]","12pm - 4pm", driver);
        Thread.sleep(2000);
        clickElement("//span[contains(text(), '{value}')]/parent::div[contains(@class,'ClickableContainer')]","4pm - 8pm", driver);
        Thread.sleep(5000);
        enterText(eleCapacityEdit, "10");
        clickElement(eleApplyRuleBtn);
        Thread.sleep(5000);
        clickElement(eleConfirmAndSaveBtn);
        Thread.sleep(5000);
        clickElement(eleOKBtn);
        Thread.sleep(5000);
    }
}