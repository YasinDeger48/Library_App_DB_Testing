package com.library.stepdefinitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utils.Driver;
import com.library.utils.Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SearchResultStepDefinitions {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    // @search1 and @search2

    @When("User enters username {string} and password {string} then sign in button")
    public void user_enters_username_and_password_then_sign_in_button(String username, String password) {
        loginPage.login(username, password);
    }


    @When("User choose book categories as {string}")
    public void user_chose_book_categories_as(String visibleText) {


        Select select = new Select(homePage.bookCategoriesDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.bookCategoriesDropdown));
        select.selectByValue(Utils.returnBookCategoriesSelectValueNumber(visibleText));


    }


    @Then("User sees the search result number same with the Database {string}")
    public void user_sees_the_search_result_number_same_with_the_database(String database) {

        int result = 0;
        wait.until(ExpectedConditions.visibilityOf(homePage.searchResultText));
        String searchResultText = homePage.searchResultText.getText();

        if (searchResultText.equals("No entries found")) {

            result = 0;

        } else {

            String[] eachSearchResult = searchResultText.split(" ");

            result = Integer.parseInt(eachSearchResult[5]);
        }

        Assert.assertEquals(result, Utils.getUsername(database).size());

    }


    // @search3

    @When("User enters {string} in the searchBar")
    public void user_enters_in_the_search_bar(String searchKey) {

        homePage.searchBar.sendKeys(searchKey);
        Utils.waitFor(2); //for waiting for search result from backend side

    }

    @Then("User ensure that search result or results is applicable for search key {string}")
    public void user_ensure_that_search_result_or_results_is_applicable(String searchKey) {

        List<WebElement> tableItems = homePage.eachTableItems;

        for (WebElement eachItem : tableItems) {
            System.out.println(eachItem.getText());
            if (eachItem.getText().contains(searchKey)) {
                Assert.assertTrue(true);
            }
        }

    }

    // @search4

    @When("User choose show records by {string}")
    public void user_choose_show_records_by(String rowNumber) {

        Select select = new Select(homePage.showRecordsDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.showRecordsDropdown));
        select.selectByValue(String.valueOf(rowNumber));
        if ((!rowNumber.equals("500"))) {
            Utils.waitFor(1);
        } else {
            Utils.waitFor(5);
        }

    }


    @Then("User ensure that correct {string} showed")
    public void user_ensure_that_correct_showed(String rowNumber) {
        List<WebElement> eachRow = homePage.eachTableRows;
        wait.until(ExpectedConditions.visibilityOf(eachRow.get(eachRow.size() - 1)));
        Assert.assertEquals(eachRow.size(), Integer.parseInt(rowNumber));


    }


    // @search5

    @When("User clicks the Borrow Book link")
    public void user_clicks_the_borrow_book_link() {

        wait.until(ExpectedConditions.elementToBeClickable(homePage.borrowBookButton.get(0)));
        homePage.borrowBookButton.get(0).click();

    }

    @When("User sees the {string} top right side")
    public void user_sees_the_top_right_side(String toastMessage) {

        wait.until(ExpectedConditions.visibilityOf(homePage.toastMessage));
        Assert.assertTrue(homePage.toastMessage.isDisplayed() && homePage.toastMessage.getText().equals(toastMessage));

    }

    @Then("User sees own name on Borrowed By cell as {string}")
    public void user_sees_own_name_on_borrowing_by_cell(String name) {

        Utils.waitFor(2);
        String actualText = homePage.borrowedByCells.get(0).getText();

        Assert.assertEquals(name,actualText);



    }


}



