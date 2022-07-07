package com.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
