package put_pethod;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class PutRequest01 extends JsonPlaceHolderBaseUrl {
    /*
    When
	 		I send PUT Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    “userId”: 21,
										    “title”: “Wash the dishes”,
										    “completed”: false
										   }
	   Then
	   	   Status code is 200
	   	   And response body is like   {
									    “userId”: 21,
									    “title”: “Wash the dishes”,
									    “completed”: false,
									    “i
     */
    @Test
    public void put01 (){
    // 1 Set the url
    spec.pathParams("first", "todos", "second", "198");

    // 2 Set the expected data
        JsonPlaceHolderTestData expected = new JsonPlaceHolderTestData();


        //3 Send the PUT request
Response response = given().spec(spec).contentType(ContentType.JSON).body(expected.expectedDataSetUp()).when().put("/{first}/{second}");
response.prettyPrint();








    }
}
