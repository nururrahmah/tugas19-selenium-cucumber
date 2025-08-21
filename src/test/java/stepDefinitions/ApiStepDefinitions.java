package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.ReqresApiPage;

public class ApiStepDefinitions {

    ReqresApiPage reqresApiPage = new ReqresApiPage();
    private String requestBody;
    private Response response;

    @Given("I set the GET request to {string}")
    public void setupGETEndpoint(String endpoint) {
        reqresApiPage.setEndpoint(endpoint);
    }

    @Given("I set the POST Request for endpoint {string}")
    public void setupPOSTEndpoint(String endpoint) {

        reqresApiPage.setEndpoint(endpoint);
    }

    @When("I send the GET request")
    public void sendGetRequest() {
        response = reqresApiPage.sendGetRequest();
        System.out.println(response.getBody().asString());
    }

    @Then("The response code should be {int}")
    public void verifyRespondCode(int expectedRespondCode) {
        int actualRespondCode = response.getStatusCode();
        System.out.println("actual respond Code = " + actualRespondCode);
        Assert.assertEquals(expectedRespondCode, actualRespondCode);
    }

    @Then("the response body should contain {string}")
    public void verifyRespondBodyContainsText(String text) {
        String respondBody = response.getBody().asString();
        Assert.assertTrue(respondBody.contains(text));

    }

    @Given("the request body is:")
    public void theRequestBodyIs(String requestBody) {
        this.requestBody = requestBody;

    }

    @When("I send the POST Request")
    public void iSendThePOSTRequest() {
        response = reqresApiPage.sendPostRequest(this.requestBody);
        System.out.println(response.getBody().asString());

    }
}
