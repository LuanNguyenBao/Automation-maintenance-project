package com.epam.qavn.core;

import com.epam.qavn.core.driverManager.AndroidDriverManager;
import com.epam.qavn.core.driverManager.DriverManager;
import com.epam.qavn.core.driverManager.IOSDriverManager;
import com.epam.qavn.exception.UnknownPlatformException;
import com.epam.qavn.objects.DeviceInformation;
import com.epam.qavn.utils.JsonReader;
import com.google.gson.JsonObject;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;

public class DriverFactory {

    private final ThreadLocal<AppiumDriver> threadDriver;
    private String deviceSourcePath = "devices.json";
    private String unknownPlatformMessage = "Unknown Platform! please use ANDROID or IOS only";
    private Platform platform;
    private Logger logger;

    public DriverFactory() {
        threadDriver = new ThreadLocal<>();
        logger = LogManager.getLogger();
    }

    public void setDriver(String deviceName) throws UnknownPlatformException {
        JsonObject jsonInfo = JsonReader.getInstance().getFromResource(deviceSourcePath, deviceName);
        DeviceInformation deviceInfo = new DeviceInformation(jsonInfo);
        DriverManager driverManager;
        try {
            platform = Platform.valueOf(deviceInfo.getPlatformName().toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new UnknownPlatformException(unknownPlatformMessage);
        }
        switch (platform) {
            case ANDROID:
                driverManager = new AndroidDriverManager();
                break;
            case IOS:
                driverManager = new IOSDriverManager();
                break;
            default:
                logger.error(unknownPlatformMessage);
                throw new UnknownPlatformException(unknownPlatformMessage);
        }
        threadDriver.set(driverManager.getDriver(deviceInfo));
    }

    public AppiumDriver getDriver() {
        return threadDriver.get();
    }

    public void removeDriver() {
        getDriver().quit();
        threadDriver.remove();
        logger.info("Quit driver session and remove thread variable");
    }
}
