package test_data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenWeatherMapTestData {

    public Map<String, Float> coordSetUp(){
        Map<String, Float> coord = new HashMap<>();
        coord.put("lon", -0.1257f);
        coord.put("lat", 51.5085f);
        return coord;
    }

    public Map<String, Object> weatherSetUp(){
        Map<String, Object> weather = new HashMap<>();
        weather.put("id", 804);
        weather.put("main", null);
        weather.put("description", "overcast clouds");
        weather.put("icon", "04d");
        return weather;
    }
    List<Map> weather = Arrays.asList(weatherSetUp());

    public Map<String, Float> mainSetUp(){
        Map<String, Float> main = new HashMap<>();
        main.put("temp", 283.59f);
        main.put("feels_like", 282.96f);
        main.put("temp_min", 282.59f);
        main.put("temp_max", 284.82f);
        main.put("pressure", 1010.0f);
        main.put("humidity", 82.0f);
        return main;
    }

    public Map<String, Float> windSetUp(){
        Map<String, Float> wind = new HashMap<>();
        wind.put("speed", 4.63f);
        wind.put("deg", 250.0f);
        return wind;
    }

    public Map<String, Float> rainSetUp(){
        Map<String, Float> rain = new HashMap<>();
        rain.put("1h", 1.42f);
        return rain;
    }

    public Map<String, Integer> cloudsSetUp(){
        Map<String, Integer> cloud = new HashMap<>();
        cloud.put("all", 100);
        return cloud;
    }

    public Map<String, Object> sysSetUp(){
        Map<String, Object> sys = new HashMap<>();
        sys.put("type", 1);
        sys.put("id", 1414);
        sys.put("country", "GB");
        sys.put("sunrise", 1621288258);
        sys.put("sunset", 1621280901);
        return sys;
    }

    public Map<String, Object> expectedDataSetUp(){
        Map<String, Object> expected = new HashMap<>();
        expected.put("coord", coordSetUp());
        expected.put("weather", weatherSetUp());
        expected.put("base", "stations");
        expected.put("main", mainSetUp());
        expected.put("visibility", 10000);
        expected.put("wind", windSetUp());
        expected.put("rain",rainSetUp());
        expected.put("clouds", cloudsSetUp());
        expected.put("dt", 1621287546);
        expected.put("sys", sysSetUp());
        expected.put("timezone", 3600);
        expected.put("id", 2643743);
        expected.put("name", "London");
        expected.put("cod", 200);
        return expected;
    }


}