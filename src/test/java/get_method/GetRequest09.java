package get_method;

import base_urls.HerokuappBaseUrl;
import org.junit.Test;

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

            spec.pathParams("first", booking, "second", 1);

            // Set te ecpected data


        }




}
