package get_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class GetRequest09 extends HerokuappBaseUrl {

    /*
    When
	 		I send GET Request to https://restful-booker.herokuapp.com/booking/1
	 	Then
	 		Response body should be like that;
	 		{
			    “firstname”: “Eric”,
			    “lastname”: “Smith”,
			    “totalprice”: 555,
			    “depositpaid”: false,
			    “bookingdates”: {
			        “checkin”: “2016-09-09”,
			        “checkout”: “2017-09-21”
			     }
			}
     */

        @Test
    public void get01(){
            //Set the url

            spec.pathParams("first", "booking", "second", 1);

            // Set te ecpected data
            Map<String,String> bookingdates = new HashMap<>();
            bookingdates.put( "checkin", "2015-09-26");
            bookingdates.put( "checkout", "2017-12-05");


            Map<String,Object> expectedDataMap = new HashMap<>();
            expectedDataMap.put("firstname", "Mary");
            expectedDataMap.put("lastname", "Jackson");
            expectedDataMap.put("totalprice", 988);
            expectedDataMap.put("depositpaid", false);
            expectedDataMap.put("bookingdates", bookingdates);

            System.out.println(expectedDataMap);

        //Send the request
            Response responce =given().spec(spec).when().get("/{first}/{second}");
            responce.prettyPrint();


            // Use GSON for de-seralization
                Map<String,Object> actualDataMap = responce.as(HashMap.class);
                System.out.println(actualDataMap);


//            assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
//            assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
//            assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
//            assertEquals(expectedDataMap.get("depozitpaid"), actualDataMap.get("depozitpaid"));
    assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"), ((Map)actualDataMap.get("bookingdates")).get("checkin"));
    assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"), ((Map)actualDataMap.get("bookingdates")).get("checkout"));







        }




}
