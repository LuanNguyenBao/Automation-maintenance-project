package com.epam.qavn.pages;

import com.epam.qavn.core.AbstractPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.epam.qavn.constant.CONFIG.SHORT_PRESS_TIME;

public class SignUpPage extends AbstractPage {

    private final AppiumDriver driver;

    private final By menuLoginBy = AppiumBy.accessibilityId("Login");
    private final By signupTapBy = AppiumBy.accessibilityId("button-sign-up-container");
    private final String emailInput = "input-email";
    private final String passwordInput = "input-password";
    private final String confirmPasswordInput = "input-repeat-password";
    private final By signupBtnBy = AppiumBy.accessibilityId("button-SIGN UP");
    private final String errorMessage = "//android.widget.EditText[@content-desc='%s']/parent::android.view.ViewGroup/following-sibling::android.widget.TextView[1]";
    private final By signupSuccessfulMessageBy = AppiumBy.id("android:id/message");
    private final By btnOkBy = AppiumBy.id("android:id/button1");

    public SignUpPage(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Tap to Sign up form")
    public void tapSignupForm() {
        tapCenterOf(driver, findElementBy(driver, menuLoginBy), Duration.ofMillis(SHORT_PRESS_TIME));
        tapCenterOf(driver, findElementBy(driver, signupTapBy), Duration.ofMillis(SHORT_PRESS_TIME));
    }

    @Step("Sign up with email: '{0}', password: '{1}' and confirm password: '{2}'")
    public void signup(String email, String password, String confirmPassword) {
        inputText(driver, AppiumBy.accessibilityId(emailInput), email);
        inputText(driver, AppiumBy.accessibilityId(passwordInput), password);
        inputText(driver, AppiumBy.accessibilityId(confirmPasswordInput), confirmPassword);
        tapCenterOf(driver, findElementBy(driver, signupBtnBy), Duration.ofMillis(SHORT_PRESS_TIME));
    }

    @Step("Get Email error message")
    public String getEmailErrorMessage() {
        return getElementText(driver, AppiumBy.xpath(String.format(errorMessage, emailInput)));
    }

    @Step("Get Password error message")
    public String getPasswordErrorMessage() {
        return getElementText(driver, AppiumBy.xpath(String.format(errorMessage, passwordInput)));
    }

    @Step("Get Confirm Password error message")
    public String getConfirmPasswordErrorMessage() {
        return getElementText(driver, AppiumBy.xpath(String.format(errorMessage, confirmPasswordInput)));
    }

    @Step("Get sign up successful message")
    public String getSignUpSuccessfulMessage() {
        return getElementText(driver, signupSuccessfulMessageBy);
    }

    @Step("Tap to OK button to close popup")
    public void tapOkBtn() {
        tapCenterOf(driver, findElementBy(driver, btnOkBy), Duration.ofMillis(SHORT_PRESS_TIME));
    }
}
