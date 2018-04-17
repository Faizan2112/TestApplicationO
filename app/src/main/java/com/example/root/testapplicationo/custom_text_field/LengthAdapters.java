package com.example.root.testapplicationo.custom_text_field;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by root on 4/17/18.
 */

public class LengthAdapters extends ArrayAdapter<Length> {
    Context context;
    LayoutInflater inflter;
    List<Length> lengthList;

    private int resources;
    public ArrayList<Length> objects;
    private Length length ;

    private ArrayList<Length> objectsAll;
    private List<ArrayList<Length>> suggestions;

    public LengthAdapters(@NonNull Context context, int resource, @NonNull ArrayList<Length> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resources = resource;
        this.objects = objects;
         this.objectsAll =  (ArrayList<Length>)objects.clone();
        this.suggestions = new ArrayList<>();
        this.inflter = (LayoutInflater.from(context));
    }



     /*     super(context, resource, objects);
       */




    public int getCount() {
        return objects.size();
    }




    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.sub_category_list_view, null);
        TextView catName = (TextView) view.findViewById(R.id.sub_category_cat_name);
        catName.setText(objects.get(i).getLabel().toString());
        return view;
    }





}
