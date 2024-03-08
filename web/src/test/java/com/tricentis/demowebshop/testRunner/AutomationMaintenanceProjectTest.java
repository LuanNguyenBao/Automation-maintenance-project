package com.tricentis.demowebshop.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/tricentis/demowebshop/stepDefinitions", "com/tricentis/demowebshop/core/hook"},
        tags = "@Regression",
        plugin = {
                "pretty",
                "html:target/cucumberReport/cucumber-report-html/cucumber.html",
                "json:target/cucumberReport/json/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
)
public class AutomationMaintenanceProjectTest {
}
