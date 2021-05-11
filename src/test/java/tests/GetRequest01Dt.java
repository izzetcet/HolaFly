package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01Dt {
    /*
  ==GHERKIN LANGUAGE==
  If you use "Given" "When" "Then" "And" to create test  scenerios it means you are using Gherkin Language
  Given: It declares prerequisites
  Then: It defines actions which user  will perform
  When: We talk about outcomes
  And: In any part if you have multiple steps use "and" between them
     */
/*
       When
           I send a GET Request to the URL https://api-techproed-test.herokuapp.com/courses
       Then
           HTTP Status Code should be 200
       And
           Content Type should be JSON
       And
           Status Line should be HTTP/1.1 200 OK
   */
@Test
public void get01(){
/*
We will follow this 4 steps in each test in API
1- Set the url
2- Set the expected data (we will learn it later)
3- Send the request (Like clicking on Send botton in the Postman)
4- Assert the things whic are given in the test case
 */
    String url ="https://api-techproed-test.herokuapp.com/courses";
    Response response = given().
                            accept(ContentType.JSON). //We can put  "application/json" instead of ContentType.JSON
                        when().                        // It is not must to use accept() method
                            get(url);

//response.prettyPrint();

response.
        then().
        assertThat().
        statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

// How to print status code, content type, statusline , time in the console
    System.out.println(response.getStatusLine());
    System.out.println(response.statusCode());
    System.out.println(response.getContentType());
    System.out.println(response.getTime());
    System.out.println(response.getHeaders());





















}



}
