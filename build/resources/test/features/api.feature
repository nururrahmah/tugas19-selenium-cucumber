Feature: API Testing with cucumber rest assured on https://reqres.in/

 # positive case
  Scenario: Verify get request single user
    Given I set the GET request to "api/users/2"
    When I send the GET request
    Then The response code should be 200
    And the response body should contain "janet.weaver@reqres.in"

  # positive case
  Scenario: Verify POST request new user
    Given I set the POST Request for endpoint "api/users"
    And the request body is:
      """
      {
        "name": "morpheus",
        "job": "leader"
      }
      """
    When I send the POST Request
    Then The response code should be 201
    And the response body should contain "morpheus"

  # negative case
  Scenario: Verify get request not existed user
    Given I set the GET request to "api/users/12323132131212313"
    When I send the GET request
    Then The response code should be 401