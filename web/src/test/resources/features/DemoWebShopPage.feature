@Regression
Feature: Open DemoWebShop - Home Page
  As a user
  I want to see all home page elements
  So that I can verify home page page works well

  Scenario: Test can open Home page successfully without login to the system
    Given I open the home page of DemoWebShop website
    Then I verify the home button is displayed
