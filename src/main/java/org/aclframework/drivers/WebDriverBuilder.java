/*
 * @author Sampad Rout
 * (C) Copyright 2019 by Accion Labs Inc.
 */

package org.aclframework.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aclframework.config.DeviceConfig;
import org.aclframework.enums.PlatformName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverBuilder extends DeviceConfig {

    WebDriver driver;

    public WebDriver setupDriver(String platformName) {
        if (platformName.equalsIgnoreCase(PlatformName.CHROME.name())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (platformName.equalsIgnoreCase(PlatformName.FIREFOX.name())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        setExecutionPlatform(platformName);
        return driver;
    }

}
