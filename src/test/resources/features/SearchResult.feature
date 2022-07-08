@search
Feature: Search Results Feature Files


  Background: User is logged in successfully
    Given User enters library log in page
    When User enters username "student28@library" and password "wVoUPkGU" then sign in button
    Then User sees the library home page

  @search1
  Scenario: User sees all books by default
    When User choose book categories as "ALL"
    Then User sees the search result number same with the Database "ALL"


  @search1
  Scenario: User search book in  Drama Category
    When User choose book categories as "Historical Fiction"
    Then User sees the search result number same with the Database "Historical Fiction"


  @search1
  Scenario: User search book in Fairy Tale Category
    When User choose book categories as "Fairy Tale"
    Then User sees the search result number same with the Database "Fairy Tale"

  @search1
  Scenario: User search book in Fairy Tale Category
    When User choose book categories as "Drama"
    Then User sees the search result number same with the Database "Drama"

  @search2
  Scenario Outline: User search all book categories and compare results between UI and DB
    When User choose book categories as "<Categories>"
    Then User sees the search result number same with the Database "<Categories>"

    Examples:
      | Categories              |
      | ALL                     |
      | Action and Adventure    |
      | Anthology               |
      | Classic                 |
      | Comic and Graphic Novel |
      | Crime and Detective     |
      | Drama                   |
      | Fable                   |
      | Fairy Tale              |
      | Fan-Fiction             |
      | Fantasy                 |
      | Historical Fiction      |
      | Horror                  |
      | Science Fiction         |
      | Biography/Autobiography |
      | Humor                   |
      | Romance                 |
      | Short Story             |
      | Essay                   |
      | Memoir                  |
      | Poetry                  |

  @search3
    Scenario: User search book via search box
      When User enters "Electra" in the searchBar
      Then User ensure that search result or results is applicable for search key "Electra"


    @search4
    Scenario Outline:
      When User choose show records by "<records number>"
      Then User ensure that correct "<row>" showed
      Examples:
        | records number | row |
        | 5              | 5   |
        | 10             | 10  |
        | 15             | 15  |
        | 50             | 50  |
        | 100            | 100 |
        | 200            | 200 |
        | 500            | 500 |


      @search5
      Scenario: user search book and borrow it
        When User enters "Decca" in the searchBar
        And User clicks the Borrow Book link
        And User sees the "The book has been borrowed..." top right side
        And User enters "Decca" in the searchBar
        Then User sees own name on Borrowed By cell as "Test Student 28"
