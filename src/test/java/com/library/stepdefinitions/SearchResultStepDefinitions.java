package com.library.stepdefinitions;

import com.library.pages.HomePage;
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
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));



    @When("User choose book categories as {string}")
    public void user_chose_book_categories_as(String all) {


        Select select = new Select(homePage.bookCategoriesDropdown);

        select.selectByVisibleText(all);



    }
    @Then("User sees the search result number same with the Database")
    public void user_sees_the_search_result_number_same_with_the_database() {

        String query = "select * from books";

        wait.until(ExpectedConditions.visibilityOf(homePage.searchResultText));

        String searchResultText = homePage.searchResultText.getText();

        String[] eachSearchResult = searchResultText.split(" ");
        int bookNumbers = Utils.getUsername(query).size();

        Assert.assertEquals(bookNumbers, Integer.parseInt(eachSearchResult[5]));


    }


}
