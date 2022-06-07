package com.localhost.productinfo;

import com.localhost.constants.EndPoints;
import com.localhost.model.ProductPojo;
import com.localhost.model.ServicesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ServicesSteps {
         @Step("Creating services with name : {0}")
         public ValidatableResponse createServices(String name){
          ServicesPojo servicesPojo=new ServicesPojo();
          servicesPojo.setName(name);

             return SerenityRest.given().log().all()
                     .contentType(ContentType.JSON)
                     .body(servicesPojo)
                     .when()
                     .post(EndPoints.CREATE_SINGLE_SERVICES)
                     .then();


         }
    @Step("Getting the Services information with ID: {0}")
    public HashMap<Object, Object> getServicesInfoByID(int servicesID) {

     HashMap<Object, Object> servicesMap = SerenityRest.given().log().all()
                .when()
                .pathParam("servicesID",servicesID)
                .get(EndPoints.GET_SINGLE_SERVICES_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");

        return servicesMap;
    }
    @Step("Updating services information with servicesId:  {0}, name: {1}")
    public ValidatableResponse updateServices(int servicesID, String name ) {
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);

        return SerenityRest.given().log().all()
                .pathParam("servicesID",servicesID)
                .contentType(ContentType.JSON)
                .body(servicesPojo)
                .when()
                .put(EndPoints.UPDATE_SERVICES_BY_ID)
                .then();

    }

    @Step("Deleting services information with servicesID: {0}")
    public ValidatableResponse deleteServices(int servicesID){
        return SerenityRest.given().log().all()
                .pathParam("servicesID", servicesID)
                .when()
                .delete(EndPoints.DELETE_SERVICES_BY_ID)
                .then();
    }

    @Step("Getting services information with servicesID: {0}")
    public ValidatableResponse getServicesById(int servicesID){
        return SerenityRest.given().log().all()
                .pathParam("servicesID", servicesID)
                .when()
                .get(EndPoints.GET_SINGLE_SERVICES_BY_ID)
                .then();
    }









}
