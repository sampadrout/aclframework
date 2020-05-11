/*
 * @author Sampad Rout
 * (C) Copyright 2019 by Accion Labs Inc.
 */

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

public class SignInPage extends Page {

    @FindBy(xpath = "//div[contains(text(), 'Cinch Home Services - Agent')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cinch Service Pro']")
    @iOSXCUITFindBy()
    private WebElement eleSignInTitle;

    @FindBy(xpath = "//input[@placeholder='username/email']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Username']")
    @iOSXCUITFindBy()
    private WebElement eleUserName;

    @FindBy(xpath = "//input[@placeholder='your password']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Password']")
    @iOSXCUITFindBy()
    private WebElement elePassword;

    @FindBy(xpath = "//span[@class='auth0-label-submit']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Login']")
    @iOSXCUITFindBy()
    private WebElement eleLogInBtn;

    WebDriver driver;

    public SignInPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the " + this.getClass().getSimpleName() + " elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public String getTitle() throws Exception {
        return getText(eleSignInTitle);
    }

    public String verifySigninPageTitle() throws Exception {
        return new SignInPage(driver).getTitle();
    }

    public void signIn(String username, String password) throws Exception{
        clickElement(eleUserName);
        enterText(eleUserName, username);
        clickElement(elePassword);
        enterText(elePassword, password);
        clickElement(eleLogInBtn);
    }

}
