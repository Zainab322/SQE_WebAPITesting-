package Test_API2;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestDeleteUsers {
    @Test
    void TC4() {
        String url = "https://jsonplaceholder.typicode.com/users/1";

        Response response = RestAssured.delete(url);
        
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(200, response.getStatusCode());
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.isEmpty() || responseBody.equals("{}"), 
                          "Response body is not empty or '{}' after deletion.");
    }
}
