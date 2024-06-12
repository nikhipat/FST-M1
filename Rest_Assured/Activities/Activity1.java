package activities;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
    @Test(priority = 1)
    public void postRequestWithPathParam() {
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
    @Test(priority = 2)
    public void getRequestWithPathParam() {
        given().
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type", "application/json").
                pathParam("petId", 77232).log().all().
                when().
                get("/{petId}").
                then().statusCode(200).
                body("name",equalTo("Riley")).
                body("status",equalTo("alive")).log().all();

    }
    @Test(priority = 3)
    public void delRequestWithPathParam() {
        given().
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type", "application/json").
                pathParam("petId", 77232).log().all().
                when().
                delete("/{petId}").
                then().statusCode(200).
                body("message",equalTo("77232")).
                log().all();
    }

}
