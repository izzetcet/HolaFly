package patch_Method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class PatchRequest01 extends JsonPlaceHolderBaseUrl {



    @Test
    public void patch01(){
        //1)Set the url
        spec.pathParams("first", "todos",
                "second", 198);

        //2)Set the expected data
        JsonPlaceHolderTestData expected = new JsonPlaceHolderTestData();

        //3)Send PATCH Request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expected.expectedPatchDataSetUp()).when().patch("/{first}/{second}");
        response.prettyPrint();

        //4)Assert the output
        response.
                then().
                assertThat().
                statusCode(200).
                body("title", Matchers.equalTo(expected.expectedDataSetUp().get("title")),
                        "userId", Matchers.equalTo(expected.expectedDataSetUp().get("userId")),
                        "completed", Matchers.equalTo(expected.expectedDataSetUp().get("completed")));

    }
}


