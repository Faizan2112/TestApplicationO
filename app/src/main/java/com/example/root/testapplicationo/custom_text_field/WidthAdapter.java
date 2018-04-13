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

public class WidthAdapter  extends BaseAdapter implements Filterable {
    Context context;
    LayoutInflater inflter;
    List<Width> widthList;

    public WidthAdapter(Context applicationContext, List<Width> widthList) {
        this.context = applicationContext;
        this.widthList = widthList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return widthList.size();
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
     //   for (int j = 0; j <= widthList.size(); j++) {

            catName.setText(widthList.get(i).getLabel());

     //   }
        return view;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
