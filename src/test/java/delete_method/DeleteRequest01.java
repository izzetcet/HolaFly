package delete_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeleteRequest01 extends JsonPlaceHolderBaseUrl {
   /*
    When
      I send DELETE Request to the Url https://jsonplaceholder.typicode.com/todos/198
    Then
    Status code is 200
    And Response body is {}
    */
@Test
    public void deleteo1(){
   //1- Set the url
    spec.pathParams("first", "todos",
            "second", 198);

    // 2 Set the expected data
    Map<String,Object> expeceted = new HashMap<>();

    // 3 Send the DELETE request
    Response response = given().spec(spec).when().delete("/{first}/{second}");


    Map<String,Object> actual = response.as(HashMap.class); //GSON: De-serialization
    // 4 Assert the output
    response.then().assertThat().statusCode(200);

    assertEquals(expeceted,actual);




}






}
