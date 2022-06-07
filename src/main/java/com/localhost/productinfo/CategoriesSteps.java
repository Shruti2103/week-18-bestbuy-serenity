package com.localhost.productinfo;


import com.localhost.constants.EndPoints;

import com.localhost.model.CategoriesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Jay
 */
public class CategoriesSteps {

    @Step("Creating Categories with id : {0}")
    public ValidatableResponse createCategories(String id, String name) {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId(id);
        categoriesPojo.setName(name);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .post(EndPoints.CREATE_SINGLE_CATEGORIES)
                .then();
    }

    @Step("Getting the categories information with id: {0},name:{1}")
    public HashMap<Object, Object> getCategoriesBYID(String categoriesID) {

        HashMap<Object, Object> categoriesMap = SerenityRest.given().log().all()
                .when()
                .pathParam("categoriesID",categoriesID)
                .get(EndPoints.GET_SINGLE_CATEGORIES_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");

        return categoriesMap;
    }

    @Step("Updating Categories information with id: {0}, name: {1}" )
    public ValidatableResponse updateCategories(String categoriesID,String id, String name ) {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId("3");
        categoriesPojo.setName(name);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("categoriesID", categoriesID)
                .body(categoriesPojo)
                .when()
                .put(EndPoints.UPDATE_CATEGORIES_BY_ID)
                .then();
    }

    @Step("Deleting Categories information with id: {0}")
    public ValidatableResponse deleteCategories(String categoriesID){
        return SerenityRest.given().log().all()
                .pathParam("categoriesID", categoriesID)
                .when()
                .delete(EndPoints.DELETE_CATEGORIES_BY_ID)
                .then();
    }

    @Step("Getting Categories information with id: {0}")
    public ValidatableResponse getCategoriesById(String categoriesID){
        return SerenityRest.given().log().all()
                .pathParam("categoriesID", categoriesID)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORIES_BY_ID)
                .then();
    }

}
