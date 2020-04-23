package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.aclframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.aclframework.logger.LoggingManager.logMessage;

public class SignInPage extends Page {

    @FindBy(xpath = "//div[contains(text(), 'Cinch Home Services - Agent')]")
    @AndroidFindBy(tagName = "Cinch Service Pro")
    @iOSFindBy()
    private WebElement eleSignInTitle;

    @FindBy(xpath = "//input[@placeholder='username/email']")
    @AndroidFindBy(tagName = "Username")
    @iOSFindBy()
    private WebElement eleUserName;

    @FindBy(xpath = "//input[@placeholder='your password']")
    @AndroidFindBy(tagName = "Password")
    @iOSFindBy()
    private WebElement elePassword;

    @FindBy(xpath = "//span[@class='auth0-label-submit']")
    @AndroidFindBy(tagName = "Login")
    @iOSFindBy()
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
        enterText(eleUserName, username);
        enterText(elePassword, password);
        clickElement(eleLogInBtn);
    }

}
