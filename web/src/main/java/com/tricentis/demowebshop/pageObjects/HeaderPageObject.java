package com.tricentis.demowebshop.pageObjects;

import com.tricentis.demowebshop.core.BasePage;
import com.tricentis.demowebshop.pageUIs.HeaderPageUI;
import org.openqa.selenium.WebDriver;

public class HeaderPageObject extends BasePage {

    private final WebDriver driver;

    public HeaderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomeButton() {
        clickToElement(driver, HeaderPageUI.HOME_BTN_BY_CSS);
    }

    public void clickLoginHyperlink() {
        clickToElement(driver, HeaderPageUI.LOGIN_HLK_BY_CSS);
    }

    public boolean isHomeButtonDisplayed() {
        return isElementDisplayed(driver, HeaderPageUI.HOME_BTN_BY_CSS);
    }
    public boolean isLogoutHyperlinkDisplayed() {
        return isElementDisplayed(driver, HeaderPageUI.LOGOUT_HLK_BY_CSS);
    }

}
