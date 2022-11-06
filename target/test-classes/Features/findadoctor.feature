Feature: Find a doctor

  Scenario Outline: Find a doctor using zip
    Given I am on healthfirst homepage
    When I click on find a doc
    And I choose HMO in insurance dropdown
    And I enter <zip>
    And click on "<facility>"
    Then I should be able to click pediatric

    Examples: 
      | facility           | zip   |
      | Urgent Care Center | 11218 |
      | Urgent Care Center | 11377 |
