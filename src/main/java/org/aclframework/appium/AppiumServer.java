package org.aclframework.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.*;
import java.io.IOException;

import static org.aclframework.logger.LoggingManager.logMessage;

public class AppiumServer {

    public static AppiumDriverLocalService appium;

    File appiumLogDir = new File(System.getProperty("user.dir") + "/appiumlogs");
    appiumLogDir.
    if (!appiumLogDir.exists()) {
        appiumLogDir.mkdir();
    }

    File logFile = new File(appiumLogDir, "appiumLogs.txt");
    if (logFile.exists()) {
        logFile.delete();
    }

    public static void start() throws IOException {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(System.getProperty("user.dir") + "/appiumlogs/appiumLogs.txt"));

        appium = builder.build();
        appium.start();
        logMessage("Appium server has been started");
    }

    public static void stop() throws IOException {
        appium.stop();
        logMessage("Appium server has been stopped");
    }
}