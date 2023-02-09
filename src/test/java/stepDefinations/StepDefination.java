package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefination extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();
     static String place_id;

    @Given("Add Place Payload with {string} {string} {string}")
    public void add_Place_Payload_with(String name, String language, String address) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(requestSpecification())
                .body(data.addPlacePayload(name, language, address));
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {

//constructor will be called with value of resource which you pass
        APIResources resourcesAPI = APIResources.valueOf(resource);
        System.out.println(resourcesAPI.getResource());

        resspec = (new ResponseSpecBuilder()).expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        if (method.equalsIgnoreCase("POST")) {
            response = res.when().post(resourcesAPI.getResource());


        } else if (method.equalsIgnoreCase("GET")) {
            response = res.when().get(resourcesAPI.getResource());


        }


    }

    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("{string} is response body is {string}")
    public void is_response_body_is(String keyValue, String ExpectedValue) {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertEquals(getJsonPath(response,keyValue), ExpectedValue);
    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {
        //requestSpec
          place_id=getJsonPath(response,"place_id");
        res = given().spec(requestSpecification()).queryParam("place_id",place_id );

        user_calls_with_http_request(resource,"GET");
        String actualName = getJsonPath(response,"name");
        Assert.assertEquals(actualName, expectedName);

    }
//    \"place_id\":\"7702d8a7126a6976085ab7ddfab941ff\"\r\n
    @Given("DeletePlace Payload")
    public void deleteplace_Payload() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        res=given().spec(requestSpecification()).body(data.deletePLacePayload(place_id));
    }

}
