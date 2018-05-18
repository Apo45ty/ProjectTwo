Feature: VP logs in and inserts 
				 data into Report page
				 
Scenario Outline: 
	Given VP opens salesforce
	And username is <username>
	And password is <password>
	Then login to admin view
	Then go to the reports page
	When page loads click batch toggle
	Then delete current card
	And add new card
	And insert data into new card
	Then press create batch button
	Then press creat all button

	
Examples: 
	| username | password|
	#|"test.trainer@revature.com.int1"|"trainer123"|
	|"test.vpoftech@revature.com.int1"|"yuvi1712"|
