package com.library.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "json:target/failedTest/cucumberFailed.json"
        },
        features = "target/cucumber.json",
        glue = "com/library/stepdefinitions",
        tags = "",
        dryRun = false

)


public class FailRunner {
}
