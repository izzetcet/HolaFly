package pojo_tests;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatePojo;
import pojos.BookingPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequestWithPojo02 extends HerokuappBaseUrl {
    /*
    When
 		I send GET Request to the URL https://restful-booker.herokuapp.com/booking/2
  	Then
 		Status code is 200
 		And response body is like {
                                    "firstname": "Eric",
                                    "lastname": "Brown",
                                    "totalprice": 875,
                                    "depositpaid": false,
                                    "bookingdates": {
                                        "checkin": "2016-11-07",
                                        "checkout": "2020-02-28"
                                    }
     */
    @Test
    public void get01(){
        //set the url
        spec.pathParams("first", "booking","second", 2);

        //Set the expected data
        BookingDatePojo bookingDatePojo = new BookingDatePojo("2015-12-24","2017-10-03");
        BookingPojo expectedPojo = new BookingPojo("Eric","Jones",785,false,bookingDatePojo);
        System.out.println(expectedPojo);

        //send the request
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
        response.prettyPrint();

        //Assert the output

        //1.WAY : Use GSON

        BookingPojo actualPojo=response.as(BookingPojo.class);
        System.out.println(actuelPojo);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedPojo.getFirstName(),actualPojo.getFirstName());
        assertEquals(expectedPojo.getLastName(),actualPojo.getLastName());
        assertEquals(expectedPojo.getTotalPrice(),actualPojo.getTotalPrice());
        assertEquals(expectedPojo.isDepositPaid(),actualPojo.isDepositPaid());
        assertEquals(expectedPojo.getBookingDates().getCheckIn(),actualPojo.getBookingDates().getCheckIn());
        assertEquals(expectedPojo.getBookingDates().getCheckOut(),actualPojo.getBookingDates().getCheckOut());

        //2.WAY: Use Object Mapper
        BookingPojo actualPojo02 = JsonUtil.convertJsonToJava(response.asString(),BookingPojo.class);
        assertEquals(200, response.getStatusCode());
        assertEquals(expectedPojo.getFirstName(),actualPojo02.getFirstName());
        assertEquals(expectedPojo.getLastName(),actualPojo02.getLastName());
        assertEquals(expectedPojo.getTotalPrice(),actualPojo02.getTotalPrice());
        assertEquals(expectedPojo.isDepositPaid(),actualPojo02.isDepositPaid());
        assertEquals(expectedPojo.getBookingDates().getCheckIn(),actualPojo02.getBookingDates().getCheckIn());
        assertEquals(expectedPojo.getBookingDates().getCheckOut(),actualPojo02.getBookingDates().getCheckOut());
    }
}
