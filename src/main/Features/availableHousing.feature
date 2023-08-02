Feature: The  ability  to  view  the  available  housing.
  Scenario: theres available housing to view

    Given the tenant choose "1" to view the available housing
    Then the Available housing appear

    Scenario: theres no available housing to view
      Given tenant wants to view the available housing he choosed "1"
      And theres no available housing to view
      Then  the Available housing doesn't appear



