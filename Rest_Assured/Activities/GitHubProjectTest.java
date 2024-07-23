package liveProject;

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

public class GitHubProjectTest {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String baseuri="https://api.github.com";
    String token="token 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";

    String sshkey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIInOktZgPRIBnk2ZvC8OBZ8OPA1u3XJjvLmLvAfaGoac";
    int sshkeyId;

    @BeforeClass
    public void SetUp() {
        requestSpec = new RequestSpecBuilder().setBaseUri(baseuri).
                addHeader("Content-Type", "application/json").
                addHeader("Authorization",token).
                build();
        //addHeader("Authorization","token ghp_")
        responseSpec = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).expectResponseTime(lessThanOrEqualTo(4000L)).build();
    }
    @Test(priority =1)
    public void PostGitTest(){
        Map<String, Object> reqbody = new HashMap<>();
        reqbody.put("title", "TestAPIKey");
        reqbody.put("key", sshkey);
        Response response = given().spec(requestSpec).
                body(reqbody).log().all().
                when().post("/user/keys");

        sshkeyId = response.then().extract().path("id");
        System.out.println(sshkeyId);
        response.then().statusCode(201).spec(responseSpec).log().all();
    }
    @Test(priority = 2)
    public void GetGitTest(){
        given().spec(requestSpec).pathParam("sshkeyId",sshkeyId).log().all().
                when().get("/user/keys/{sshkeyId}").
                then().statusCode(200).spec(responseSpec).log().all();
    }
    @Test(priority = 3)
    public void DelGitTest(){
        given().spec(requestSpec).pathParam("sshkeyId",sshkeyId).log().all().
                when().
                delete("/user/keys/{sshkeyId}").
                then().statusCode(204).log().all();
    }

}
