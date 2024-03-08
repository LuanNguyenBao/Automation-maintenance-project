package com.epam.qavn.webdriverio.swipePage;

import com.epam.qavn.core.AbstractTest;
import com.epam.qavn.pages.SwipePage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.epam.qavn.constant.CONFIG.SHORT_DRAG_DROP_TIME;

public class SwipeTests extends AbstractTest {
    SwipePage swipePage;

    @BeforeClass
    public void initData() {
        swipePage = new SwipePage(driver);
        swipePage.tapSwipeMenu();
    }

    @Test
    @Description("Verify swipe to second card then swipe back to first card")
    public void swipeTest() {
        List<WebElement> lstCards = swipePage.getAllCards();
        swipePage.doSwipeHorizontalFromRight(driver, lstCards.get(0), Duration.ofMillis(SHORT_DRAG_DROP_TIME));
        Assert.assertTrue(swipePage.getSecondCardIcon().isDisplayed());
        swipePage.doSwipeHorizontalFromLeft(driver, lstCards.get(1), Duration.ofMillis(SHORT_DRAG_DROP_TIME));
        Assert.assertTrue(swipePage.getFirstCardIcon().isDisplayed());
    }
}
