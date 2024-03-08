package com.tricentis.demowebshop.configs.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser {

    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();

        // Set options for Firefox browser
        if (Boolean.parseBoolean(System.getProperty("isHeadless", "false"))) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
        }
        options.addArguments("window-size=1920x1080");

        return new FirefoxDriver(options);
    }

}
