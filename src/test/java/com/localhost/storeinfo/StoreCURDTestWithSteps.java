package com.localhost.storeinfo;

import com.localhost.productinfo.ProductSteps;
import com.localhost.productinfo.StoreSteps;
import com.localhost.testbase.TestBase;
import com.localhost.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class StoreCURDTestWithSteps extends TestBase {

    static String name = "Energizer - MAX Batteries AA (4-Pack)" + TestUtils.getRandomValue();
    static String type = "HardGood" + TestUtils.getRandomValue();
    static String address = "16, lyon Road" + TestUtils.getRandomValue();
    static String address2 = "Harrow" + TestUtils.getRandomValue();
    static String city = "Ahmedabad" + TestUtils.getRandomValue();
    static String state = "Gujarat" + TestUtils.getRandomValue();
    static String zip = "123456" + TestUtils.getRandomValue();
    static int lat = 123;
    static int lng = 456;
    static String hours = "10";


    static int storeID;

    @Steps
    StoreSteps storeSteps;

    @Title("This will create a new Store")
    @Test
    public void test001() {
        HashMap<Object, Object> services = new HashMap<>();
        services.put("storeId", 1);
        services.put("serviceId", 1);

        ValidatableResponse response = storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours, services);
        response.log().all().statusCode(201);
        storeID = response.log().all().extract().path("id");
        System.out.println(storeID);
    }

    @Title("Verify if the Store was added to the application")
    @Test
    public void test002() {
        HashMap<Object, Object> storevarrify = storeSteps.getStoreInfoByID(storeID);
        Assert.assertThat(storevarrify, hasValue(storeID));
        System.out.println(storevarrify);
    }
    @Title("Update the store information and verify the updated information")
    @Test
    public void test003() {

        name = name + "_updated";
        HashMap<Object, Object> services = new HashMap<>();
        services.put("storeId", 1);
        services.put("serviceId", 1);

        storeSteps.updateStore( storeID,name,  type,  address,address2,
                 city,  state,  zip,  lat,  lng,  hours, services) .log().all().statusCode(200);


        HashMap<Object, Object> storeMap = storeSteps.getStoreInfoByID(storeID);
        Assert.assertThat(storeMap, hasValue(name));

    }
    @Title("Delete the store and verify if the store is deleted!")
    @Test
    public void test004() {
        storeSteps.deletestore(storeID).statusCode(200);
        storeSteps.getstortById(storeID).statusCode(404);
    }

}
