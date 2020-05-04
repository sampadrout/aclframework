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

public class DashboardPage extends Page {

    @FindBy(xpath = "//div[contains(@class, 'mx-dataview-content')]/div/div/h5[contains(text(), 'Logged into: Agent')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleAgentLoginText;

    @FindBy(xpath = "//span[contains(text(), 'Wrong username or password.')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//ul[contains(@class, 'nav navbar-nav')]/li/a[contains(text(), 'Administration')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement tabAdministration;

    @FindBy(xpath = "//ul[contains(@class, 'nav navbar-nav')]/li/a[contains(text(), 'Service Jobs')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement tabServiceJobs;

    @FindBy(xpath = "//ul[contains(@class, 'nav navbar-nav')]/li/a[contains(text(), 'Feedback')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement tabFeedback;

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

    public void navigateToTab(String tabName) {
        if (tabName.equals("Administration")) {
            clickElement(tabAdministration);
        } else if (tabName.equals("Service Jobs")) {
            clickElement(tabServiceJobs);
        } else {
            clickElement(tabFeedback);
        }
    }

}
