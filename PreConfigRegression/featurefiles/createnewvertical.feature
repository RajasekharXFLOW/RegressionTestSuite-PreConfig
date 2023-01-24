@tag
Feature: Create new vertical feature
  I want to use this template for validating create New Vertical Functionality

  @tag1
  Scenario: Check Create New Vertical Functionality
  Given i open browser with url = "https://preconfig-a13.expflow.in/auth/sign-in"
  Then i should see login page
  When i enter usrname as "onboarding@xflow.com"
  And i enter password as "xFlow@321"
  And i click on login
  When i click on add vertical
  And i enter vertical name "Test Create new Vertical"
  And i enter short text "Test"
  And i enter description "Testing Create Vertical functionality"
  And i select time range and click save "Hour"
  Then i should see new vertical "Test Create new Vertical"
  When i click logout
  When i close browser
  
