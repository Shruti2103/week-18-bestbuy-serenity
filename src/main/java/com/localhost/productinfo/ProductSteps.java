package com.localhost.productinfo;


import com.localhost.constants.EndPoints;


import com.localhost.model.ProductPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Jay
 */
public class ProductSteps {

    @Step("Creating products with name : {0}, type: {1}, price: {2}, shipping: {3} upc : {4}, description: {5}, model{6}, url{7},image{8}")
    public ValidatableResponse createProduct(String name, String type, double price,
                                             double shipping,String upc,String description, String manufacture,String model,String url,String image  ) {
        ProductPojo productPojo= new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacture);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productPojo)
                .when()
                .post(EndPoints.CREATE_SINGLE_PRODUCT)
                .then();

    }

    @Step("Getting the product information with ID: {0}")
    public HashMap<String, Object> getProductInfoByID(int productID) {

        HashMap<String, Object> productMap = SerenityRest.given().log().all()
                .when()
                .pathParam("productID",productID)
                .get(EndPoints.GET_SINGLE_PRODUCTS_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");

        return productMap;
    }

    @Step("Updating product information with productId:  {0}, type: {1}, price: {2}, shipping: {3} upc : {4}, description: {5}, model{6}, url{7},image{8}")
    public ValidatableResponse updateProduct(int productID, String name, String type, double price,
                                             double shipping,String upc,String description,String manufacture, String model,String url,String image  ) {
        ProductPojo productPojo= new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacture);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        return SerenityRest.given().log().all()
                .pathParam("productID",productID)
                .contentType(ContentType.JSON)
                .body(productPojo)
                .when()
                .put(EndPoints.UPDATE_PRODUCTS_BY_ID)
                .then();

    }

    @Step("Deleting product information with productID: {0}")
    public ValidatableResponse deleteproduct(int productID){
        return SerenityRest.given().log().all()
                .pathParam("productID", productID)
                .when()
                .delete(EndPoints.DELETE_PRODUCTS_BY_ID)
                .then();
    }

    @Step("Getting product information with productId: {0}")
    public ValidatableResponse getproducttById(int productID){
        return SerenityRest.given().log().all()
                .pathParam("productID", productID)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCTS_BY_ID)
                .then();
    }

}
