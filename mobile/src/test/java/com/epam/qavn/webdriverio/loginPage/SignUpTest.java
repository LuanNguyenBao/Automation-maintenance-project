package com.epam.qavn.webdriverio.loginPage;

import com.epam.qavn.core.AbstractTest;
import com.epam.qavn.pages.SignUpPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignUpTest extends AbstractTest {

    private SignUpPage signupPage;
    private SoftAssert softAssert;

    @BeforeClass
    public void setup() {
        signupPage = new SignUpPage(driver);
        signupPage.tapSignupForm();

        softAssert = new SoftAssert();
    }

    @Test
    @Description("Verify sign up without input email, password and confirm password")
    public void signupWithoutInputInformation() {
        signupPage.signup("", "", "");
        softAssert.assertEquals(signupPage.getEmailErrorMessage(), "Please enter a valid email address");
        softAssert.assertEquals(signupPage.getPasswordErrorMessage(), "Please enter at least 8 characters");
        softAssert.assertEquals(signupPage.getConfirmPasswordErrorMessage(), "Please enter the same password");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify sign up with invalid email format, password is less than 8 characters and confirm password is not equal to password")
    public void signupWithInvalidEmailFormatAndPassLessThan8CharactersAndConfirmPassNotEqualToPass() {
        signupPage.signup("abc@gmail", "123456", "123456789");
        softAssert.assertEquals(signupPage.getEmailErrorMessage(), "Please enter a valid email address");
        softAssert.assertEquals(signupPage.getPasswordErrorMessage(), "Please enter at least 8 characters");
        softAssert.assertEquals(signupPage.getConfirmPasswordErrorMessage(), "Please enter the same password");
        softAssert.assertAll();
    }

    @Test(groups = "needToClosePopup")
    @Description("Verify sign up with valid email, password and confirm password")
    public void signupWithValidInformation() {
        signupPage.signup("abc@gmail.com", "123456789", "123456789");
        Assert.assertEquals(signupPage.getSignUpSuccessfulMessage(), "You successfully signed up!");
    }

    @AfterMethod(onlyForGroups = "needToClosePopup")
    public void closePopup() {
        signupPage.tapOkBtn();
    }
}
