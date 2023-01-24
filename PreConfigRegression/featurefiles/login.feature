@tag
Feature: Login validation

  @tag1
  Scenario: Check Login Functionality
  
  Given i open browser with url = "https://preconfig-a13.expflow.in/auth/sign-in"
  Then i should see login page
  When i enter usrname as "onboarding@xflow.com"
  And i enter password as "xFlow@321"
  And i click on login
  Then i should see homepage
  When i click logout
  Then i should see login page
  When i close browser