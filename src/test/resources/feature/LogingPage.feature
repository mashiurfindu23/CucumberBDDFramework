Feature: Login page feature
  

  
  Scenario: Successful Login
    Given User is in the login page
    When the user enters the user name "mashiur.findu@gmail.com"
    And User enters password "test@123"
    And User clicks on Login button
    Then User gets title of the page 
    And The page title should be "My account - My Shop"
   