package com.randomplayer.categoryview3.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.randomplayer.categoryview3.R;
import com.randomplayer.categoryview3.activities.BookActivity;
import com.randomplayer.categoryview3.adapters.MenuAdapter;
import com.randomplayer.categoryview3.models.DatabaseHelper;
import com.randomplayer.categoryview3.models.TestModel;
import com.randomplayer.categoryview3.utils.RecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le Anh Minh on 4/2/2018.
 */

public class BookFragment extends Fragment {

    private String categoryParam;
    private String subCategoryParam;
    private ArrayList<String> string_bookList;

    private RecyclerViewItemClickListener itemClickListener = new RecyclerViewItemClickListener() {
        @Override
        public void onItemClickListener(int position, View view) {
            //Todo: doing sth next
            //Toast.makeText(getActivity(), testSubCategories.get(position), Toast.LENGTH_LONG).show();
        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        categoryParam = getArguments().getString("categoryParam");
        subCategoryParam = getArguments().getString("subCategoryParam");
        string_bookList = DatabaseHelper.string_book_by_category_and_subcategory(categoryParam, subCategoryParam);
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.book_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.book_recyclerview);

        MenuAdapter adapter = new MenuAdapter(getActivity(), DatabaseHelper.string_book_by_category_and_subcategory(categoryParam, subCategoryParam), itemClickListener);

        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }
}
