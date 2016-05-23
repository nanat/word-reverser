@word-reversing
Feature: Word Reversing. The application echoes the reversed user input.

  Scenario: The application echoes the reversed user input
    When The user inputs a word such as "someword"
    Then The application will reply with "drowemos"

  Scenario: The application likes palindromes
    When The user inputs a palindrome such as "WOW"
    Then The applications replies with a nice comment: "WOW Nice word!"