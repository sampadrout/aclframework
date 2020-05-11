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

public class DashboardPage extends Page {

    @FindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, \"Today's Jobs\")]")
    @iOSXCUITFindBy()
    private WebElement todayJobTab;

    @FindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'All Jobs')]")
    @iOSXCUITFindBy()
    private WebElement allJobTab;

    @FindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Filter')]")
    @iOSXCUITFindBy()
    private WebElement filterButton;

    @FindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '{value}']")
    @iOSXCUITFindBy()
    private WebElement numberOfFilters;

    @FindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Modify Filter']")
    @iOSXCUITFindBy()
    private WebElement modifyFilterButton;

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
