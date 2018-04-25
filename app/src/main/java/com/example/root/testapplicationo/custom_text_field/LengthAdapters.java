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
import com.example.root.testapplicationo.autodropdown.Dog;
import com.example.root.testapplicationo.autodropdown.DogsFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by root on 4/17/18.
 */

public class LengthAdapters extends ArrayAdapter<Length> {
    Context context;
    LayoutInflater inflter;
    List<Length> filteredDogs = new ArrayList<>();

    private int resources;
    public ArrayList<Length> objects;


    public LengthAdapters(@NonNull Context context, int resource, @NonNull ArrayList<Length> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resources = resource;
        this.objects = objects;
         /*this.objectsAll =  (ArrayList<Length>)objects.clone();
        this.suggestions = new ArrayList<>()*/;
        this.inflter = (LayoutInflater.from(context));
    }



     /*     super(context, resource, objects);
       */

    @Override
    public Filter getFilter() {
        return new LenthFilter(this, objects);
    }


    public int getCount() {
        //return objects.size();
        return filteredDogs.size();
    }




    @Override
    public long getItemId(int i) {
        return 0;
    }


    public Length getItemId(int i,String s) {
        return objects.get(i);
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Length dog = filteredDogs.get(i);

        view = inflter.inflate(R.layout.sub_category_list_view, null);
        TextView catName = (TextView) view.findViewById(R.id.sub_category_cat_name);
        catName.setText(objects.get(i).getLabel().toString());
        return view;
    }





}
