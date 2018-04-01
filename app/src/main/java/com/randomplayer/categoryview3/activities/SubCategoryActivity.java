package com.randomplayer.categoryview3.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.randomplayer.categoryview3.R;
import com.randomplayer.categoryview3.fragments.SubCategoryFragment;

public class SubCategoryActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        Bundle b = getIntent().getExtras();
        String value = ""; // or other values
        if(b != null) value = b.getString("categoryParam");
        //Toast.makeText(this, value, Toast.LENGTH_LONG).show();

        // pass parent_category to fragment
        Bundle bundle = new Bundle();
        bundle.putString("categoryParam", value);
        SubCategoryFragment subCategoryFragment = new SubCategoryFragment();
        subCategoryFragment.setArguments(bundle);
        // pass parent_category to fragment

//        SubCategoryFragment subCategoryFragment = new SubCategoryFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.subcategory_container, subCategoryFragment);
        fragmentTransaction.commit();
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.button:
//                Intent intent = new Intent(SubCategoryActivity.this, BookActivity.class);
//                startActivity(intent);
//                break;
//        }
//
//    }
}
