Feature: 
	User or Admin will login using
	credentials
	
Scenario Outline: Login 
	Given Open browser request is made by User
	When Credentials are for a user Username <username> and Password <password>
	Then Open chrome and enter assignforce
	And login using User credentials 
	When Login is successful
	Then Logout of assignforce


Examples:  
	|username|password|
	|"test.trainer@revature.com.int1"|"trainer123"|
	|"test.vpoftech@revature.com.int1"|"yuvi1712"|