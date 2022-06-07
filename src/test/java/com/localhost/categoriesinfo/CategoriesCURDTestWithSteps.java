package com.localhost.categoriesinfo;

import com.localhost.productinfo.CategoriesSteps;
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
public class CategoriesCURDTestWithSteps extends TestBase {

    static String id = "3" + TestUtils.getRandomValue();
    static String name = "PrimeUser" + TestUtils.getRandomValue();

    static String categoriesID;

    @Steps
    CategoriesSteps categoriesSteps;


    @Title("This will create a new Categories")
    @Test
    public void test001() {
        ValidatableResponse response = categoriesSteps.createCategories(id,name);
        response.log().all().statusCode(201);
        categoriesID=response.log().all().extract().path("id");
        System.out.println(categoriesID);
    }

    @Title("Verify if the student was added to the application")
    @Test
    public void test002() {
        HashMap<Object, Object> categoryMap = categoriesSteps.getCategoriesBYID(categoriesID);
        Assert.assertThat(categoryMap, hasValue(name));
        System.out.println(categoryMap);
    }

    @Title("Update the user information and verify the updated information")
    @Test
    public void test003() {

        name = name + "_updated";

        categoriesSteps.updateCategories(categoriesID,id,name)
               .log().all().statusCode(200);

        HashMap<Object, Object> categoryMap = categoriesSteps.getCategoriesBYID(categoriesID);
        Assert.assertThat(categoryMap, hasValue(name));

    }

    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004() {
       categoriesSteps.deleteCategories(categoriesID).statusCode(200);
        categoriesSteps.getCategoriesById(categoriesID).statusCode(404);
    }

}
