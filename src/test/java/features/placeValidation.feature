Feature: Validating Place API's
@AddPlace @Regression
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI

    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "addPlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" is response body is "OK"
    And "scope" is response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"
    Examples:
      | name    | language | address             |
      | AAhouse | English  | Bakery cross center |
      | NewName | French   | sweety avenue       |
@DeletePlace @Regression
  Scenario:Verify if Delete Place Functionality is working
    Given DeletePlace Payload
    When user calls "deletePlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" is response body is "OK"






