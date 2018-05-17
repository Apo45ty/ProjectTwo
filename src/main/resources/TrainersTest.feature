Feature: Trainer will login and navigate to the trainer tab and it will display all current trainers

  Scenario: The trainer logs in correctly and tests trainers profile page
    Given Launches Chrome Browser and login
    When Clicks on the trainers tab
    Then Clicks on first trainer
    And Verifies that the profile page loaded
    And Logs Out

  Scenario: The trainer logs in correctly as vp and creates a new trainer
    Given Launches Chrome Browser and login
    When Clicks on the trainers tab
    Then Clicks on the create new trainer button
    And Enters a new firstname and lastname
    And Clicks on the save button
    And Verifies that the trainr is created
    And Logs Out

