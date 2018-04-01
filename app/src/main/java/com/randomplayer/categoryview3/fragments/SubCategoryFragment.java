package com.randomplayer.categoryview3.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.randomplayer.categoryview3.R;
import com.randomplayer.categoryview3.activities.BookActivity;
import com.randomplayer.categoryview3.activities.SubCategoryActivity;
import com.randomplayer.categoryview3.adapters.MenuAdapter;
import com.randomplayer.categoryview3.adapters.SubCategoryAdapter;
import com.randomplayer.categoryview3.models.DatabaseHelper;
import com.randomplayer.categoryview3.models.SubCategory;
import com.randomplayer.categoryview3.models.TestModel;
import com.randomplayer.categoryview3.adapters.CategoryAdapter;
import com.randomplayer.categoryview3.utils.RecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le Anh Minh on 4/1/2018.
 */

public class SubCategoryFragment extends Fragment {

    private String categoryParam;
    private ArrayList<String> string_subcategoryList;


    private RecyclerViewItemClickListener itemClickListener = new RecyclerViewItemClickListener() {
        @Override
        public void onItemClickListener(int position, View view) {
            //Todo: attempt navigate to book activity
            //Toast.makeText(getActivity(), testSubCategories.get(position), Toast.LENGTH_LONG).show();


            Intent intent = new Intent(getActivity(), BookActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("categoryParam", categoryParam);
            bundle.putString("subCategoryParam", string_subcategoryList.get(position));
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.categoryParam = getArguments().getString("categoryParam");
        string_subcategoryList = DatabaseHelper.string_subcategory_by_parent(this.categoryParam);

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.subcategory_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.subcategory_recyclerview);

        //SubCategoryAdapter subcategoryAdapter = new SubCategoryAdapter(getActivity(), subcategoriesList, itemClickListener);
        MenuAdapter adapter = new MenuAdapter(getActivity(), DatabaseHelper.string_subcategory_by_parent(categoryParam), itemClickListener);

        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }

}
