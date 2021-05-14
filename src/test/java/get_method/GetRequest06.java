package get_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;  // assertEquals() icin elle ekledik

public class GetRequest06 extends HerokuappBaseUrl {
    /*
    When
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5
	  Then
		  HTTP Status Code should be 200
		  And response content type is “application/JSON”
		  And response body should be like;
		  { “firstname”: “Sally”,
		    “lastname”: “Ericsson”,
		    “totalprice”: 111,
		    “depositpaid”: false,
		    “bookingdates”: { “checkin”: “2017-05-23",
		                      “checkout”:“2019-07-02" }
		  }
     */
    @Test

    // 1) Set the url
    public void get01() {
        spec.pathParams("first","booking","second",5);

    // 2) Set the expected data

    // 3) Send request
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
    // 4)Assert the output
        // I.WAY
//        response.
//            then().
//            assertThat().
//            statusCode(200).
//            contentType(ContentType.JSON).
//            body("firstname", equalTo("Susan"),
//                    "lastname", equalTo("Ericsson"),
//                    "depositpaid",equalTo(false),
//                    "tottalprice", equalTo(null),
//                    "bookingdates.checkin", equalTo("2020-04-07"),
//                      "bookingdates.checkout", equalTo("2021-01-22"));

        // JsonPath is used to navigate inside Json Data
            JsonPath json = response.jsonPath();



        // II.WAY
      assertEquals("Status code is not matching", 200, response.getStatusCode());
      assertEquals("content type is not json", "application/json; charset=utf-8", response.getContentType());
//      assertEquals("Firstname is not matching", "Mary", json.getString("firstname"));
//      assertTrue("Lastname is not matching", json.getString("lastname").equals("Brown"));
//      assertTrue("Total price os not matching", json.getInt("totalprice")==703);
//      assertTrue("depositpaid is not matching", json.getBoolean("depositpaid")==false);
//      assertEquals("checkin is not matching","2021-04-07", json.getString("bookingdates.checkin"));
//      assertTrue("checkout is not matching ", json.getString("bookingdates.checkout").equals("2020-04-16"));


        // 3.WAY
        /*
        SoftAssertion (Verification): Execution is not stopped in failure

        To use soft assertion we have 3 steps:
        1- Create an object from SoftAssert class
        2-By using the object, use  assertEquals(), assertTrue and assertFalse
=====>  3- DONT FORGET to use "assertAll()" method at the and <======
        */

        // 1- Create an object from SoftAssert class
        SoftAssert softAssert = new SoftAssert();

        //2-By using the object, use  assertEquals(), assertTrue and assertFalse
        softAssert.assertEquals(json.getString("firstname"),"Sally", "firstname is not matching");
        softAssert.assertEquals(json.getString("lastname"),"Jones", "laststname is not matching");
        softAssert.assertEquals(json.getInt("totalprice"),298, "totalprice is not matching");


        //3- DONT FORGET to use "assertAll()" method at the and
        softAssert.assertAll();
    }
}
