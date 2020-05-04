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

public class ServiceProsPage extends Page {

    @FindBy(xpath = "//span[contains(text(), 'Company Name')]/parent::div/div/input)[1]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleCompanyName;

    @FindBy(xpath = "(//div[contains(@class, \"mx-dataview-content\")]/button)[2]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement btnCreateNewCompany;

    WebDriver driver;

    public ServiceProsPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public void searchServicePros(String comp_name) {

    }

    public void createNewCompany() throws InterruptedException {
        Thread.sleep(5000);
        clickElement(btnCreateNewCompany);
    }
}
