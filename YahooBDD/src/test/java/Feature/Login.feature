Feature: Yahoo registration form

  Scenario Outline: Validate Login
    Given User is on login page
    When User enters details as firstname and lastname
    When User enters Newemail and domain
    When User enters password
    When User enter DOB as month day and year
    And User clicks on Countinue
    And User enters mobile number
    Then User clicks on send code

   Scenario:
   Given User is on home page
   When User clicks on terms 
   Then terms page is displayed
   
