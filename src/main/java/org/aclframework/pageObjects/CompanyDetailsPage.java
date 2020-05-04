package org.aclframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.aclframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import static org.aclframework.logger.LoggingManager.logMessage;

public class CompanyDetailsPage extends Page {

    @FindBy(xpath = "(//span[contains(text(), 'Company Name')]/parent::div/div/input)[1]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleCompanyName;

    @FindBy(xpath = "(//span[contains(text(), 'Company Name')]/parent::div/div/input)[2]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleAddress1;

    @FindBy(xpath = "(//span[contains(text(), 'Company Name')]/parent::div/div/input)[3]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleAddress12;

    @FindBy(xpath = "//span[contains(text(), 'City')]/parent::div/div/input")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleCity;

    @FindBy(xpath = "//span[contains(text(), 'State')]/parent::div/div/div/select")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleState;

    @FindBy(xpath = "(//span[contains(text(), 'Zip')]/parent::div/div/div/div/div)[1]/div/input")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleZip;

    @FindBy(xpath = "(//span[contains(text(), 'Phone')]/parent::div/div/input)[1]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement elePhone;

    @FindBy(xpath = "(//span[contains(text(), 'Email')]/parent::div/div/input)[4]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleEmail;

    @FindBy(xpath = "//span[contains(text(), 'Ranking')]/parent::div/div/div/select")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleRanking;

    @FindBy(xpath = "//span[contains(text(), 'Number of Technicians')]/parent::div/div/input")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleNoOfTechnician;

    @FindBy(xpath = "//span[contains(text(), 'Invoices allowed')]/parent::div/div/input")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleInvoicesAllowed;

    @FindBy(xpath = "//span[contains(text(), 'Service jobs allowed')]/parent::div/div/input")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleServiceJobsAllowed;

    @FindBy(xpath = "(//span[contains(text(), 'Reporting Name')]/parent::div/div/input)[1]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleReportingName;

    @FindBy(xpath = "//span[contains(text(), 'Legal Business Name')]/following-sibling::div/input")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleLegalBusinessName;

    @FindBy(xpath = "//span[contains(text(), 'Type Of Ownership')]/parent::div/div/div/select")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleTypeOfOwnership;

    @FindBy(xpath = "//span[contains(text(), 'Tax ID (SSN or EIN)')]/parent::div/div/input")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleTaxID;

    @FindBy(xpath = "//button[contains(@class, 'btn-success')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleSave;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]")
    @AndroidFindBy()
    @iOSXCUITFindBy()
    private WebElement eleOK;

    WebDriver driver;

    public CompanyDetailsPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public void enterCompanyDetails(Map<String, String> testdata) throws InterruptedException {
        Thread.sleep(10000);
        enterText(eleCompanyName, testdata.get("companyname"));
        enterText(eleAddress1, testdata.get("address1"));
        enterText(eleAddress12, testdata.get("address2"));
        enterText(eleCity, testdata.get("city"));
        enterText(eleState, testdata.get("state"));
        clickElement(eleZip);
        enterText(eleZip, testdata.get("zip"));
        clickElement(elePhone);
        enterText(elePhone, testdata.get("phone"));
        enterText(eleEmail, testdata.get("email"));
        enterText(eleRanking, testdata.get("ranking"));
        clickElement(eleInvoicesAllowed);
        clickElement(eleServiceJobsAllowed);
        enterText(eleNoOfTechnician, testdata.get("techniciannos"));
        enterText(eleReportingName, testdata.get("reporingname"));
        enterText(eleLegalBusinessName, testdata.get("legalbusinessname"));
        enterText(eleTypeOfOwnership, testdata.get("typeeofownership"));
        enterText(eleTaxID, testdata.get("taxid"));
        Thread.sleep(5000);
        clickElement(eleSave);
        Thread.sleep(5000);
        clickElement(eleOK);
    }
}
