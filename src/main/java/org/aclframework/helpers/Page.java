/*
 * @author Sampad Rout
 * (C) Copyright 2019 by Accion Labs Inc.
 */

package org.aclframework.helpers;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {

    WebDriver driver;

    public void clickElement(WebElement element) {
        element.click();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void enterText(WebElement element, String value) {
        element.sendKeys(value);
    }

    public boolean checkElement(WebElement element) {
        return element.isDisplayed();
    }

}
