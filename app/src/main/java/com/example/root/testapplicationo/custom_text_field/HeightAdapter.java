package com.example.root.testapplicationo.custom_text_field;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

import java.util.List;

/**
 * Created by root on 2/27/18.
 */

public class HeightAdapter extends BaseAdapter implements Filterable {
    Context context;
    LayoutInflater inflter;
    List<Height> heightList;

    public HeightAdapter(Context applicationContext, List<Height> heightList) {
        this.context = applicationContext;
        this.heightList = heightList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return heightList.size();
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
     //   for (int j = 0; j <= heightList.size(); j++) {

            catName.setText(heightList.get(i).getLabel());

     //   }
        return view;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}