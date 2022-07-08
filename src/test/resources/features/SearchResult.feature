Feature: Search Results Feature Files


  Background: User is logged in successfully
    Given User enters library log in page
    When User enters username "student28@library"
    And User enters password "wVoUPkGU"
    And User clicks the sign in button
    Then User sees the library home page

    @2
    Scenario: User sees all books by default
      When User choose book categories as "ALL"
      Then User sees the search result number same with the Database
