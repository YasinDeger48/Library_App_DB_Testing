Feature: Login Function

  Scenario: User login library app successfully
    Given User enters library log in page
    When User enters username "student28@library"
    And User enters password "wVoUPkGU"
    And User clicks the sign in button
    Then User sees the library home page