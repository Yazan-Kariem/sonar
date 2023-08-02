@tag1
  Feature: Login or register as a owner or tenant.

    Scenario: admin can login
      Given admin wants to sign in
      And enters "admin" as a username and enters "123456" as a password
      Then admin login success

    Scenario: successful login
      Given tenant or owner wants to login to the system
      And enters "kariem" as a username and "123456" as a password and both are correct
      Then login successful

    Scenario: failure login
      Given tenant or owner login to the system
      And enters "kariemm" as a username and "1234566" as a password and one of them are wrong
      Then error appears

    Scenario: successful registration as a tenant or owner
        Given user wants to register as a tenant or owner
        And first name  = "Ahmad", second name = "mohammed", lastname = "AbuAishe", Phone="0593220265", email = "Ahmadmohammed@gmail.com", age ="21", OwUser = "Ahmad mohammed", OwPass = "11223344" for owner and first name  = "Ahmad", second name = "Sameer", lastname = "AbuAishe", Phone="0593220260", email = "Ahmadasameer@gmail.com", age ="21", Reg_num = "12028797", major = "Computer Engineering", tenUser = "Ahmad sameer", tenPass = "1234" for tenant and both usernames is available
        Then registration complete and the account is created

    Scenario: registration fail as a tenant or owner
      Given user wants to signup as a tenant or owner
      And first name  = "Ahmad", second name = "mohammed", lastname = "AbuAishe", Phone="0593220265", email = "Ahmadmohammed@gmail.com", age ="21", OwUser = "Ahmad mohammed", OwPass = "11223344" for owner and first name  = "Ahmad", second name = "Sameer", lastname = "AbuAishe", Phone="0593220260", email = "Ahmadasameer@gmail.com", age ="21", Reg_num = "12028797", major = "Computer Engineering", tenUser = "Ahmad sameer", tenPass = "1234" for tenant and usernames isn't available
      Then registration fails and error appears

      Scenario: admin, tenant or owner want to logout
        Given admin, tenant or owner already logged in to the system
        And pressed logout
        Then admin, tenant or owner logged out successfully