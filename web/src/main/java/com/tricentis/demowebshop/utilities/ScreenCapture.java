package com.tricentis.demowebshop.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCapture {
    public static byte[] takeScreenShot(WebDriver driver) {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }
}
