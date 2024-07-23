package examples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {


    @Test
    public void getRequestWithQueryParam() {
        Response response = given().baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type", "application/json").
                queryParam("status", "alive").
                log().all().
                when().
                get("/findByStatus");

        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.getHeaders().asList());

        Assert.assertEquals(response.then().extract().path("[0]['status']"), "alive");

    }
@Test
    public void getRequestWithPathParam() {
                given().
                        baseUri("https://petstore.swagger.io/v2/pet").
                        header("Content-Type", "application/json").
                        pathParam("petId", 772321).log().all().
                when().
                        get("/{petId}").
                then().
                        statusCode(200).
                        body("name",equalTo("Riley")).
                        body("status",equalTo("alive")).log().all();

    }

}
