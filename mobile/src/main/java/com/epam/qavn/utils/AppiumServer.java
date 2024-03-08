package com.epam.qavn.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.DEBUG_LOG_SPACING;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOG_LEVEL;


public class AppiumServer {

    private AppiumServer() {}
    private static AppiumServer instance = null;
    private static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();

    public static AppiumServer getInstance() {
        if (instance == null) {
            instance = new AppiumServer();
        }
        return instance;
    }

    public void start() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withIPAddress("0.0.0.0")
                .usingPort(4723)
                .withArgument(LOG_LEVEL, "info")
                .withArgument(DEBUG_LOG_SPACING)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                // FYI: https://github.com/appium/java-client/blob/master/docs/v7-to-v8-migration-guide.md#appiumdriverlocalservice
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/");
        service.set(AppiumDriverLocalService.buildService(builder));
        service.get().start();
    }

    public void stop() {
        service.get().stop();
    }

}
