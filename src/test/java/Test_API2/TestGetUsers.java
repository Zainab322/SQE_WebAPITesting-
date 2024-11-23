package Test_API2;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestGetUsers {
    @Test
    void TC1() {
        String url = "https://jsonplaceholder.typicode.com/users/1";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(url);

        System.out.println("Status Code: " + response.getStatusCode());
        Assert.assertEquals(200, response.getStatusCode());

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        Assert.assertTrue(responseBody.contains("name"), "Response body does not contain name");
    }
}
