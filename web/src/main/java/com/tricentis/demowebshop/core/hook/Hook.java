package com.tricentis.demowebshop.core.hook;

import com.tricentis.demowebshop.configs.drivers.DriverConfig;
import com.tricentis.demowebshop.core.GlobalConstants;
import com.tricentis.demowebshop.utilities.PropertyReader;
import com.tricentis.demowebshop.utilities.ScreenCapture;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Hook {

    public static WebDriver driver = null;
    protected Logger logger;

    public Hook() {
        logger = LogManager.getLogger(getClass());
    }

    @Before
    public void setUp(Scenario scenario) {
        String browserProperty = System.getProperty("Browser");
        String browserName = (browserProperty != null) ? browserProperty : new PropertyReader(GlobalConstants.CONFIG_FILE_KEY).getValue(GlobalConstants.BROWSER_NAME).toUpperCase();

        String pageUrl = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY).getValue(GlobalConstants.PAGE_URL);

        logger.info("Running on page URL: " + pageUrl + " with browser name: " + browserName);
        scenario.attach("Identify the browser name that is run with test scenario.", "text/plain",
                "Running on browser name: " + browserName.toUpperCase());
        driver = DriverConfig.getDriver(browserName);
        driver.get(pageUrl);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(ScreenCapture.takeScreenShot(driver), "image/png", "Screenshot: " + scenario.getName());
        }
        DriverConfig.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
