@greetings
Feature: Welcome Message. The application greets the user.

  Scenario Outline: The application greets the user depending on the current time
    Given The user "Simona" is connecting in the <timewindow>
    When The user types "ohce Simona"
    Then The user is prompt "<greetings> Simona"

    Examples:
      | timewindow  | greetings       |
      | morning     | Good morning    |
      | afternoon   | Good afternoon  |
      | night       | Good night      |