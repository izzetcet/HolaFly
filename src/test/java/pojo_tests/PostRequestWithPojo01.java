package pojo_tests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.TodosPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


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
        System.out.println("Coming from GSON: " + actualPojo);

       assertEquals(201, response.getStatusCode());
        assertEquals(expectedPojo.getTitle(),actualPojo.getTitle());
        assertEquals(expectedPojo.getUserId(),actualPojo.getUserId());
        assertEquals(expectedPojo.isCompleted(),actualPojo.isCompleted());



        //2.WAY :Use O  bject Mapper Class
        TodosPojo actualPojo2 = JsonUtil.convertJsonToJava(response.asString(), TodosPojo.class);
        System.out.println("Comin from Object Mapper: " + actualPojo2);

        assertEquals(201, response.getStatusCode());
        assertEquals(expectedPojo.getTitle(),actualPojo2.getTitle());
        assertEquals(expectedPojo.getUserId(),actualPojo2.getUserId());
        assertEquals(expectedPojo.isCompleted(),actualPojo2.isCompleted());


    }
}
