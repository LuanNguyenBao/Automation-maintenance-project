package com.epam.qavn.core;

import com.epam.qavn.exception.UnknownPlatformException;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class AbstractTest {

    protected Logger logger = LogManager.getLogger();
    protected static AppiumDriver driver;
    private final DriverFactory driverFactory = new DriverFactory();

    @Parameters("device")
    @BeforeTest
    public void setUp(String deviceName) throws UnknownPlatformException {
        driverFactory.setDriver(deviceName);
        driver = driverFactory.getDriver();
    }

    @AfterTest
    public void tearDown() {
        driverFactory.removeDriver();
    }
}
