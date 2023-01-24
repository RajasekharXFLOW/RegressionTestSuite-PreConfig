@tag
Feature: Edit existing vertical feature
  I want to use this template for validating Modify Existing Vertical Functionality

  @tag1
  Scenario: Check Modify Existing Vertical Functionality
  Given i open browser with url = "https://preconfig-a13.expflow.in/auth/sign-in"
  Then i should see login page
  When i enter usrname as "onboarding@xflow.com"
  And i enter password as "xFlow@321"
  And i click on login
  When i click on edit vertical "Test Create new Vertical"
  And i enter new vertical name "Test edit Vertical"
  And i enter new short text "Test"
  And i enter new description "Testing Create Vertical functionality"
  And i select time ranges and click save
  Then i should see modified vertical "Test edit Vertical"
  When i click logout
  When i close browser