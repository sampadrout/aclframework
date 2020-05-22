package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.aclframework.helpers.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import static org.aclframework.logger.LoggingManager.logMessage;

public class UserRegistration extends Page {

    WebDriver driver;

    @FindBy(xpath = "//input[contains(@placeholder, 'Company ID')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleCompanyID;

    @FindBy(xpath = "//input[contains(@placeholder, 'Email Address')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleEmailAddress;

    @FindBy(xpath = "//input[contains(@placeholder, 'First Name')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleFirstName;

    @FindBy(xpath = "//input[contains(@placeholder, 'Last Name')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleLastName;

    @FindBy(xpath = "//input[contains(@placeholder, 'Enter Password')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleEnterPassword;

    @FindBy(xpath = "//input[contains(@placeholder, 'Re-Enter Password')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleReEnterPassword;

    @FindBy(xpath = "//*[@type='button']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleCreateAccount;

    public UserRegistration(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public void completeUserRegistration(Map<String, String> testdata) throws Exception {
        enterText(eleCompanyID, testdata.get("companyid"));
        enterText(eleEmailAddress, testdata.get("emailaddress"));
        enterText(eleFirstName, testdata.get("firstname"));
        enterText(eleLastName, testdata.get("lastname"));
        enterText(eleEnterPassword, testdata.get("enterpassword"));
        enterText(eleReEnterPassword, testdata.get("reenterpassword"));
//        Thread.sleep(10000);
        clickElement(eleCreateAccount);
    }
}