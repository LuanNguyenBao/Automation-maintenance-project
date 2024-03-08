package com.epam.qavn.pages;

import com.epam.qavn.core.AbstractPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Random;

import static com.epam.qavn.constant.CONFIG.SHORT_DRAG_DROP_TIME;
import static com.epam.qavn.constant.CONFIG.SHORT_PRESS_TIME;

public class DragPage extends AbstractPage {
    private AppiumDriver driver;
    private final By menuDrag = AppiumBy.accessibilityId("Drag");
    private final By lstDragItems = AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'drag')]");

    public DragPage(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Tap menu Drag")
    public DragPage tapDragMenu() {
        tapCenterOf(driver, findElementBy(driver, menuDrag), Duration.ofMillis(SHORT_PRESS_TIME));
        return this;
    }

    @Step("Get random drag element")
    public WebElement getRandomDragElement() {
        Random random = new Random();
        return findElementsBy(driver, lstDragItems)
                .get(random.nextInt(findElementsBy(driver, lstDragItems).size() - 1));
    }

    @Step("Get destination of element {0}")
    public WebElement getDestinationElement(WebElement element) {
        String desLocator = getElementAttribute(element, "content-desc").replace("drag", "drop");
        return findElementBy(driver, AppiumBy.accessibilityId(desLocator));
    }

    @Step("Drag element {0} and drop to {1}")
    public DragPage dragBetweenElements(WebElement start, WebElement end) {
        dragAndDrop(driver, start, end, Duration.ofMillis(SHORT_DRAG_DROP_TIME));
        return this;
    }
}