package org.aclframework.drivers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aclframework.config.DeviceConfig;
import org.aclframework.config.IOSDeviceModel;
import org.aclframework.utils.FileUtility;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.aclframework.logger.LoggingManager.logMessage;

public class IOSDriverBuilder extends DeviceConfig {

    IOSDriver driver;

    public IOSDriver setupDriver(String model) throws IOException {
        DesiredCapabilities iosCapabilities = new DesiredCapabilities();
        IOSDeviceModel device = readIOSDeviceConfig().getIOSDeviceByName(model);
        logMessage("Received the " + model + " device configuration for execution");
        setExecutionPlatform(model);

        iosCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.getDeviceName());
        iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device.getPlatformName());
        iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device.getPlatformVersion());
        iosCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, device.getAutomationName());
        iosCapabilities.setCapability(MobileCapabilityType.UDID, device.getUdid());
        iosCapabilities.setCapability(MobileCapabilityType.NO_RESET, device.isReset());
        iosCapabilities.setCapability(MobileCapabilityType.APP, FileUtility.getFile(device.getApp()).getAbsolutePath());
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), iosCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logMessage("IOS driver has been created for the " + model + " device");
        return driver;
    }
}
