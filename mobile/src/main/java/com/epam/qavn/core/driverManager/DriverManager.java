package com.epam.qavn.core.driverManager;

import com.epam.qavn.objects.DeviceInformation;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.Logger;

public abstract class DriverManager {

    protected AppiumDriver driver;
    protected Logger logger;

    protected abstract void createDriver(DeviceInformation info);

    public AppiumDriver getDriver(DeviceInformation info) {
        if (driver == null) {
            createDriver(info);
        }
        return driver;
    }
}
