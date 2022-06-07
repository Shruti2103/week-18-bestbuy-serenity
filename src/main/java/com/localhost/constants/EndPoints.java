package com.localhost.constants;

/**
 * Created by Jay
 */
public class EndPoints {

    /**
     * This is Endpoints of bestbuy api
     */
    public static final String GET_ALL_PRODUCTS = "/products";
    public static final String CREATE_SINGLE_PRODUCT = "/products";
    public static final String GET_SINGLE_PRODUCTS_BY_ID = "products/{productID}";
    public static final String UPDATE_PRODUCTS_BY_ID = "products/{productID}";
    public static final String DELETE_PRODUCTS_BY_ID = "products/{productID}";

    /**
     * This is Endpoints of Store api
     */
    public static final String GET_ALL_STORES = "/stores";
    public static final String CREATE_SINGLE_STORE = "/stores";
    public static final String GET_SINGLE_STORE_BY_ID = "/stores/{storeID}";
    public static final String UPDATE_STORE_BY_ID = "/stores/{storeID}";
    public static final String DELETE_STORE_BY_ID = "/stores/{storeID}";

    /**
     * This is Endpoints of Services api
     */
    public static final String GET_ALL_SERVICES = "/services";
    public static final String CREATE_SINGLE_SERVICES = "/services";
    public static final String GET_SINGLE_SERVICES_BY_ID = "/services/{servicesID}";
    public static final String UPDATE_SERVICES_BY_ID = "/services/{servicesID}";
    public static final String DELETE_SERVICES_BY_ID = "/services/{servicesID}";

    /**
     * This is Endpoints of categories api
     */
    public static final String GET_ALL_CATEGORIES = "/categories";
    public static final String CREATE_SINGLE_CATEGORIES = "/categories";
    public static final String GET_SINGLE_CATEGORIES_BY_ID = "/categories/{categoriesID}";
    public static final String UPDATE_CATEGORIES_BY_ID = "/categories/{categoriesID}";
    public static final String DELETE_CATEGORIES_BY_ID = "/categories/{categoriesID}";

    public static final String GET_ALL_UTILITIES = "/version";

    public static final String GET_ALL_Healthcheck= "/healthcheck";










}
