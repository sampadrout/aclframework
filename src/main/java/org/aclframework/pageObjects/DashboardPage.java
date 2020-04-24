package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.aclframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.aclframework.logger.LoggingManager.logMessage;

public class DashboardPage extends Page {

    @FindBy(xpath = "//div[contains(@class, 'mx-dataview-content')]/div/div/h5[contains(text(), 'Logged into: Agent')]")
    @AndroidFindBy(xpath = "Sign out")
    @iOSXCUITFindBy()
    private MobileElement eleAgentLoginText;

    @FindBy(xpath = "//span[contains(text(), 'Wrong username or password.')]")
    @AndroidFindBy(xpath = "Your ID or Password didn't match. Please try again.")
    @iOSXCUITFindBy()
    private MobileElement loginErrorMessage;

    WebDriver driver;

    public DashboardPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public boolean verifyDashboardPageDisplayed() throws Exception {
        Thread.sleep(10000);
        return checkElement(eleAgentLoginText);
    }

    public boolean verifyloginErrorMessage() throws Exception {
        Thread.sleep(10000);
        return checkElement(loginErrorMessage);
    }
}
