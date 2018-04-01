package com.randomplayer.categoryview3.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.randomplayer.categoryview3.R;
import com.randomplayer.categoryview3.fragments.BookFragment;
import com.randomplayer.categoryview3.fragments.SubCategoryFragment;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Bundle b = getIntent().getExtras();
        String categoryParam = "";
        String subcategoryParam = "";
        if(b != null) {
            categoryParam = b.getString("categoryParam");
            subcategoryParam = b.getString("subCategoryParam");
            Toast.makeText(this, categoryParam + " " + subcategoryParam, Toast.LENGTH_LONG).show();
        }

        Bundle bundle = new Bundle();
        bundle.putString("categoryParam", categoryParam);
        bundle.putString("subCategoryParam", subcategoryParam);
        BookFragment bookFragment = new BookFragment();
        bookFragment.setArguments(bundle);

        //BookFragment bookFragment = new BookFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.book_container, bookFragment);
        fragmentTransaction.commit();
    }
}
