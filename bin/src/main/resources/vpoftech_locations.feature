Feature: VP of Tech tests location page

    VP of Tech logs in and tests the location page

    Scenario Outline: VP of Tech logs in and tests location page

        Given VP of tech opens browser and goes to salesforce page to test LOCATIONS
        When VP of Tech logs in with <username> and <password> to test LOCATIONS
        Then VP of Tech tests the LOCATIONS page by clicking all elements
        And VP of Tech logs out after testing LOCATIONS

        Examples:
            | username                          | password   |
            | "test.vpoftech@revature.com.int1" | "yuvi1712" |