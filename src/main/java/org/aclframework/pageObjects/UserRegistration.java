package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import org.aclframework.helpers.Page;
import org.aclframework.utils.WaitUtils;

import static org.aclframework.logger.LoggingManager.logMessage;

public class UserRegistration extends Page {

    @FindBy(xpath = "//input[contains(@placeholder, 'Company ID')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleCompanyID;

    @FindBy(xpath = "//input[contains(@placeholder, 'Email Address')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleEmailAddress;

    @FindBy(xpath = "//*[@type='text' and @placeholder='First Name']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleFirstName;

    @FindBy(xpath = "//*[@type='text' and @placeholder='Last Name']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleLastName;

    @FindBy(xpath = "//*[@type='password' and @placeholder='Enter Password']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleEnterPassword;

    @FindBy(xpath = "//*[@type='password' and @placeholder='Re-Enter Password']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleReEnterPassword;

    @FindBy(xpath = "//*[@type='button']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleCreateAccount;

    @FindBy(xpath = "//h1[contains(text(), 'Account Creation Completed.')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleAccountCreationText;

    @FindBy(xpath = "/*[@type='button' and text()='Login']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleLoginBtn;

    WebDriver driver;
    WaitUtils waitUtils = new WaitUtils();

    public UserRegistration(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public void completeUserRegistration(Map<String, String> testdata) throws Exception {
        enterText(waitUtils.waitForElementToBeClickable(eleCompanyID, driver), testdata.get("companyid"));
        enterText(waitUtils.waitForElementToBeClickable(eleEmailAddress, driver), testdata.get("emailaddress"));
        enterText(waitUtils.waitForElementToBeClickable(eleFirstName, driver), testdata.get("firstname"));
        enterText(waitUtils.waitForElementToBeClickable(eleLastName, driver), testdata.get("lastname"));
        enterText(waitUtils.waitForElementToBeClickable(eleEnterPassword, driver), testdata.get("enterpassword"));
        enterText(waitUtils.waitForElementToBeClickable(eleReEnterPassword, driver), testdata.get("reenterpassword"));
        clickElement(waitUtils.waitForElementToBeClickable(eleCreateAccount, driver));
    }

    public boolean accountCreationTextDisplayed() {
        return checkElement(eleAccountCreationText);
    }

    public void navigateToSPLogin() {
        clickElement(eleLoginBtn);
    }
}