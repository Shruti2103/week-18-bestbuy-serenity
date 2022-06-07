package com.localhost.serviceinfo;

import com.localhost.productinfo.ServicesSteps;
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

import static org.hamcrest.Matchers.hasValue;
@RunWith(SerenityRunner.class)
public class ServicesCURDTestWithSteps extends TestBase {
    static String name = "Shruti" + TestUtils.getRandomValue();

    static int servicesID;
    @Steps
    ServicesSteps servicesSteps;

    @Title("This will create a new Services")
    @Test
    public void test001() {


        ValidatableResponse response = servicesSteps.createServices(name);
        response.log().all().statusCode(201);
        servicesID = response.log().all().extract().path("id");
        System.out.println(servicesID);
    }

    @Title("Verify if the Services was added to the application")
    @Test
    public void test002() {
        HashMap<Object, Object> servicesMap = servicesSteps.getServicesInfoByID(servicesID);
        Assert.assertThat(servicesMap, hasValue(servicesID));
        System.out.println(servicesID);
    }

    @Title("Update the services information and verify the updated information")
    @Test
    public void test003() {

        name = name + "_updated";

        servicesSteps.updateServices(servicesID, name
        ).log().all().statusCode(200);

        HashMap<Object, Object> servicesMap = servicesSteps.getServicesInfoByID(servicesID);
        Assert.assertThat(servicesMap, hasValue(name));
    }

    @Title("Delete the services and verify if the services is deleted!")
    @Test
    public void test004() {
        servicesSteps.deleteServices(servicesID).statusCode(200);
        servicesSteps.getServicesById(servicesID).statusCode(404);
    }


}
