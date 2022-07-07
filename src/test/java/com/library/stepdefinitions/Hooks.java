package com.library.stepdefinitions;

import com.library.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {



    @Before
    public void setup(){
        Driver.getDriver().manage().window().maximize();

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }



    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()){

            final byte[] snapshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(snapshot,"images/png",scenario.getName());
        }
        com.library.utils.Driver.closeDriver();
    }
}
