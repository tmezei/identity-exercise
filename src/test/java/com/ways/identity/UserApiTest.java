package com.ways.identity;

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
    @Ignore
    public void getUserDetails() {
        String responseBody = given()
                .port(serverPort)
                .when()
                .get("/user")
                .then()
                .assertThat()
                .statusCode(equalTo(OK.value())).extract().body().asString();
        assertThat(responseBody, is(equalTo("")));

    }


}
