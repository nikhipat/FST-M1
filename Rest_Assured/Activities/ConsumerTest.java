package liveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    Map<String,String> headers=new HashMap<>();
    @Pact(consumer="UserConsumer",provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        //Header
        headers.put("Content-Type","application/json");

        //Request and Response details
        DslPart requestBody=new PactDslJsonBody().
                numberType("id",5555).
                stringType("firstName","nikhil").
                stringType("lastName","paitl").
                stringType("email","email@mail.com");

        DslPart responseBody=new PactDslJsonBody().
                numberType("id",5555).
                stringType("firstName","nikhil").
                stringType("lastName","paitl").
                stringType("email","email@mail.com");

        //fragment
        return builder.given("POST Request").
                uponReceiving("Receiving post request to create Request").
                method("POST").path("/api/users").
                headers(headers).body(requestBody).
                willRespondWith().status(201).body(responseBody).toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider",port = "8282")
    public void postRequestTest(){
        Map<String,Object> reqBody=new HashMap<>();
        reqBody.put("id",5555);
        reqBody.put("firstName","nikhil");
        reqBody.put("lastName","patil");
        reqBody.put("email","email@mail.com");

        given().baseUri("http://localhost:8282").headers(headers).
                body(reqBody).log().all().
                when().post("/api/users").
                then().statusCode(201).
                body("firstName",equalTo("nikhil")).log().all();
    }

}
