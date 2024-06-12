package activities;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {
    @Test(priority = 1)
    public void postRequestWithPathParam() throws IOException {
        FileInputStream inputreq=new FileInputStream("C:/Users/NikhilPatil/IdeaProjects/FST_RESTAssured/src/test/java/activities/Activity2user.json");
        String reqBody=new String(inputreq.readAllBytes());

        given().
                baseUri("https://petstore.swagger.io/v2/user").
                header("Content-Type", "application/json").body(reqBody).log().all().
                when().
                post().
                then().
                statusCode(200).body("message",equalTo("90015")).log().all();
        inputreq.close();

    }
    @Test(priority = 2)
    public void getRequestWithPathParam() {
        given().
                baseUri("https://petstore.swagger.io/v2/user").
                header("Content-Type", "application/json").
                pathParam("username", "Niksuser").log().all().
                when().
                get("/{username}").
                then().statusCode(200).
                body("username",equalTo("Niksuser")).body("id",equalTo(90015)).
                log().all();

    }
    @Test(priority = 3)
    public void delRequestWithPathParam() {
        given().
                baseUri("https://petstore.swagger.io/v2/user").
                header("Content-Type", "application/json").
                pathParam("username", "Niksuser").log().all().
                when().
                delete("/{username}").
                then().statusCode(200).
                body("message",equalTo("Niksuser")).
                log().all();
    }

}
