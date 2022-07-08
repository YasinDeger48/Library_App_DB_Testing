Feature: Search Results Feature Files


  Background: User is logged in successfully
    Given User enters library log in page
    When User enters username "student28@library" and password "wVoUPkGU" then sign in button
    Then User sees the library home page

  @2
  Scenario: User sees all books by default
    When User choose book categories as "ALL"
    Then User sees the search result number same with the Database "ALL"


  @2
  Scenario: User search book in  Drama Category
    When User choose book categories as "Historical Fiction"
    Then User sees the search result number same with the Database "Historical Fiction"


  @2
  Scenario: User search book in Fairy Tale Category
    When User choose book categories as "Fairy Tale"
    Then User sees the search result number same with the Database "Fairy Tale"

  @4
  Scenario: User search book in Fairy Tale Category
    When User choose book categories as "Drama"
    Then User sees the search result number same with the Database "Drama"

  @final
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
