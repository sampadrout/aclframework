/*
 * @author Sampad Rout
 * (C) Copyright 2019 by Accion Labs Inc.
 */

package tests;

import org.aclframework.drivers.AndroidDriverBuilder;
import org.aclframework.appium.AppiumServer;
import org.aclframework.drivers.IOSDriverBuilder;
import org.aclframework.drivers.WebDriverBuilder;
import org.aclframework.enums.PlatformName;
import org.aclframework.enums.PlatformType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static org.aclframework.logger.LoggingManager.logMessage;

public class BaseTest {
    public WebDriver driver;

    @Parameters({"platformType", "platformName"})
    @BeforeTest
    public void startAppiumServer(String platformType, @Optional String platformName) throws IOException {
        if (platformType.equalsIgnoreCase(PlatformType.MOBILE.toString())) {
            killExistingAppiumProcess();
            if (AppiumServer.appium == null || !AppiumServer.appium.isRunning()) {
                AppiumServer.start();
                logMessage("Appium server has been started");
            }
        }
    }

    @Parameters({"platformType", "platformName"})
    @AfterTest
    public void stopAppiumServer(String platformType, @Optional String platformName) throws IOException {
        if (platformType.equalsIgnoreCase(PlatformType.MOBILE.toString())) {
            if (AppiumServer.appium != null || AppiumServer.appium.isRunning()) {
                AppiumServer.stop();
                logMessage("Appium server has been stopped");
            }
        }
    }

    @Parameters({"platformType", "platformName", "model"})
    @BeforeMethod
    public void setupDriver(String platformType, String platformName, @Optional String model) throws IOException {
        if (platformType.equalsIgnoreCase(PlatformType.WEB.toString())) {
            setupWebDriver(platformName);
        } else if (platformType.equalsIgnoreCase(PlatformType.MOBILE.toString())) {
            setupMobileDriver(platformName, model);
        }
    }

    public void setupMobileDriver(String platformName, String model) throws IOException {
        if (platformName.equalsIgnoreCase(PlatformName.ANDROID.toString())) {
            driver = new AndroidDriverBuilder().setupDriver(model);
        } else if (platformName.equalsIgnoreCase(PlatformName.IOS.toString())) {
            driver = new IOSDriverBuilder().setupDriver(model);
        }
        logMessage(model + " driver has been created for execution");
    }

    public void setupWebDriver(String platformName) {
        if (platformName.equalsIgnoreCase(PlatformName.CHROME.toString())) {
            driver = new WebDriverBuilder().setupDriver(platformName);
        } else if (platformName.equalsIgnoreCase(PlatformName.FIREFOX.toString())) {
            driver = new WebDriverBuilder().setupDriver(platformName);
        }
        logMessage(platformName + " driver has been created for execution");
        driver.get("https://cinchhs-agent-accp.mendixcloud.com/login.html");
    }

    @AfterMethod
    public void teardownDriver() {
        driver.quit();
        logMessage("Driver has been quit from execution");
    }

    private void killExistingAppiumProcess() throws IOException {
        Runtime.getRuntime().exec("killall node");
        logMessage("Killing existing appium process");
    }

}