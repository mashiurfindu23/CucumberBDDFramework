

Feature: Accounts page Feature
  I want to use this template for my feature file

  
  Background: Title of your scenario
    Given User has already logged in to application
    | username | password |
    | mashiur.findu@gmail.com | test@123 |

  
  Scenario: Accounts page title
    Given User is on Accounts page 
    When User gets the title of the page 
    Then Page title should be "My account - My Shop"
    
    
 Scenario: Accounts section count
    Given User is on Accounts page 
    Then User gets the accounts section 
    |ADD MY FIRST ADDRESS|
    |ORDER HISTORY AND DETAILS|
    |MY CREDIT SLIPS|
    |MY ADDRESSES|
    |MY PERSONAL INFORMATION|
    And Accounts section count should be 5

   