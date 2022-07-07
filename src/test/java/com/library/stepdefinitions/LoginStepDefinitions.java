package com.library.stepdefinitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utils.ConfigReader;
import com.library.utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();



    @Given("User enters library log in page")
    public void user_enters_library_log_in_page() {

        Utils.navigateTo(ConfigReader.getProperty("web.site"));


    }
    @When("User enters username {string}")
    public void user_enters_username(String string) {

        loginPage.emailInput.sendKeys(string);


    }
    @When("User enters password {string}")
    public void user_enters_password(String string) {

        loginPage.passwordInput.sendKeys(string);

    }
    @When("User clicks the sign in button")
    public void user_clicks_the_sign_in_button() {

        loginPage.signInButton.click();

    }
    @Then("User sees the library home page")
    public void user_sees_the_library_home_page() {

        Assert.assertTrue(homePage.homePageTitleContent.getText().equals("Book Management"));

    }

}
