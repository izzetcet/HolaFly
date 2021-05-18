package post_method;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class PostRequest02 extends JsonPlaceHolderBaseUrl {
    /*
    When
	  		I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
	  		with the request body {
								    "userId": 55,
								    "title": "Tidy your room",
								    "completed": false
								   }
		Then
			Status code is 200
			And response body is like {
									    "userId": 55,
									    "title": "Tidy your room",
									    "completed": false,
									    "id": 201
									  }
     */
    @Test
    public void post01() {

//1-Set the url
        spec.pathParam("first", "todos");

// 2-Set the expected data
        JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();

// 3-Send POST request

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData.expectedDataSetUp()).when().post("/{first}");
        response.prettyPrint();

//4- Assert output

        //1.WAY BY USING GSON
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(201, response.getStatusCode());
        assertEquals(expectedData.expectedDataSetUp().get("completed"), actualData.get("completed"));
        assertEquals(expectedData.expectedDataSetUp().get("title"), actualData.get("title"));
        assertEquals(expectedData.expectedDataSetUp().get("userId"), actualData.get("userId"));

        //2.Way: JsonPath with Soft Assertion (Verification) ==> a)Create SoftAssert Object b)Use assert methods  c)assertAll()
        JsonPath json = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 201);
        softAssert.assertEquals(json.getBoolean("completed"), expectedData.expectedDataSetUp().get("completed"));
        softAssert.assertEquals(json.getString("title"), expectedData.expectedDataSetUp().get("title"));
        softAssert.assertEquals(json.getInt("userId"), expectedData.expectedDataSetUp().get("userId"));

        softAssert.assertAll();


        //3.Way: By using body()
        response.
                then().
                assertThat().
                statusCode(201).
                body("completed", equalTo(false),
                        "title", equalTo("Tidy your room"),
                        "userId", equalTo(55));

    }





    }
