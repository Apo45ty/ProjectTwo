# Author: Howard Chung
Feature: A VP can create a new batch
  As a VP
  I want to create a batch
  In order to make money

  Background: 
    Given Go to assignforce in Chrome
    And VP logs in
    And Navigate to the Batch tab

  @Positive
  Scenario: VP submits complete Create Batch form
    Given I complete the Create Batch form
    When I press the submit button
    Then I can see the new batch in the table
    
  @Negative
  Scenario: VP submits incomplete Create Batch form
    Given I fill out only one field
    When I press the submit button
    Then I should see a warning
