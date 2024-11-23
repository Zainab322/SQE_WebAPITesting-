package Test_API2;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPostUsers {
    @SuppressWarnings({ "unchecked", "serial" })
	@Test
    void TC2() {
        String url = "https://jsonplaceholder.typicode.com/users";

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Eman Nabi ");
        requestBody.put("username", "emannabi");
        requestBody.put("email", "emangn018@gmail.com");
        requestBody.put("address", new JSONObject() {{
            put("street", "123 main street");
            put("city", "Faisalabad");
        }});

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        System.out.println("Status Code: " + response.getStatusCode());
        Assert.assertEquals(201, response.getStatusCode());

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        Assert.assertTrue(responseBody.contains("name"), "Name not correctly added");
    }
}
