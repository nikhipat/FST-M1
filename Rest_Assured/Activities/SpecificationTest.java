package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SpecificationTest {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int petId;

    String baseuri = "https://petstore.swagger.io/v2/pet";

    @BeforeClass
    public void SetUp() {
        requestSpec = new RequestSpecBuilder().setBaseUri(baseuri).
                addHeader("Content-Type", "application/json").
                build();
        //addHeader("Authorization","token ghp_")
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).
                expectContentType(ContentType.JSON).expectResponseTime(lessThanOrEqualTo(4000L)).build();
    }

    @Test(priority = 1)
    public void postpetBuild() {
        Map<String, Object> reqbody = new HashMap<>();
        reqbody.put("id", 5555);
        reqbody.put("name", "Jack");
        reqbody.put("status", "alive");
        Response response = given().spec(requestSpec).
                body(reqbody).log().all().
                when().
                post();

        petId = response.then().extract().path("id");
        response.then().spec(responseSpec).body("name", equalTo("Jack"));
    }

    @Test(priority = 2)
    public void getpetBuild() {
        given().spec(requestSpec).
                pathParam("petId", petId).log().all().
                when().
                get("/{petId}").
                then().spec(responseSpec);
    }

    @Test(priority = 3)
    public void delpetBuild() {
        given().spec(requestSpec).
                pathParam("petId", petId).
                when().
                delete("/{petId}").
                then().spec(responseSpec).body("message", equalTo(""+petId));
    }

}
