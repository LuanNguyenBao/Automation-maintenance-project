package com.epam.qavn.core;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static com.epam.qavn.constant.CONFIG.SHORT_TIME_OUT;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.MIDDLE;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class AbstractPage {
    private final PointerInput FINGER = new PointerInput(TOUCH, "finger");
    private Logger logger = LogManager.getLogger();

    public WebElement findElementBy(AppiumDriver driver, By by) {
        waitUntilElementVisible(driver, by, Duration.ofSeconds(SHORT_TIME_OUT));
        logger.debug("Find element by locator: " + by.toString());
        return driver.findElement(by);
    }

    public List<WebElement> findElementsBy(AppiumDriver driver, By by) {
        waitUntilElementVisible(driver, by, Duration.ofSeconds(SHORT_TIME_OUT));
        logger.debug("Find list elements by locator: " + by.toString());
        return driver.findElements(by);
    }

    public String getElementText(AppiumDriver driver, By by) {
        logger.debug("Get element text by locator: " + by.toString());
        return findElementBy(driver, by).getText();
    }

    public String getElementAttribute(WebElement element, String attribute) {
        logger.debug(String.format("Get %s attribute of element %s", attribute, element));
        return element.getAttribute(attribute);
    }

    public void inputText(AppiumDriver driver, By by, String text) {
        WebElement element = findElementBy(driver, by);
        element.clear();
        element.sendKeys(text);
        logger.debug(String.format("Input %s to element by locator: %s", text, by.toString()));
    }

    public void tapCenterOf(AppiumDriver driver, WebElement element, Duration duration) {
        Point point = getCenter(element);
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), point.getX(), point.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(FINGER, duration))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
        logger.debug("Tap on element: " + element);
    }

    public void tapByPoint(AppiumDriver driver, Point point, Duration duration) {
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), point.getX(), point.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(FINGER, duration))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
        logger.debug("Tap at point: " + point);
    }

    protected void scrollDown(AppiumDriver driver, Duration duration) {
        //Find start_y point which is at bottom side of screen.
        int start_y = driver.manage().window().getSize().height / 2;
        //Find end_y point which is at top side of screen.
        int end_y = driver.manage().window().getPosition().y;

        int x = driver.manage().window().getSize().width / 2;

        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(Duration.ofMillis(0), viewport(), x, start_y))
                .addAction(FINGER.createPointerDown(MIDDLE.asArg()))
                .addAction(FINGER.createPointerMove(duration, viewport(), x, end_y))
                .addAction(FINGER.createPointerUp(MIDDLE.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

    public void doSwipe(AppiumDriver driver, Point start, Point end, Duration duration) {
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(FINGER.createPointerMove(duration, viewport(), end.getX(), end.getY()))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
        logger.debug(String.format("Swipe from %s to %s", start, end));
    }

    public void doSwipeHorizontalFromRight(AppiumDriver driver, WebElement element, Duration duration) {
        int centerY = element.getRect().y + (element.getSize().height / 2);
        double startX = element.getRect().x + (element.getSize().width * 0.9);
        double endX = element.getRect().x + (element.getSize().width * 0.1);
        doSwipe(driver, new Point((int) startX, centerY), new Point((int) endX, centerY), duration);
        logger.debug(String.format("Swipe element %s to left", element));
    }

    public void doSwipeHorizontalFromLeft(AppiumDriver driver, WebElement element, Duration duration) {
        int centerY = element.getRect().y + (element.getSize().height / 2);
        double startX = element.getRect().x + (element.getSize().width * 0.1);
        double endX = element.getRect().x + (element.getSize().width * 0.9);
        doSwipe(driver, new Point((int) startX, centerY), new Point((int) endX, centerY), duration);
        logger.debug(String.format("Swipe element %s to right", element));
    }

    public void doSwipeVerticalFromDown(AppiumDriver driver, WebElement element, Duration duration) {
        int centerX = element.getRect().x + (element.getSize().width / 2);
        double startY = element.getRect().y + (element.getSize().height * 0.9);
        double endY = element.getRect().y + (element.getSize().height * 0.1);
        doSwipe(driver, new Point(centerX, (int) startY), new Point(centerX, (int) endY), duration);
        logger.debug(String.format("Swipe element %s to up", element));
    }

    public void doSwipeVerticalFromUp(AppiumDriver driver, WebElement element, Duration duration) {
        int centerX = element.getRect().x + (element.getSize().width / 2);
        double startY = element.getRect().y + (element.getSize().height * 0.1);
        double endY = element.getRect().y + (element.getSize().height * 0.9);
        doSwipe(driver, new Point(centerX, (int) startY), new Point(centerX, (int) endY), duration);
        logger.debug(String.format("Swipe element %s to down", element));
    }

    public void dragAndDrop(AppiumDriver driver, WebElement start, WebElement end, Duration duration) {
        doSwipe(driver, getCenter(start), getCenter(end), duration);
        logger.debug(String.format("drag element %s to %s", start, end));
    }

    public void dragAndDrop(AppiumDriver driver, Point start, Point end, Duration duration) {
        doSwipe(driver, start, end, duration);
        logger.debug(String.format("drag element %s to %s", start, end));
    }

    public Point getCenter(WebElement element) {
        int centerY = element.getRect().y + (element.getSize().height / 2);
        int centerX = element.getRect().x + (element.getSize().width / 2);
        return new Point(centerX, centerY);
    }

    public void waitUntilElementVisible(AppiumDriver driver, WebElement element, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOf(element));
        logger.debug(String.format("Wait for element %s to be displayed", element));
    }

    public void waitUntilElementVisible(AppiumDriver driver, By by, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(by));
        logger.debug(String.format("Wait for element %s to be displayed", by.toString()));
    }

    public void waitUntilElementClickable(AppiumDriver driver, WebElement element, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(element));
        logger.debug(String.format("Wait for element %s to be clickable", element));
    }

    public void waitUntilElementClickable(AppiumDriver driver, AppiumBy by, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(by));
        logger.debug(String.format("Wait for element %s to be clickable", by.toString()));
    }
}
