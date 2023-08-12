package get_method;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
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
        response.then().statusCode(200);

        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getString("name"));
        String masa=jsonPath.getString("mass");
        System.out.println(jsonPath.getString("height"));
        System.out.println(jsonPath.getString("homeworld"));


        String planetEndPoint= jsonPath.getString("homeworld").substring(22);
        Response homeworld = RestAssured.get(planetEndPoint);
        response.then().statusCode(200);
        homeworld.prettyPrint();
        String homeworldName = homeworld.path("name");
        String homeworldId= planetEndPoint.substring(planetEndPoint.length()-2, planetEndPoint.length()-1);
        System.out.println(homeworldName + " " + homeworldId);

        String gravedad = homeworld.path("gravity").toString().substring(0,1);
    }

    @Test
    public void getPlanet() {
        Response response = RestAssured.get("planets/1/");
        response.then().statusCode(200);
        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getString("name"));
        String gravedad=jsonPath.getString("gravity");

    }

    @Test
    public void peso(){
        Random rnd = new Random();
       int randomId=  rnd.nextInt(82)+1;

        Response response = RestAssured.get("people/"+randomId+"/");
        response.then().statusCode(200);

        response.prettyPrint();

        String masa=response.path("mass");



        String planetEndPoint= response.path("homeworld").toString().substring(22);
        Response homeworld = RestAssured.get(planetEndPoint);
        response.then().statusCode(200);

        String gravedad = homeworld.path("gravity").toString().substring(0,1);
        homeworld.prettyPrint();
if(masa.equals("unknown")||gravedad.equals("unknown") ) {
    System.out.println("masa or gravedad is unknown");
}else {
    int Peso_Personaje = Integer.parseInt(masa) * Integer.parseInt(gravedad);
    System.out.println("Peso_Personaje = " + Peso_Personaje);
}
    }

}
