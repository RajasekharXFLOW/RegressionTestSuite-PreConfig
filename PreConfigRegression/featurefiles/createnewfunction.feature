@tag
Feature: Create new Function feature
  I want to use this template for validating create New Vertical Functionality

  @tag1
  Scenario: Check Create New Function Functionality
  Given i open browser with url = "https://preconfig-a13.expflow.in/auth/sign-in"
  Then i should see login page
  When i enter usrname as "onboarding@xflow.com"
  And i enter password as "xFlow@321"
  And i click on login
  When i click on add vertical
  And i enter function name "Test Create new Function"
  And i enter function short text "Test"
  And i enter function description "Testing Create Function functionality"
  And i click on save function
  Then i should see new function "Test Create new Function"
  When i click logout
  When i close browser