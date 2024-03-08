@Regression
Feature: Open Login Page
  As a user
  I want to see all login page elements
  So that I can verify home page page works well

  Background:
    Given I open the home page of DemoWebShop website
    When I click the login hyperlink on Header page

  Scenario: MP0015 - Log in - Verify Log in form of Log in page
    Then I verify the login page are displayed

  Scenario Outline: MP0016 - Log in - Verify error when login fail on Log in page
    When I input value for email "<Email>" and password "<Password>", then click login button
    Then I verify the error message "<Expected message>" when login fail is displayed
    Examples:
      | Email                 | Password        | Expected message                                                                                        |
      |                       |                 | Login was unsuccessful. Please correct the errors and try again.\nNo customer account found               |
      |                       | correctPass     | Login was unsuccessful. Please correct the errors and try again.\nNo customer account found               |
      | abc123@email.com      |                 | Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect  |
      | abc123@email.com      | wrongPass       | Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect  |

  Scenario: MP0017 - Log in - Verify Log in successfully
    When I input value for email "luan_nguyen@yopmail.com" and password "Tosca1234!", then click login button
    Then I verify login is successfully