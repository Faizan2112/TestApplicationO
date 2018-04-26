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

public class LengthAdapter extends BaseAdapter implements Filterable {
    Context context;
    LayoutInflater inflter;
    List<Length> lengthList;

    public LengthAdapter(Context applicationContext, List<Length> lengthList) {
        this.context = applicationContext;
        this.lengthList = lengthList;
        inflter = (LayoutInflater.from(applicationContext.getApplicationContext()));
    }

    @Override
    public int getCount() {
        return lengthList.size();
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
      //  for (int j = 0; j <= lengthList.size(); j++) {

            catName.setText(lengthList.get(i).getLabel());

    //    }
        return view;
    }



    @Override
    public Filter getFilter() {
        return null;
    }
}