@Facebook
Feature: Facebook

  @TC01 @123
  Scenario Outline: Facebook
    Given test data is read from Excel with "<SheetName>" and row "<RowNo>"
    Given I Launch "Facebook" URL
    When I enter "Facebook" in "Search" Field in "Facebook" Page
    Then I verify "Facebook" is displayed in "Facebook" Page

    Examples: 
      | SheetName | RowNo |
      | Facebook  |     1 |
