package object_mapper;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ObjectMapper02 extends HerokuappBaseUrl {
    /*
    When
 		I send GET Request to the URL https://restful-booker.herokuapp.com/booking/2
 	Then
 		Status code is 200
 		And response body is like {
                                    "firstname": "Jim",
                                    "lastname": "Smith",
                                    "totalprice": 363,
                                    "depositpaid": false,
                                    "bookingdates": {
                                        "checkin": "2020-06-24",
                                        "checkout": "2021-02-12"
                                     }
                                  }
     */
    @Test
    public void get01(){
        //1 SET THE URL
     spec.pathParams("first", "booking","second", 2);

     //2 SET THE EXPECTED DATA

        String expected = "{\n" +
                "\"firstname\": \"Jim\",\n" +
                "\"lastname\": \"Smith\",\n" +
                "\"totalprice\": 363,\n" +
                "\"depositpaid\": false,\n" +
                "\"bookingdates\": {\n" +
                "\"checkin\": \"2018-01-01\",\n" +
                "\"checkout\": \"2019-01-01\"\n" +
                "}\n" +
                "}";

       HashMap<String,Object> expectedMap= JsonUtil.convertJsonToJava(expected, HashMap.class);

       //3 SEND THE REQUEST
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        HashMap<String,Object> actualMap = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);

        // Assert the output
//        assertEquals(expectedMap.get("firstname"), actualMap.get("firstname"));
//        assertEquals(expectedMap.get("lastname"), actualMap.get("lastname"));
//        assertEquals(expectedMap.get("totalprice"), actualMap.get("totalprice"));
//        assertEquals(expectedMap.get("depositpaid"), actualMap.get("depositpaid"));
//        assertEquals(((Map)expectedMap.get("bookingdates")).get("checkin"), ((Map)actualMap.get("bookingdates")).get("checkin"));
//        assertEquals(((Map)expectedMap.get("bookingdates")).get("checkout"), ((Map)actualMap.get("bookingdates")).get("checkout"));

        assertEquals(expectedMap.get("bookingdates.checkin"), (actualMap.get("bookingdates.checkin")));  // 2.WAY
        assertEquals(expectedMap.get("bookingdates.checkout"), (actualMap.get("bookingdates.checkout"))); // 2.WAY
    }
}
