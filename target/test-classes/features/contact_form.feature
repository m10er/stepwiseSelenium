@contact
Feature: Stepwise Contact Form Testing
  As a user
  I want to use the contact form on Stepwise website
  So that I can send messages to the company

  Background:
    * User navigates to Stepwise contact page
    * User accepts the cookie notification

  @negative
  Scenario: Submit form without Checkbox request
    And fills personal information
      | Field     | Value         |
      | FirstName | Test          |
      | LastName  | User          |
      | Email     | test@test.com |
      | Company   | Test Street   |
      | Message   | Basel         |
    When submits the form
    Then user should see Data Protection error message


  @negative
  Scenario Outline: Form submission with invalid email
    Given user enters as a email "<invalid email address>"
    When submits the form
    Then should see email error message

    Examples:
      | invalid email address |
      | muammer10er           |
      | muammer10ergmail.com  |
      | muammer  er@gmail.com |
      | muammer10er@gmailcom  |



