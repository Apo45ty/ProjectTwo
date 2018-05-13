Feature: Trainer tests location page

    Trainer logs in and tests the location page

    Scenario Outline: Trainer logs in and tests location page

        Given Trainer opens browser and goes to salesforce page to test LOCATIONS
        When Trainer logs in with <username> and <password> to test LOCATIONS
        Then Trainer tests the LOCATIONS page by clicking all elements
        And Trainer logs out after testing LOCATIONS

        Examples:
            | username                         | password     |
            | "test.trainer@revature.com.int1" | "trainer123" |