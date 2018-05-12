Feature: Trainer tests location page

    Trainer logs in and tests the location page

    Scenario Outline: Trainer logs in and tests location page

        Given Open browser and go to salesforce page
        When Log in with <username> and <password>
        Then Test the LOCATIONS page by clicking all elements

    Examples:
    | username | password |
    | "test.trainer@revature.com.int1"  | "trainer123" |