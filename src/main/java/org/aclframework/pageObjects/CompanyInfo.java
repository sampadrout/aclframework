package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.aclframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static org.aclframework.logger.LoggingManager.logMessage;

public class CompanyInfo extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Company Details')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleCompanyDetailsTabTitle;

    @FindBy(xpath = "//label[contains(text(),'Type Of Ownership')]/following::div[contains(@class, 'mx-compound-control')]/select")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleTypeOfOwnership;

    @FindBy(xpath = "//button[text()='Save and Continue']")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleSaveAndContinueBtn;

    WebDriver driver;

    public CompanyInfo(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public boolean verifyCompanyDetailsTabDisplayed() throws Exception {
        Thread.sleep(10000);
        return checkElement(eleCompanyDetailsTabTitle);
    }

    public void enterCompanyDetails(Map<String, String> testdata) throws InterruptedException {
        Thread.sleep(10000);
        enterText(eleTypeOfOwnership, testdata.get("typeeofownership"));
        Thread.sleep(5000);
        clickElement(eleSaveAndContinueBtn);
        Thread.sleep(5000);
    }
}