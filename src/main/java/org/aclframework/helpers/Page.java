package org.aclframework.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;

public class Page {

    WebDriver driver;

    public void clickElement(MobileElement element) {
        element.click();
    }

    public String getText(MobileElement element) {
        return element.getText();
    }

    public void enterText(MobileElement element, String value) {
        element.sendKeys(value);
    }

    public boolean checkElement(MobileElement element) {
        return element.isDisplayed();
    }

}
