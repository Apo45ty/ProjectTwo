Feature: ApplicationWillLoadAndConvertIntoJasonAllTests

	Scenario: User Request of page one returns page one
	Given Open chrome and start application
	When I request the json file
	Then the request will return a json file 
