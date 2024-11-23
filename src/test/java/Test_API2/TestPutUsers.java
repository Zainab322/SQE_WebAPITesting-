package Test_API2;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPutUsers {
    @SuppressWarnings({ "unchecked", "serial" })
	@Test
    void TC3() {
        String url = "https://jsonplaceholder.typicode.com/users/1";

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Eman New");
        requestBody.put("username", "emanfatima");
        requestBody.put("email", "emanft018@gmail.com");
        requestBody.put("address", new JSONObject() {{
            put("street", "345 New St");
            put("city", "Lahore");
        }});

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(url);

        System.out.println("Status Code: " + response.getStatusCode());
        Assert.assertEquals(200, response.getStatusCode());

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        Assert.assertTrue(responseBody.contains("Eman New"), "Name not updated correctly.");
    }
}
