Feature: Trainer will login and navigate to the trainer tab and it will display all current trainers. It will allow for the creation of new trainers; the account activation and account deactivation

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

	Scenario: Activates trainer
	  Given Launches Chrome Browser and login
    When Clicks on the trainers tab
    Then Selects the first unactivated trainer and activates the trainer
    And Verifies that the selected trainer is activated
    And Logs Out
    
   Scenario: Deactivates trainer
	  Given Launches Chrome Browser and login
    When Clicks on the trainers tab
    Then Selects the first activated trainer and unactivates the trainer
    And Verifies that the selected trainer is unactivated
    And Logs Out
    