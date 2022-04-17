Feature: Push Test
  The purpose of this feature is to ensure that the "Click Here" button can be pressed
  regardless of where it is and to ensure that once clicked, the background colour changes.

  Background:
    Given I am on the the correct url

  Scenario: Ensure that the button can be clicked
    When click the button
    Then the background colour changes
