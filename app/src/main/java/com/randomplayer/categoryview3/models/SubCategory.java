package com.randomplayer.categoryview3.models;

/**
 * Created by Le Anh Minh on 4/2/2018.
 */

public class SubCategory {
    public String name;
    public String parent_category;

    public SubCategory(){

    }

    public SubCategory(String name, String parent_category) {
        this.name = name;
        this.parent_category = parent_category;
    }
}
