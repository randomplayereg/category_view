package com.randomplayer.categoryview3.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.randomplayer.categoryview3.R;
import com.randomplayer.categoryview3.models.Category;
import com.randomplayer.categoryview3.models.SubCategory;
import com.randomplayer.categoryview3.models.TestModel;
import com.randomplayer.categoryview3.activities.BookActivity;
import com.randomplayer.categoryview3.utils.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by Le Anh Minh on 4/1/2018.
 */

public class SubCategoryAdapter extends RecyclerView.Adapter {

    Context mContext;
    List<SubCategory> mData;
    private RecyclerViewItemClickListener recyclerViewItemClickListener;

    public SubCategoryAdapter(Context pContext, List<SubCategory> pData, RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.mContext = pContext;
        this.mData = pData;
        this.recyclerViewItemClickListener = recyclerViewItemClickListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CategoryViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        //return TestData.title.length;
        return mData.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTextView;

        public CategoryViewHolder(View itemView){
            super(itemView);

            mTextView = itemView.findViewById(R.id.item_name);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mTextView.setText(mData.get(position).name);
//            mTextView.setId(position);
        }

        public void onClick(View view){
            recyclerViewItemClickListener.onItemClickListener(getAdapterPosition(), view);
        }
    }


}