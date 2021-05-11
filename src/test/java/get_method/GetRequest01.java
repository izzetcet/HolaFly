package get_method;
import static io.restassured.RestAssured.*; //given() icin elle ekledik.otomatik eklenmedi
import io.restassured.response.Response;
import org.junit.Test;

public class GetRequest01 {
    /*
    In API test cases and automation scprits we use "GIVEN", 'WHEN", 'THEN", and "AND"
    GIVEN: It declares prerequisites
    WHEN: It declares the action which user will perform
    THEN : It declares outputs
    AND : It can be used after GIVEN after WHEN and after THEN for multiple actions
     */

    /*
    When
       I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
    Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01(){

    // 1) Set the URL
    String url="https://restful-booker.herokuapp.com/booking/3";
    //2) Set the expected data (We will learn later)

    //3) Type automation script to send GET request

    Response response = given().when().get(url);
    response.prettyPrint();

    //4) Assert (verify) the output
    response.
            then().
            assertThat().
            statusCode(200).
            contentType("application/json").
            statusLine("HTTP/1.1 200 OK");
    //How to print content-type, status code, status line, etc on the console
       System.out.println("Status code: " + response.getStatusCode());
        System.out.println("ContentType: " +response.getContentType());
        System.out.println("StatusLine: " + response.getStatusLine());
        System.out.println("All Headers:\n" + response.getHeaders());
        System.out.println("Server: " + response.getHeader("Server"));
        System.out.println("Time: " + response.getTime());
}


}
