package com.library.stepdefinitions;

import com.library.utils.Driver;
import com.library.utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Map;


public class Hooks {


    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()){

            byte[] snapshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(snapshot,"images/png",scenario.getName());
        }

        Driver.closeDriver();
    }







}
