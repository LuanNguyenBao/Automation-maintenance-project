package com.epam.qavn.pages;

import com.epam.qavn.core.AbstractPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.epam.qavn.constant.CONFIG.*;


public class WebviewPage extends AbstractPage {

    private final AppiumDriver driver;

    private By menuWebview = AppiumBy.accessibilityId("Webview");
    private By btnGetStarted = AppiumBy.accessibilityId("Get Started");

    private By logo = AppiumBy.xpath("//android.view.View[@content-desc='WebdriverIO']/android.view.View/android.widget.Image");

    public WebviewPage(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Tap menu Webview")
    public WebviewPage tapWebviewMenu() {
        tapCenterOf(driver, findElementBy(driver, menuWebview), Duration.ofMillis(SHORT_PRESS_TIME));
        waitUntilElementVisible(driver, logo, Duration.ofMillis(PAGE_LOAD_TIME));
        return this;
    }

    @Step("Scroll down a bit")
    public WebviewPage scrollDownABit() {
        scrollDown(driver, Duration.ofMillis(SHORT_DRAG_DROP_TIME));
        return this;
    }

    @Step("Tap button Getting Started")
    public GettingStartedPage tapGettingStartedButton() {
        waitUntilElementClickable(driver, findElementBy(driver, btnGetStarted), Duration.ofMillis(PAGE_LOAD_TIME));
        tapCenterOf(driver, findElementBy(driver, btnGetStarted), Duration.ofMillis(SHORT_PRESS_TIME));
        return new GettingStartedPage(driver);
    }

}
