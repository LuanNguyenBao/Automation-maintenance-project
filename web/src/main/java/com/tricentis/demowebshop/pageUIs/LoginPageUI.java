package com.tricentis.demowebshop.pageUIs;

import org.openqa.selenium.By;

public class LoginPageUI {
    public static final By LOGIN_TITLE_LBL_BY_CSS = By.cssSelector("div.returning-wrapper > div.title");
    public static final By EMAIL_LBL_BY_CSS = By.cssSelector("div.form-fields label[for='Email']");
    public static final By EMAIL_TXT_BY_ID = By.id("Email");
    public static final By PASSWORD_LBL_BY_CSS = By.cssSelector("div.form-fields label[for='Password']");
    public static final By PASSWORD_TXT_BY_ID = By.id("Password");
    public static final By REMEMBER_ME_CHK_BY_ID = By.id("RememberMe");
    public static final By REMEMBER_ME_LBL_BY_CSS = By.cssSelector("div.form-fields label[for='RememberMe']");
    public static final By FORGET_PASSWORD_HLK_BY_CSS = By.cssSelector("span.forgot-password > a");
    public static final By LOGIN_BTN_BY_CSS = By.cssSelector("input[class='button-1 login-button']");
    public static final By LOGIN_ERROR_MESSAGE_BY_CSS = By.cssSelector("div.validation-summary-errors");
}
