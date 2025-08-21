package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReqResApiPage {
    private String baseUrl = "https://reqres.in/";
    private Response response;

    public void setEndpoint(String endpoint) {
        RestAssured.baseURI = baseUrl + endpoint;
    }

    public Response sendGetRequest() {
        response = given()
                .when()
                .get()
                .then()
                .extract()
                .response();
        return response;
    }

    public Response sendPostRequest(String requestBody) {
        response = given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(requestBody)
                .when()
                .post()
                .then()
                .extract()
                .response();
        return response;

    }

}
