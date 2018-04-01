package com.randomplayer.categoryview3.models;

/**
 * Created by Le Anh Minh on 4/2/2018.
 */

public class Book {
    public String title;
    public String category;
    public String subcategory;

    public Book(){

    }

    public Book(String title, String category, String subcategory) {
        this.title = title;
        this.category = category;
        this.subcategory = subcategory;
    }
}
