package com.library.stepdefinitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utils.Driver;
import com.library.utils.Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SearchResultStepDefinitions {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));

    @When("User enters username {string} and password {string} then sign in button")
    public void user_enters_username_and_password_then_sign_in_button(String username, String password) {
        loginPage.login(username,password);
    }



    @When("User choose book categories as {string}")
    public void user_chose_book_categories_as(String visibleText) {


        Select select = new Select(homePage.bookCategoriesDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.bookCategoriesDropdown));
        select.selectByValue(Utils.returnBookCategoriesSelectValueNumber(visibleText));


    }
    @Then("User sees the search result number same with the Database {string}")
    public void user_sees_the_search_result_number_same_with_the_database(String database) {

        int result=0;
        wait.until(ExpectedConditions.visibilityOf(homePage.searchResultText));
        String searchResultText = homePage.searchResultText.getText();

        if (searchResultText.equals("No entries found")) {

            result=0;

        } else {

            String[] eachSearchResult = searchResultText.split(" ");

            result = Integer.parseInt(eachSearchResult[5]);
        }

        Assert.assertEquals(result, Utils.getUsername(database).size());

        }









    }



