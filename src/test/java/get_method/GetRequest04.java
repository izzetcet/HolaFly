package get_method;

import base_urls.DummyBaseUrl;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*; //given() icin elle ekledik.otomatik eklenmedi

public class GetRequest04 extends JsonPlaceHolderBaseUrl {
    /*
            When
        I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos
          And Accept type is "application/json"
          Then
          HTTP Status Code should be 200
          And Response format should be "application/json"
          And there should be 200 todos
          And "quis eius est sint explicabo" should be one of the todos
          And 2, 7, and 9 should be among the userIds
     */
    @Test
    public void get01(){
        // Set the url
        spec.pathParams("first","todos");


        // Set expected data


        //3) Send the request
        Response response = given().spec(spec).accept("application/json").when().get("/{first}");
        response.prettyPrint();

        // 4) Assert the output
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", Matchers.hasSize(200)).
                body("title", Matchers.hasItem("quis eius est sint explicabo")).
                body("userId", Matchers.hasItems(2,7,9));


    }




}
