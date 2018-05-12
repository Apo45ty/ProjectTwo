Feature: The VPofTechnology tests the curricula column tab
Scenario Outline: VPofTechnology logs and tests
  Given Launches Web Browser and initiates login
  When The VPofTechnology enters the <username> and <password>
  Then Browses through the VP options in the Curricula tab
  And Logs out after testing

Examples:
| username                         | password     |
| "test.vpoftech@revature.com.int1" | "yuvi1712" |
