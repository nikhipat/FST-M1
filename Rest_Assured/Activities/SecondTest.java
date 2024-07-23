package examples;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SecondTest {
    @Test
    public void getRequestWithPathParam() {
        Map<String,Object> reqBody=new HashMap<>();
        reqBody.put("id",77232);
        reqBody.put("name","Riley");
        reqBody.put("status","alive");

        given().
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type", "application/json").body(reqBody).log().all().
                when().
                post().
                then().
                statusCode(200).
                body("name",equalTo("Riley")).
                body("status",equalTo("alive")).log().all();

    }
}
