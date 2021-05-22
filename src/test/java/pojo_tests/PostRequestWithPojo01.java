package pojo_tests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.TodosPojo;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo01 extends JsonPlaceHolderBaseUrl {
    /*
    When
	 		I send POST Request to the URL https://jsonplaceholder.typicode.com/todos
	 		with Post Request body  {
									    "userId": 21,
									    "id": 201,
									    "title": "Tidy your room",
									    "completed": false
									  }
	 	Then
	 		Status code is 201
	 		And response body is like {
									    "userId": 21,
									    "id": 201,
									    "title": "Tidy your room",
									    "completed": false
									  }
     */
    @Test
    public void post01(){
        // set the url
        spec.pathParam("first", "todos");

        //Set the expected data
        TodosPojo expectedPojo = new TodosPojo(21, "Tidy your room",false);
        System.out.println(expectedPojo);

    //Send the request
        Response response  = given().spec(spec).contentType(ContentType.JSON).body(expectedPojo).post("/{first}");
        response.prettyPrint();

    //Assert the output
        //1,WAY : Use GSON to convert response body to  TodosPojo\
        TodosPojo actualPojo =response.as(TodosPojo.class);
        System.out.println(actualPojo);
    }
}
