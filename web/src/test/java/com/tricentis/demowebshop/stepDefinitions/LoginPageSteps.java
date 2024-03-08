package com.tricentis.demowebshop.stepDefinitions;

import com.tricentis.demowebshop.core.hook.Hook;
import com.tricentis.demowebshop.pageObjects.LoginPageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {

    private final WebDriver driver;
    private final LoginPageObject loginPageObject;

    public LoginPageSteps() {
        driver = Hook.driver;
        loginPageObject = new LoginPageObject(driver);
    }

    @When("I input value for email {string} and password {string}, then click login button")
    public void iInputEmailPasswordAndClickLogin(String emailValue, String passwordValue) {
        loginPageObject.inputEmailTextBox(emailValue);
        loginPageObject.inputPasswordTextBox(passwordValue);
        loginPageObject.clickLoginButton();
    }

    @Then("I verify the login page are displayed")
    public void iVerifyTheHomeButtonIsDisplayed() {
        SoftAssertions softAssertions = new SoftAssertions();
        loginPageObject.waitLoginTitleDisplayed();
        softAssertions.assertThat(loginPageObject.isLoginTitleDisplayed()).isTrue();
        softAssertions.assertThat(loginPageObject.isEmailLabelDisplayed()).isTrue();
        softAssertions.assertThat(loginPageObject.isEmailTextBoxDisplayed()).isTrue();
        softAssertions.assertThat(loginPageObject.isPasswordLabelDisplayed()).isTrue();
        softAssertions.assertThat(loginPageObject.isPasswordTextBoxDisplayed()).isTrue();
        softAssertions.assertThat(loginPageObject.isRememberMeCheckboxDisplayed()).isTrue();
        softAssertions.assertThat(loginPageObject.isRememberMeLabelDisplayed()).isTrue();
        softAssertions.assertThat(loginPageObject.isForgotPasswordDisplayed()).isTrue();
        softAssertions.assertThat(loginPageObject.isLoginButtonDisplayed()).isTrue();
        softAssertions.assertAll();
    }

    @Then("I verify the error message {string} when login fail is displayed")
    public void iVerifyErrorMessageLoginIsDisplayed(String messageExpected) {
        Assert.assertTrue(loginPageObject.isLoginErrorMessageDisplayed(messageExpected));
    }
}
