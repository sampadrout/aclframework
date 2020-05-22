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

import static org.aclframework.logger.LoggingManager.logMessage;

public class HomePage extends Page {

    WebDriver driver;

    @FindBy(xpath = "//a[@id='ssoButton']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleSignInBtn;

    @FindBy(xpath = "//span[@class='register-signin']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement userRegistrationLink;

    public HomePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public HomePage chooseSignInOption() throws Exception {
        clickElement(eleSignInBtn);
        return new HomePage(driver);
    }

    public HomePage chooseUserRegistration() throws Exception {
        clickElement(userRegistrationLink);
        return new HomePage(driver);
    }

}