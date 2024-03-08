package com.tricentis.demowebshop.pageObjects;

import com.tricentis.demowebshop.core.BasePage;
import com.tricentis.demowebshop.core.GlobalConstants;
import com.tricentis.demowebshop.pageUIs.LoginPageUI;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPageObject extends BasePage {

    private final WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmailTextBox(String emailValue) {
        sendKeyToElement(driver, LoginPageUI.EMAIL_TXT_BY_ID, emailValue);
    }

    public void inputPasswordTextBox(String passwordValue) {
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT_BY_ID, passwordValue);
    }

    public void clickLoginButton() {
        clickToElement(driver, LoginPageUI.LOGIN_BTN_BY_CSS);
    }

    public void waitLoginTitleDisplayed() {
        waitForElementUntilVisible(driver, LoginPageUI.LOGIN_TITLE_LBL_BY_CSS, Duration.ofSeconds(10));
    }

    public boolean isLoginTitleDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.LOGIN_TITLE_LBL_BY_CSS);
    }

    public boolean isEmailLabelDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.EMAIL_LBL_BY_CSS);
    }

    public boolean isEmailTextBoxDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.EMAIL_TXT_BY_ID);
    }

    public boolean isPasswordLabelDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.PASSWORD_LBL_BY_CSS);
    }

    public boolean isPasswordTextBoxDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.PASSWORD_TXT_BY_ID);
    }

    public boolean isRememberMeCheckboxDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.REMEMBER_ME_CHK_BY_ID);
    }

    public boolean isRememberMeLabelDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.REMEMBER_ME_LBL_BY_CSS);
    }

    public boolean isForgotPasswordDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.FORGET_PASSWORD_HLK_BY_CSS);
    }

    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.LOGIN_BTN_BY_CSS);
    }

    public boolean isLoginErrorMessageDisplayed(String messageExpected) {
        String actualMessage = getElementText(driver, LoginPageUI.LOGIN_ERROR_MESSAGE_BY_CSS);
        return messageExpected.equals(actualMessage);
    }
}
