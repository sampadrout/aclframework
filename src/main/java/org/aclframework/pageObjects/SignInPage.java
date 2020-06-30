package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.aclframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

import static org.aclframework.logger.LoggingManager.logMessage;

public class SignInPage extends Page {

    @FindBy(xpath = "//div[contains(text(), 'Cinch Home Services - Agent')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleSignInTitle;

    @FindBy(xpath = "//input[@placeholder='username/email']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleUserName;

    @FindBy(xpath = "//input[@placeholder='your password']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement elePassword;

    @FindBy(xpath = "//span[@class='auth0-label-submit']")
    @AndroidFindBy()
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

    public void signIn(List<Map<String, String>> testdatalist) throws Exception{
        for (Map<String, String> testdata: testdatalist) {
            enterText(eleUserName, testdata.get("emailaddress"));
            enterText(elePassword, testdata.get("enterpassword"));
            clickElement(eleLogInBtn);
        }
    }
}
