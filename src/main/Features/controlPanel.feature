Feature: view control panel
  Scenario:the tenant choosed "3" from menu
    Given tenant choosed "3" to view control panel
    And the tenant has house booked before username is "YazanM23"
    Then the control panel will appear for tenant username "YazanM23"

    Scenario: tenant pressed "3" to view the control panel
      Given tenant pressed "3" to view the control panel
      And the tenant didnt booked before username is "yazan1"
      Then the control panel will not appear for tenant username "yazan1"

#      Scenario: user choosed "3" to view control panel
#        Given user choosed "3" to view control panel
#        And the tenant booked before username is "yazan1" but the owner is wrong
#        Then the control panel will appear for the tenant username "yazan1"
#

