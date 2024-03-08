package com.epam.qavn.pages;

import com.epam.qavn.core.AbstractPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class GettingStartedPage extends AbstractPage {

    private AppiumDriver driver;
    private By gettingStartedTitle = AppiumBy.xpath("//android.view.View[@text='Getting Started']");

    public GettingStartedPage(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Verify Getting Started Page is displayed")
    public boolean isGettingStartedPageDisplayed() {
        return findElementBy(driver, gettingStartedTitle).isDisplayed();
    }

}
