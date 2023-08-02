Feature:Furniture feature to view and sell furnitures
  Scenario: tenants select furniture option and select option "1"
    Given tenant typed 1 to view his furnitures
    And the tenant has available furnitures the tenant username is "YazanM23"
    Then the program will appear the furnitures for username "YazanM23"

  Scenario: tenants select furniture option and select option "1"
    Given tenant typed 1 to show his furnitures
    And the tenant doesn't have available furnitures the tenant username is "yazan1"
    Then the program will not appear the furnitures for username "yazan1"


  Scenario: tenants select furniture option and select option "2"
    Given tenant typed "2" to choose add option to add furniture
    Then the program will appear window to add furniture has these informations username is "YazanM23" and Picture is "test" and Description is "test" and Price is "200" and ID is "3" and selled is "No"
    And if the id duplicated is added before it will not added it username is "YazanM23" and Picture is "test" and Description is "test" and Price is "200" and ID is "4" and selled is "No"

Scenario: tenants select furniture option and select option "3"
  Given tenant typed "3" to Sell his furniture id is "1"
  And furniture id is "1" its available to sell and the tenant username is "YazanM23"
 Then the program will sell the furniture id "1" username is "YazanM23"


  Scenario: tenants select furniture option and select option "3"
    Given tenant typed "3" to sell his furniture id is "2"
    And furniture id is "2" its not available to sell and the tenant username is "YazanM23"
    Then the program will not sell the furniture id "2" username is "YazanM23"



