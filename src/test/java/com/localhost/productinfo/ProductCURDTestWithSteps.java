package com.localhost.productinfo;


import com.localhost.testbase.TestBase;

import com.localhost.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Jay
 */
@RunWith(SerenityRunner.class)
public class ProductCURDTestWithSteps extends TestBase {

    static String name = "Connected Home & Housewares" + TestUtils.getRandomValue();
    static String type = "HardGood" + TestUtils.getRandomValue();
    static double price = 10000;
    static double shipping = 1;
    static String upc = "0413334300" + TestUtils.getRandomValue();
    static String description = "Compatible with select electronic devices; D size; DURALOCK Power Preserve technology; 6-pack" + TestUtils.getRandomValue();
    static String manufacture = "Duracell";
    static String model = "MN1400R3K" + TestUtils.getRandomValue();
    static String url = "http://www.bestbuy.com/site/duracell-c-batteries-4-pack/185230.p?id=1051384046486&skuId=185230&cmp=RMXCC" + TestUtils.getRandomValue();
    static String image = "http://img.bbystatic.com/BestBuy_US/images/products/1852/185230_sa.jpg" + TestUtils.getRandomValue();

    static int productID;

    @Steps
    ProductSteps productSteps;


    @Title("This will create a new product")
    @Test
    public void test001() {

        ValidatableResponse response = productSteps.createProduct(name, type, price, shipping, upc, description, manufacture, model, url, image);
        response.log().all().statusCode(201);
        productID = response.log().all().extract().path("id");
        System.out.println(productID);
    }

    @Title("Verify if the product was added to the application")
    @Test
    public void test002() {
        HashMap<String, Object> productMap = productSteps.getProductInfoByID(productID);
        Assert.assertThat(productMap, hasValue(name));
        System.out.println(productMap);
    }

    @Title("Update the product information and verify the updated information")
    @Test
    public void test003() {

        name = name + "_updated";

        productSteps.updateProduct(productID, name, type, price, shipping, upc, description, manufacture,
                model, url, image).log().all().statusCode(200);

        HashMap<String, Object> productMap = productSteps.getProductInfoByID(productID);
        Assert.assertThat(productMap, hasValue(name));

    }

    @Title("Delete the product and verify if the student is deleted!")
    @Test
    public void test004() {
        productSteps.deleteproduct(productID).statusCode(200);
        productSteps.getproducttById(productID).statusCode(404);
    }

}
