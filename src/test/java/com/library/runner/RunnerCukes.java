package com.library.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber.html",
                "rerun:target/cucumber.txt"
        },
        features = "src/test/resources/features",
        glue = "com/library/stepdefinitions",
        dryRun = true,
        tags =  "",
        publish = true

)

public class RunnerCukes { }
