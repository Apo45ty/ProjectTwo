Feature: Trainer_1 Tests_1 curricula page
Scenario Outline: Trainer_1 logs in correctly and tests curricula page
Given Open the Chrome and launch the application

When Enter the <username> and <password>

Then Press Logout button						

Examples:                      		

|username  |password         |		
|User1     |password1        |		
|User2     |password2        |		
|User3     |password3        |    