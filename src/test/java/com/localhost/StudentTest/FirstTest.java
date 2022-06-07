package com.localhost.StudentTest;

import com.localhost.constants.EndPoints;
import com.localhost.testbase.TestBase;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class FirstTest extends TestBase {

    @Test
    public void getAllProductsInfo() {
        SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_PRODUCTS)
                .then().log().all();


    }

    }
