Feature: Schedule an Appointment to Enroll

  Scenario: Validate Schedule Page
    Given browser is open
    When I open the url
    Then I verify schedule and enroll text
    And search representative
    And contact number

  Scenario: Schedule with a representative
    Given browser is open
    When I open the url
    And when I click medicare
    And click search rep
    Then verify header is "Sales Representative Search"
    When search rep "Luis Villanueva"
    And click contact
    Then verify header is "Sales Representative Information"
    When I click view schedule
    Then verify banner is "Schedule an Appointment to Enroll"
    When I click telephone
    And choose date
    And choose time
    And I click continue
    Then verify appoinment page
