package com.tricentis.demowebshop.stepDefinitions;

import com.tricentis.demowebshop.core.hook.Hook;
import com.tricentis.demowebshop.pageObjects.BasePageObject;
import com.tricentis.demowebshop.pageUIs.BasePageUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    private final WebDriver driver;
    private final BasePageObject basePageObject;
    protected Logger logger;

    public BaseSteps() {
        logger = LogManager.getLogger(getClass());
        driver = Hook.driver;
        basePageObject = new BasePageObject(driver);
    }

    @Given("I open the home page of DemoWebShop website")
    public void iOpenTheHomePageOfDemoWebShopWebsite() {
    }
}
