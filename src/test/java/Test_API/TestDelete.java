package Test_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestDelete {
    @Test
    void TC4() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        Response response = RestAssured.given()
                .delete(url);

        System.out.println("Status Code: " + response.getStatusCode());
        Assert.assertEquals(200, response.getStatusCode());

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        Assert.assertTrue(responseBody.isEmpty(), "Response body should be empty after delete.");
    }
}
