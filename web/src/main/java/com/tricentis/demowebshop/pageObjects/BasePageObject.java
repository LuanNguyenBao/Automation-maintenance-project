package com.tricentis.demowebshop.pageObjects;

import com.tricentis.demowebshop.core.BasePage;
import org.openqa.selenium.WebDriver;

public class BasePageObject extends BasePage {

    private final WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

}
