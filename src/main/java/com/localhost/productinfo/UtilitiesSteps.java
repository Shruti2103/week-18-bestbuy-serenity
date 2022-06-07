package com.localhost.productinfo;

import com.localhost.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UtilitiesSteps {

    @Step("Getting store information of utilities: {0}")
    public ValidatableResponse getVersiondetal() {
        return SerenityRest
                .given()
                .when()
                .get(EndPoints.GET_ALL_UTILITIES)
                .then();
    }

    @Step("Getting store information of utilities: {0}")
    public ValidatableResponse getHealthcheckupDetail() {
        return SerenityRest
                .given()
                .when()
                .get(EndPoints.GET_ALL_Healthcheck)
                .then();
    }




}
