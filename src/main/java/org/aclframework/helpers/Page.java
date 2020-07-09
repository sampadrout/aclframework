package org.aclframework.helpers;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.*;

import static java.time.Duration.ofSeconds;

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

    public static void verticalScroll(WebDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int start_Y = (int) (size.getHeight() * 0.75);
        int end_Y = (int) (size.getHeight() * 0.10);
        int start_end_X = (int) (size.getWidth() * 0.50);

        TouchAction swipe = new TouchAction((PerformsTouchActions) driver).press(PointOption.point(start_end_X, start_Y))
                .waitAction(waitOptions(ofSeconds(2)))
                .moveTo(PointOption.point(start_end_X, end_Y)).release().perform();
    }

    public void tapElementAt(WebElement element, double xPct, double yPct, WebDriver driver) {
        Rectangle elRect = element.getRect();
        int xPoint = elRect.x + (int)(elRect.getWidth() * xPct);
        int yPoint = elRect.y + (int)(elRect.getHeight() * yPct);

        TouchAction tapAtPoint = new TouchAction((PerformsTouchActions) driver)
                .tap(tapOptions().withElement(element(element, xPoint, yPoint))).perform();
    }
}
