package org.aclframework.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {

    public void clickElement(WebElement element) {
        element.click();
    }

    public void clickElement(String locator, String val_to_be_replaced, WebDriver driver) throws Exception {
        try {
            if (val_to_be_replaced != null) {
                locator = locator.replace("{value}", val_to_be_replaced);
            }
            WebElement element = driver.findElement(By.xpath(locator));
            element.click();
        } catch (Exception e) {

        }
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void enterText(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void enterText(WebElement element, String value, String key) {
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void clearText(WebElement element) {
        element.clear();
    }

    public boolean checkElement(WebElement element) {
        return element.isDisplayed();
    }

}
