package com.epam.qavn.pages;

import com.epam.qavn.core.AbstractPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.epam.qavn.constant.CONFIG.SHORT_PRESS_TIME;

public class SwipePage extends AbstractPage {
    private AppiumDriver driver;
    private final By menuSwipe = AppiumBy.accessibilityId("Swipe");
    private final By listCards = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='card']");
    private final By firstCardIcon = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='card'])[1]/android.widget.TextView");
    private final By secondCardIcon = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='card'])[2]/android.widget.TextView");

    public SwipePage(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Tap menu Swipe")
    public SwipePage tapSwipeMenu() {
        tapCenterOf(driver, findElementBy(driver, menuSwipe), Duration.ofMillis(SHORT_PRESS_TIME));
        return this;
    }

    @Step("Get all swipe cards")
    public List<WebElement> getAllCards() {
        return findElementsBy(driver, listCards);
    }

    public WebElement getFirstCardIcon() {
        return findElementBy(driver, firstCardIcon);
    }

    public WebElement getSecondCardIcon() {
        return findElementBy(driver, secondCardIcon);
    }
}
