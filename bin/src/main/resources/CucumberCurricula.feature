Feature: The trainer will tests the curricula column
Scenario Outline: The trainer logs in correctly and tests curricula column
  Given Launches Chrome Browser and initiates login
  When The Trainer User enters the <username> and <password>
  Then Clicks on curricula tabs and navigates
  And Quits session right after testing curricula

Examples:
| username                         | password     |
| "test.trainer@revature.com.int1" | "trainer123" |