Feature: VP of Tech tests location page

    VP of Tech logs in and tests the location page

    Scenario Outline: VP of Tech logs in and tests location page

        Given Open browser and go to salesforce page
        When Log in with <username> and <password>
        Then Test the LOCATIONS page by clicking all elements

    Examples:
    | username | password |
    | "test.vpoftech@revature.com.int1"  | "yuvi1712" |