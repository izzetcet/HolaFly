package get_method;

import base_urls.OpenWeatherBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.OpenWeatherMapTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest10 extends OpenWeatherBaseUrl {
/*
        When
	 		I send GET Request to the Url https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0
	 	Then
	 		Status code is 200
	 		And Response body is like {
										    "coord": {
										        "lon": -0.13,
										        "lat": 51.51
										    },
										    "weather": [
										        {
										            "id": 801,
										            "main": "Clouds",
										            "description": "few clouds",
										            "icon": "02n"
										        }
										    ],
										    "base": "stations",
										    "main": {
										        "temp": 284.57,
										        "feels_like": 280.6,
										        "temp_min": 283.71,
										        "temp_max": 285.37,
										        "pressure": 1007,
										        "humidity": 81
										    },
										    "visibility": 10000,
										    "wind": {
										        "speed": 5.1,
										        "deg": 160
										    },
										    "clouds": {
										        "all": 20
										    },
										    "dt": 1608329611,
										    "sys": {
										        "type": 1,
										        "id": 1414,
										        "country": "GB",
										        "sunrise": 1608278540,
										        "sunset": 1608306738
										    },
										    "timezone": 0,
										    "id": 2643743,
										    "name": "London",
										    "cod": 200
										}
 */
    @Test
    public void get01(){
    //1 set the url
        //https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0
        spec.pathParams("first", "data",
                "second", 2.5, "third","weather").
            queryParams("q","London",
                    "appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");

    // 2) Set the expected data
        OpenWeatherMapTestData expectedData = new OpenWeatherMapTestData();


    // 3) Sen the request
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();
     // 4) Assert outputs
//         assertEquals(200, response.getStatusCode());
//         assertEquals(expectedData.coordSetUp().get("lon"), (Float)json.getFloat("coord.lon"));
//         assertEquals(expectedData.coordSetUp().get("lat"), (Float)json.getFloat("coord.lat"));
//         assertEquals(expectedData.weatherSetUp().get("id"), json.getInt("weather[0].id") );
//         assertEquals(expectedData.weatherSetUp().get("main"), json.getString("weather[0].rain") );
//         assertEquals(expectedData.weatherSetUp().get("description"), json.getString("weather[0].description") );
//         assertEquals(expectedData.weatherSetUp().get("icon"), json.getString("weather[0].icon") );
//        assertEquals(expectedData.expectedDataSetUp().get("base"), json.getString("base") );
//        assertEquals(expectedData.mainSetUp().get("temp"), (Float)json.getFloat("main.temp"));
//        assertEquals(expectedData.mainSetUp().get("feels_like"), (Float)json.getFloat("main.feels_like"));
//        assertEquals(expectedData.mainSetUp().get("temp_min"), (Float)json.getFloat("main.temp_min"));
//        assertEquals(expectedData.mainSetUp().get("temp_max"), (Float)json.getFloat("main.temp_max"));
//        assertEquals(expectedData.mainSetUp().get("pressure"), (Float)json.getFloat("main.pressure"));
//        assertEquals(expectedData.mainSetUp().get("humidity"), (Float)json.getFloat("main.humidity"));
//        assertEquals(expectedData.expectedDataSetUp().get("visibility"), json.getInt("visibility"));
//        assertEquals(expectedData.windSetUp().get("speed"), (Float)json.getFloat("wind.speed"));
//        assertEquals(expectedData.windSetUp().get("deg"), (Float)json.getFloat("wind.deg"));
//        assertEquals(expectedData.rainSetUp().get("1h"), (Float)json.getFloat("rain.1h"));
//        assertEquals(expectedData.cloudsSetUp().get("all"), (Integer)json.getInt("clouds.all"));
//        assertEquals(expectedData.expectedDataSetUp().get("dt"), json.getInt("dt"));
//        assertEquals(expectedData.sysSetUp().get("type"), json.getInt("sys.type"));
//        assertEquals(expectedData.sysSetUp().get("id"), json.getInt("sys.id"));
//        assertEquals(expectedData.sysSetUp().get("country"), json.getString("sys.country"));
//        assertEquals(expectedData.sysSetUp().get("sunrise"), json.getInt("sys.sunrise"));
        assertEquals(expectedData.sysSetUp().get("sunset"), json.getInt("sys.sunset"));
        assertEquals(expectedData.expectedDataSetUp().get("timezone"), json.get("timezone"));
        assertEquals(expectedData.expectedDataSetUp().get("id"), json.get("id"));
        assertEquals(expectedData.expectedDataSetUp().get("name"), json.get("name"));
        assertEquals(expectedData.expectedDataSetUp().get("cod"), json.get("cod"));







    }

}
