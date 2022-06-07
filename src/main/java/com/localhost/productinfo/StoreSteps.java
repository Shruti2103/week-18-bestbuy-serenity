package com.localhost.productinfo;

import com.localhost.constants.EndPoints;
import com.localhost.model.StorePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class StoreSteps {
    @Step("Creating Stores with name : {0}, type: {1}, address: {2}, address2: {3} city : {4}, state: {5}, zip{6}, lat{7},lng{8},hours:{9},services{10}")
    public ValidatableResponse createStore(String name, String type, String address, String address2,
                                           String city, String state, String zip, int lat, int lng, String hours, HashMap<Object, Object> services) {

        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);
        storePojo.setServices(services);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .post(EndPoints.CREATE_SINGLE_STORE)
                .then();
    }

    @Step("Getting the store information with ID: {0}")
    public HashMap<Object, Object> getStoreInfoByID(int storeID) {

        HashMap<Object, Object> storeMap = SerenityRest.given().log().all()
                .when()
                .pathParam("storeID", storeID)
                .get(EndPoints.GET_SINGLE_STORE_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");

        return storeMap;
    }

    @Step("Updating Store information with StoreID:{0}, type: {1}, address: {2}, address2: {3} city : {4}, state: {5}, zip{6}, lat{7},lng{8},hours:{9},services{10}")
    public ValidatableResponse updateStore(int storeID,String name, String type, String address, String address2,
                                           String city, String state, String zip, int lat, int lng, String hours, HashMap<Object, Object> services) {

        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);
        storePojo.setServices(services);

        return SerenityRest.given().log().all()
                .pathParam("storeID", storeID)
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .put(EndPoints.UPDATE_STORE_BY_ID)
                .then();


    }
    @Step("Deleting store information with storeID: {0}")
    public ValidatableResponse deletestore(int storeID){
        return SerenityRest.given().log().all()
                .pathParam("storeID", storeID)
                .when()
                .delete(EndPoints.DELETE_STORE_BY_ID)
                .then();
    }

    @Step("Getting store information with productId: {0}")
    public ValidatableResponse getstortById(int storeID){
        return SerenityRest.given().log().all()
                .pathParam("storeID", storeID)
                .when()
                .get(EndPoints.GET_SINGLE_STORE_BY_ID)
                .then();
    }






}