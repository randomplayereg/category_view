package com.randomplayer.categoryview3.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le Anh Minh on 4/2/2018.
 */

public class DatabaseHelper {
    public static ArrayList<Book> AllBook;
    public static ArrayList<Category> AllCategory;
    public static ArrayList<SubCategory> AllSubCategory;

    public static ArrayList<SubCategory> select_subcategory_by_parent(String parentCategory){
        ArrayList<SubCategory> result = new ArrayList<>();

        for (SubCategory subcat : AllSubCategory){
            if (subcat.parent_category.equals(parentCategory))
                result.add(subcat);
        }

        return result;
    }

    public static ArrayList<String> string_subcategory_by_parent(String parentCategory){
        ArrayList<String> result = new ArrayList<>();

        for (SubCategory subcategory : AllSubCategory){
            if (subcategory.parent_category.equals(parentCategory))
                result.add(subcategory.name);
        }
        return result;
    }

    public static ArrayList<String> string_all_category(){
        ArrayList<String> result = new ArrayList<>();

        for (Category category : AllCategory){
            result.add(category.name);
        }
        return result;
    }

    public static ArrayList<String> string_book_by_category_and_subcategory(String category, String subcategory){
        ArrayList<String> result = new ArrayList<>();

        for (Book book : AllBook){
            if (book.category.equals(category) && book.subcategory.equals(subcategory))
                result.add(book.title);
        }
        return result;
    }

    public static void GenerateRandomData(){
        AllBook = new ArrayList<>();
        AllCategory = new ArrayList<>();
        AllSubCategory = new ArrayList<>();

        AllCategory.add(new Category("Fiction"));
            AllSubCategory.add(new SubCategory("Horror", "Fiction"));
                AllBook.add(new Book("Saw", "Fiction", "Horror"));
                AllBook.add(new Book("Resident Evil", "Fiction", "Horror"));
                AllBook.add(new Book("It", "Fiction", "Horror"));
            AllSubCategory.add(new SubCategory("Fantasy", "Fiction"));
                AllBook.add(new Book("The lord of the rings","Fiction", "Fantasy"));
                AllBook.add(new Book("Game of thrones","Fiction", "Fantasy"));
                AllBook.add(new Book("The hunger games","Fiction", "Fantasy"));

        AllCategory.add(new Category("History"));
            AllSubCategory.add(new SubCategory("Biography", "History"));
                AllBook.add(new Book("Sir Alex Ferguson's biography","History", "Biography"));
            AllSubCategory.add(new SubCategory("Documentary", "History"));
                AllBook.add(new Book("The Viewnam war","History", "Documentary"));

        AllCategory.add(new Category("Science"));
            AllSubCategory.add(new SubCategory("Mathematics", "Science"));
            AllSubCategory.add(new SubCategory("Physics", "Science"));
                AllBook.add(new Book("The universe in a nutshell","Science", "Physics"));

        AllCategory.add(new Category("Computer"));
            //AllSubCategory.add(new SubCategory("Programming", "Computer"));


    }
}
