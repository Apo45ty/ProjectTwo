Feature: Reset functionality on login page of Application				
Scenario Outline: Verification of reset button with numbers of credential
Given Open Chrome and launch the application				

When Enter the <username> and <password>

Then Press Logout button						

Examples:                      		

|username  |password         |		
|User1     |password1        |		
|User2     |password2        |		
|User3     |password3        |