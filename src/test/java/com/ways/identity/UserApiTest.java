package com.ways.identity;

import io.restassured.http.Header;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
public class UserApiTest extends BaseIntegrationTest {

    @Test
    public void postUserShouldBeSuccefulAndSayBeep() {
        given()
                .port(serverPort)
                .when()
                .contentType("application/json")
                .body("{\"name\":\"someone\", \"email\": \"email@test.com\"}")
                .post("/user")
                .then()
                .assertThat()
                .statusCode(equalTo(CREATED.value()));
    }

    @Test
    public void getUserDetails() {

        given()
                .port(serverPort)
                .when()
                .contentType("application/json")
                .body("{\"name\":\"someone\", \"email\": \"email@test.com\"}")
                .post("/user");

        String responseBody = given()
                .port(serverPort)
                .when()
                .header(new Header("Authorization", "someone"))
                .get("/user")
                .then()
                .assertThat()
                .statusCode(equalTo(OK.value())).extract().body().asString();
        assertThat(responseBody, is(equalTo("{\"name\":\"someone\",\"email\":\"email@test.com\"}")));

    }


}
