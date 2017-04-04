package com.ways.identity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
public class UserApiTest extends BaseIntegrationTest {

    @Test
    public void postUserShouldBeSuccefulAndSayBeep() {
        final String responseBody = given()
                .port(serverPort)
                .when()
                .post("/user")
                .then()
                .assertThat()
                .statusCode(equalTo(OK.value())).extract().body().asString();

        assertThat(responseBody, is(equalTo("beep")));
    }
}
