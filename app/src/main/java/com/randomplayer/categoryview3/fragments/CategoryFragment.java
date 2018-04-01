package com.randomplayer.categoryview3.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
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
import com.randomplayer.categoryview3.activities.SubCategoryActivity;
import com.randomplayer.categoryview3.adapters.MenuAdapter;
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

public class CategoryFragment extends Fragment {

    private RecyclerViewItemClickListener itemClickListener = new RecyclerViewItemClickListener() {
        @Override
        public void onItemClickListener(int position, View view) {
            Intent intent = new Intent(getActivity(), SubCategoryActivity.class);
            Bundle b = new Bundle();
            b.putString("categoryParam", DatabaseHelper.AllCategory.get(position).name); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.category_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.category_recyclerview);

        //CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), DatabaseHelper.AllCategory, itemClickListener);
        MenuAdapter adapter = new MenuAdapter(getActivity(), DatabaseHelper.string_all_category(), itemClickListener);

        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }

}
