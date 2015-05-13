package com.thoughtworks.fam.security;

import com.thoughtworks.fam.Application;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * Created by Brenda on 5/9/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, SecurityTestConfig.class})
@WebIntegrationTest
public class SecurityIntegrationTest {

    @Test
    public void should_reject_request_when_access_assets_without_credentials() throws Exception {
        when().get("/assets/owner").
                then().statusCode(UNAUTHORIZED.value());
    }

    @Ignore
    @Test
    public void should_access_assets_with_credentials() throws Exception {
        given().
                auth().preemptive().basic("user", "password").
                when().get("assets/owner").
                then().statusCode(OK.value());
    }

    @Test
    public void should_not_access_without_correct_password() throws Exception {
        given().
                auth().preemptive().basic("user","pass").
                when().get("assets/owner").
                then().statusCode(UNAUTHORIZED.value());

    }

    @Test
    public void should_not_access_without_correct_user_name() throws Exception {
        given().
                auth().preemptive().basic("usera","password").
                when().get("assets/owner").
                then().statusCode(UNAUTHORIZED.value());

    }
}
