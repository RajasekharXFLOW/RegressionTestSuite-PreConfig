@tag
Feature: Edit existing Function feature
  I want to use this template for validating Modify Existing Function Functionality

  @tag1
  Scenario: Check Modify Existing Function Functionality
  Given i open browser with url = "https://preconfig-a13.expflow.in/auth/sign-in"
  Then i should see login page
  When i enter usrname as "onboarding@xflow.com"
  And i enter password as "xFlow@321"
  And i click on login
  When i click on edit function "Test Create new Function"
  And i enter new function name "Test edit Function"
  And i enter new function short text "Test"
  And i enter new function description "Testing Create Function functionality"
  And i click save new function
  Then i should see modified function "Test edit Function"
  When i click logout
  When i close browser