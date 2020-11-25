package apiToTest;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class TestCase1 {

    @Test
    public void GetBookingIds_VerifyStatusCode() {

        // Given
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                // When
                .when()
                .get("/booking")
                // Then
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                // To verify booking id at index 3
                .body("bookingid[3]", equalTo(4));


    }
    @Test
    public void samplePostRequest()
    {
        // There is no need to add escape character manually. Just paste string within double
        // quotes. It will automatically add escape sequence as required.
        String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
        given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(jsonString)
                // WHEN
                .when()
                .post()
                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .body("token", Matchers.notNullValue())
                .body("token.length()", Matchers.is(15))
                .body("token", Matchers.matchesRegex("^[a-z0-9]+$"));

    }
    @Test
    public void implementPutRequest()
    {
        given()
                .baseUri("https://restful-booker.herokuapp.com/booking/1")
                .cookie("token", "f7dddb1093eab19")
                // WHEN
                .when()
                .delete()
                // THEN
                .then()
                .assertThat()
                .statusCode(201);

        // Verifying booking is deleted
        // Given

                given()
                .baseUri("https://restful-booker.herokuapp.com/booking/1")
                // When
                .when()
                .get()
                // Then
                .then()
                .statusCode(404);

    }

}
