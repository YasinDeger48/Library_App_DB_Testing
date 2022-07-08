package com.library.pages;

import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{


    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement ShownName;

    @FindBy(xpath = "//a[@href='#books']")
    public WebElement booksLink;

    @FindBy(xpath = "//a[@href='#borrowing-books']")
    public WebElement borrowingBooksLink;

    @FindBy(id = "book_categories")
    public WebElement bookCategoriesDropdown;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBar;

    @FindBy(name = "tbl_books_length")
    public WebElement showRecordsDropdown;

    @FindBy(xpath = "//h3")
    public WebElement homePageTitleContent;

    @FindBy(id = "tbl_books_info")
    public WebElement searchResultText;  //Showing 1 to 10 of 929 entries

    @FindBy(xpath = "//tbody/tr/td")
    public List<WebElement> eachTableItems;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> eachTableRows;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm  ']")
    public WebElement borrowBookButton;

    @FindBy(id = "toast-container")
    public WebElement toastMessage;

}
