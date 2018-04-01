package com.randomplayer.categoryview3.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.randomplayer.categoryview3.fragments.CategoryFragment;
import com.randomplayer.categoryview3.R;
import com.randomplayer.categoryview3.models.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper.GenerateRandomData();

        setContentView(R.layout.activity_main);

        CategoryFragment categoryFragment = new CategoryFragment();
        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, categoryFragment);
        fragmentTransaction.commit();


    }
}
