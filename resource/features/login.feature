#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Valid/Invalid User Login into Banking and SignOff

 

  #Datadriven test using Table
  Scenario Outline: User Login Test
    Given I landed on Login Page
    When Logged my valid <userId> and <password>
    And click on the Login Button
    Then User should see the DashBoard page with "<message>"

    Examples: 
      | userId     | password | message |
      | mngr595832 | AqesUrY  | success |
      | mngr12345  | AqesUrY  | error alert! |
