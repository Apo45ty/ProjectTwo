Feature: Trainer will login and navigate to the trainer tab and it will display all current trainers
Scenario: The trainer logs in correctly and tests curricula column
  Given Launches Chrome Browser and login 
  When Clicks on the trainers tab
  Then Clicks on first trainer
  And Verifies that the profile page loaded
  And Logs Out

  