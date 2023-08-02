Feature: show students info lived in house
  Scenario:pressed "4"  to show peoples lived in houses
    Given tenant pressed "4" to view peoples lived in houses
    And theres peoples in houses id "1"
    Then the peoples username will appear in house id "1"

  Scenario:pressed "4"  to view peoples lived in houses
    Given tenant pressed "4" to view peoples who lived in house
    And theres no peoples in houses id "2"
    Then this peoples username will not appear in house id "2"



