package com.tricentis.demowebshop.configs.drivers;

import com.tricentis.demowebshop.configs.browsers.BrowserName;
import com.tricentis.demowebshop.configs.browsers.ChromeBrowser;
import com.tricentis.demowebshop.configs.browsers.FirefoxBrowser;
import com.tricentis.demowebshop.core.GlobalConstants;
import com.tricentis.demowebshop.utilities.PropertyReader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverConfig {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static WebDriver driver = null;

    private DriverConfig() {
    }

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            BrowserName browserNameEnum = BrowserName.valueOf(browserName.toUpperCase());

            switch (browserNameEnum) {
                case CHROME:
                    threadDriver.set(new ChromeBrowser().getDriver());
                    break;
                case FIREFOX:
                    threadDriver.set(new FirefoxBrowser().getDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Please check the browser name again!");
            }

            threadDriver.get().manage().window().maximize();

            PropertyReader propertyReader = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY);
            threadDriver.get().manage().timeouts().implicitlyWait(Long.parseLong(propertyReader.getValue(GlobalConstants.SHORT_TIMEOUT_KEY)), TimeUnit.SECONDS);

            driver = threadDriver.get();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        threadDriver.remove();
    }
}
