Feature: Trainer tests curricula page

    Trainer logs in and tests the curricula page

    Scenario Outline: Trainer logs in and tests curricula page

        Given Open browser and go to salesforce page
        When Log in with <username> and <password>
        Then Test the CURRICULA page by clicking all elements

    Examples:
    | username | password |
    | "test.trainer@revature.com.int1"  | "trainer123" |
