package Test_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPost {
    @Test
    void TC2() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Hello");
        requestBody.put("body", "World");
        requestBody.put("userId", 1);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        System.out.println("Status Code: " + response.getStatusCode());
        Assert.assertEquals(201, response.getStatusCode());

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        Assert.assertTrue(responseBody.contains("foo"), "Title not correctly added.");
    }
}
