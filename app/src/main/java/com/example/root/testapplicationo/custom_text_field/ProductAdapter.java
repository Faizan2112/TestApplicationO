package com.example.root.testapplicationo.custom_text_field;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

import java.util.List;

/**
 * Created by root on 2/26/18.
 */

public class ProductAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflter;
    List<ProductModel> catProductList;

    public ProductAdapter(Context applicationContext, List<ProductModel> catProductList) {
        this.context = applicationContext;
        this.catProductList = catProductList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return catProductList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.sub_category_list_view, null);
        TextView catName = (TextView) view.findViewById(R.id.sub_category_cat_name);
       // for (int j = 0; j <= catProductList.size(); j++) {

            catName.setText(catProductList.get(i).getmCategoryName());

      //  }
        return view;
    }

}