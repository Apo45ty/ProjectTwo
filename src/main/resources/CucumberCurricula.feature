Feature: Trainer Test Curricula
    Scenario Outline: Login
           Given Open browser request is made by User
        When Credentials are for a user Username <username> and Password <password>
        Then Open Chrome Browser and Login Assignforce
        And Login using User credentials
        When Login is successful and tests Curricula
        Then Logout of Assignforce


        Examples:
            | username                          | password     |
            | "test.trainer@revature.com.int1"  | "trainer123" |
