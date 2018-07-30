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
 * Created by root on 2/27/18.
 */

public class ColorAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflter;
    List<ColorModel> colorModelList;

    public ColorAdapter(Context applicationContext, List<ColorModel> colorModelList) {
        this.context = applicationContext;
        this.colorModelList = colorModelList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return colorModelList.size();
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
        view = inflter.inflate(R.layout.category_list_view, null);
        //view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_list_view,viewGroup,false);
        TextView catName = (TextView) view.findViewById(R.id.category_cat_name);
      //  for (int j = 0; j <= colorModelList.size(); j++) {

            catName.setText(colorModelList.get(i).getLabel());

     //   }
        return view;
    }
}