package Test_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPut {
    @Test
    void TC3() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "WebAPI");
        requestBody.put("body", "Task1_testing");
        requestBody.put("userId", 1);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(url);

        System.out.println("Status Code: " + response.getStatusCode());
        Assert.assertEquals(200, response.getStatusCode());

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        Assert.assertTrue(responseBody.contains("updated title"), "Title not updated correctly.");
    }
}
