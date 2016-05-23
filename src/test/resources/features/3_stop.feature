@greetings
Feature: Stop. The application greets goodbye.

  Scenario: The application greets the user goodbye
    Given The current user name is "Simona"
    When The user inputs "Stop!"
    Then the applications greets "Goodbye Simona" and stops