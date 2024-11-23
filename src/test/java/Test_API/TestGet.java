package Test_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestGet {
    @Test
    void TC1() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(url);

        System.out.println("Status Code: " + response.getStatusCode());
        Assert.assertEquals(200, response.getStatusCode());

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        Assert.assertTrue(responseBody.contains("userId"), "Response body does not contain userId");
    }
}
