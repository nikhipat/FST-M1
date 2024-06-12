package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Activity3 {
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
        reqbody.put("name", "Riley");
        reqbody.put("status", "alive");
        Response response = given().spec(requestSpec).
                body(reqbody).log().all().
                when().
                post();

        petId = response.then().extract().path("id");
        response.then().spec(responseSpec).body("name", equalTo("Riley"));
        Map<String, Object> reqbody2 = new HashMap<>();
        reqbody2.put("id", 5557);
        reqbody2.put("name", "Hansel");
        reqbody2.put("status", "alive");
        Response response2 = given().spec(requestSpec).
                body(reqbody2).log().all().
                when().
                post();

        petId = response.then().extract().path("id");
        response.then().spec(responseSpec).body("name", equalTo("Hansel"));
    }
    @DataProvider
    public Object [][] petDetails(){
        Object[][] testData=new Object[][]{
                {5555,"Riley","alive"},
                {5557, "Hansel","alive",}
        };
        return testData;
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
