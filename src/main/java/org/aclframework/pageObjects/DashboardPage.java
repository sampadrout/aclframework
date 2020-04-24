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
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,  \"Today's Jobs\")]")
    @iOSXCUITFindBy()
    private WebElement todayJobTab;

    @FindBy(xpath = "//span[contains(text(), 'Wrong username or password.')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, \"Your ID or Password didn't match.\")]")
    @iOSXCUITFindBy()
    private WebElement loginErrorMessage;

    WebDriver driver;

    public DashboardPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public boolean verifyTodayJobTabDisplayed() throws Exception {
        Thread.sleep(20000);
        return checkElement(todayJobTab);
    }

    public boolean verifyLoginErrorMessage() throws Exception {
        Thread.sleep(20000);
        return checkElement(loginErrorMessage);
    }
}
