package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.*;

public class HolaFlyApi {

    @BeforeMethod
    public void setURL() {
        baseURI = "https://swapi.dev/api/";
    }

    @Test
    public void getPeople() {
        Response response = RestAssured.get("people/1/");

        Assert.assertEquals("statusCode not match with expected", 200, response.statusCode());
        Assert.assertEquals("people name not match with expected", "Luke Skywalker", response.path("name"));
        Assert.assertEquals("people mass not match with expected", "77", response.path("mass"));
        Assert.assertEquals("people height not match with expected", "172", response.path("height"));

        String planet1EndPoint = response.path("homeworld").toString().substring(22);
        Response homeworldResponse = RestAssured.get(planet1EndPoint);

        String homeworldName = homeworldResponse.path("name");
        String homeworldId = planet1EndPoint.substring(planet1EndPoint.length() - 2, planet1EndPoint.length() - 1);

        Assert.assertEquals("homeworldName not match with expected", "Tatooine", homeworldName);
        Assert.assertEquals("homeworldId not match with expected", "1", homeworldId);
    }

    @Test
    public void getPlanet() {
        Response response = RestAssured.get("planets/59/");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals("statusCode not match with expected", 200, response.statusCode());
        Assert.assertEquals("Planet name not match with expected", "Kalee", jsonPath.getString("name"));
        Assert.assertEquals("Planet gravity not match with expected", "1", jsonPath.getString("gravity"));
    }

    @Test
    public void calculoPesoPersonaje() {
        Random rnd = new Random();
        int randomId = rnd.nextInt(82) + 1;

        Response peopleResponse = RestAssured.get("people/" + randomId + "/");
        peopleResponse.then().statusCode(200);

        String planetEndPoint = peopleResponse.path("homeworld").toString().substring(22);

        Response homeworldResponse = RestAssured.get(planetEndPoint);
        homeworldResponse.then().statusCode(200);

        String masaPersonaje = peopleResponse.path("mass");
        String gravedadPlaneta = homeworldResponse.path("gravity").toString().substring(0, 1);

        if (masaPersonaje.equals("unknown") || gravedadPlaneta.equals("unknown")) {
            System.out.println("masaPersonaje or gravedadPlaneta is unknown");
        } else {
            int PesoPersonaje = Integer.parseInt(masaPersonaje) * Integer.parseInt(gravedadPlaneta);
            System.out.println("Peso_Personaje = " + PesoPersonaje);
        }
    }
}
