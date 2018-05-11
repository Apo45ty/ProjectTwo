Feature: Entering the landing page all batches are displayed

  Scenario: Upon entering the page I login and enter the landing page
    When I login successfully
    Given credentials are valid
    Then landing page should load batches table

  Scenario Outline: Upon entering the page I should see the following batches
    When Entering the home page
    Given credentials are valid
    Then landing page should display "<batchName>"
    Then user should log out

    Examples: 
      | batchname       |
      | 181Jan111       |
      | 1801 Jan15 .NET |
