package com.tricentis.demowebshop.configs.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {

    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Set options for Chrome browser
        if (Boolean.parseBoolean(System.getProperty("isHeadless", "false"))) {
            options.addArguments("--headless");
            options.addArguments("--disable-dev-shm-usage");
        }
        options.addArguments("--no-sandbox");
        options.addArguments("window-size=1920x1080");

        return new ChromeDriver(options);
    }
}
