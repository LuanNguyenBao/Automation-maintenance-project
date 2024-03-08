package com.tricentis.demowebshop.stepDefinitions;

import com.tricentis.demowebshop.core.hook.Hook;
import com.tricentis.demowebshop.pageObjects.HeaderPageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HeaderPageSteps {

    private final WebDriver driver;
    private final HeaderPageObject headerPageObject;

    public HeaderPageSteps() {
        driver = Hook.driver;
        headerPageObject = new HeaderPageObject(driver);
    }

    @When("I click the login hyperlink on Header page")
    public void iClickTheLoginHyperlink() {
        headerPageObject.clickLoginHyperlink();
    }

    @Then("I verify the home button is displayed")
    public void iVerifyTheHomeButtonIsDisplayed() {
        Assert.assertTrue(headerPageObject.isHomeButtonDisplayed());
    }

    @Then("I verify login is successfully")
    public void iVerifyLoginIsSuccess() {
        Assert.assertTrue(headerPageObject.isLogoutHyperlinkDisplayed());
    }
}
