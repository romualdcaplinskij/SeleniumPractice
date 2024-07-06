import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestTest {

    @Test
    public void getUserWithId(){
        String userId = "6949872";
        given().
                pathParam("id", userId)
        .when().
                get("https://gorest.co.in/public/v2/users/{id}")
        .then().
                statusCode(200)
                .assertThat().
                body("gender", equalTo("male"), "status", equalTo("inactive")).
                log().all();
    }

    @Test
    public void userListFromPage(){
        String pageNr = "5";
        given().
                pathParam("page", pageNr).
        when().
                get("https://gorest.co.in/public/v2/users?page={page}&per_page=20").
        then().
                statusCode(200).
        assertThat().
                body("per_page", hasSize(20));
    }

    @Test
    public void createUser() {
        String name = "Petras Grazulis";
        String email = "petrasg@gay.lt";
        String gender = "male";
        String status = "active";
        when().
                post("/public/v2/users").
                then().statusCode(201);
    }
}
