package get_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static io.restassured.RestAssured.*; //given() icin elle ekledik.otomatik eklenmedi
import static org.junit.Assert.*; // assertTrue icin elle ekledik.otomatik eklenmedi

public class GetRequest03 extends JsonPlaceHolderBaseUrl {

/*
           When
		 	I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/23
		    And Accept type is “application/JSON”
		 Then
		    HTTP Status Code should be 200
		    And Response format should be “application/json”
		    And “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		    And “completed” is false
		    And “userId” is 2
 */

@Test
    public void get01() {
    // 1) Set the URL
    // String url = "https://jsonplaceholder.typicode.com/todos/23"; ====> not recommended
    spec.pathParams("first", "todos", "second", 23);

    //2) Set the expected data

    //3) Send the request
   Response response = given().spec(spec).accept("application/JSON").when().get("/{first}/{second}");
    response.prettyPrint();
    System.out.println("Status code: " + response.getStatusCode());

    //4) Assert the output
/*
            When a test fails, if Java does not execute the next steps it is called "HARD ASERTION"(Assertion)
            But there is another assertion which is "SOFT ASERTION"(Verification), it executes all tests and gives you report about
            the passed ones and failed ones
         */
                    //import org.hamcrest.Matchers;===>IMPORT BODY BU SEKILDEYKEN
//        response.
//                then().
//                assertThat().
//                statusCode(200).
//                contentType("application/json").
//                body("title", Matchers.equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
//                body("completed", Matchers.equalTo(false)).
//                body("userId", Matchers.equalTo(2));




                 //import static org.hamcrest.Matchers.*; ==> IMPORT BODY BU SEKILDEYKEN. Matchers lari sildik.
 //1.WAY++++++
//        response.
//                then().
//                assertThat().
//                statusCode(200).
//                contentType("application/json").
//                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
//                body("completed", equalTo(false)).
//                body("userId", equalTo(2));

   /*
   NOTE: If you use body() for every step it uses HARD ASSERTION
        If you use just single body() with multiple test steps, it gives you report for every failed test
    */
//2.WAY+++++
    response.
            then().
            assertThat().
            statusCode(200).
            contentType("application/json").
            body(               "title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
            "completed", equalTo(false),
                                    "userId", equalTo(2));

    //3.WAY+++
    //HTTP Status Code should be 200
    //assertEquals(expected,actual)
    assertEquals(200, response.getStatusCode());  //mesajsiz
    assertEquals("Status code must be 200",200,response.getStatusCode());// fail olursa mesaj gozukur

    //Response format should be “application/json”
    assertEquals("application/json; charset=utf-8", response.getContentType());
    assertTrue(response.contentType().contains("application/json"));
    assertEquals("ContentType is not in json format ","application/json; charset=utf-8", response.getContentType() );//fail olursa msj cikar

    // “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
    assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));

    //“completed” is false
    assertTrue(response.asString().contains("\"completed\": false"));

    //“userId” is 2
    assertTrue(response.asString().contains("\"userId\": 2"));
}


}