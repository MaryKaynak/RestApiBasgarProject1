import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import model.Location;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LocationTest {

    private Cookies cookies;

    @BeforeClass
    public void authenticate(){
        RestAssured.baseURI = "https://test-basqar.mersys.io";
        Map<String, String> credentials = new HashMap<>();
        credentials.put( "username", "nigeria_tenant_admin" );
        credentials.put( "password", "TnvLOl54WxR75vylop2A" );

        cookies = given()
                .body( credentials )
                .contentType( ContentType.JSON )
                .when()
                .post( "/auth/login" )
                .then()
                .statusCode( 200 )
                .extract().response().getDetailedCookies();
    }
    @Test
    public void getBasePath(){
        given()
                .when()
                .get("https://test-basqar.mersys.io/")
                .then()
                .statusCode(200);
    }

    @Test
    public void getlocation(){
        given()
                .cookies(cookies)
                .when()
                .get("https://test-basqar.mersys.io/")
                .then()
                .statusCode(200);
    }
    @Test
    public void createLocation(){
        Location location = new Location();
        location.setName("Hilal");
        location.setShortName("HK");
        location.setCapacity("8");
        location.setLocationType("Class");
        location.setSchool("Techno");
        location.setActive("true");

      String  Location = given().
                cookies(cookies).
                body(location).
                contentType(ContentType.JSON).
                when()
                .post("https://test-basqar.mersys.io/school-service/api/school/5e035f8c9ea1a129f71ac585/location").
                        then().
                        statusCode(201).
                        extract().
                        jsonPath().
                        getString("Location");


    }
}