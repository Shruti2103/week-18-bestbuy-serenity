package com.localhost.model;

import java.util.List;

/**
 * Created by Jay
 */
public class CategoriesPojo {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;
    private String id;



    public static CategoriesPojo getCategoriestPojo(String name, String id
                                                ){
        CategoriesPojo categoriesPojo = new CategoriesPojo();

        categoriesPojo.setId(id);
        categoriesPojo.setName(name);
        return categoriesPojo;
    }
}
