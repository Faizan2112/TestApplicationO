package com.example.root.testapplicationo.autodropdown;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/10/18.
 */

public class AutoCompleteDogsAdapter  extends ArrayAdapter<Dog> {

    private final List<Dog> dogs;
    public List<Dog> filteredDogs = new ArrayList<>();

    public AutoCompleteDogsAdapter(Context context, List<Dog> dogs) {
        super(context, 0, dogs);
        this.dogs = dogs;
    }

    @Override
    public int getCount() {
        return filteredDogs.size();
    }

    @Override
    public Filter getFilter() {
        return new DogsFilter(this, dogs);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item from filtered list.
        Dog dog = filteredDogs.get(position);

        // Inflate your custom row layout as usual.
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.row_dog, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.row_breed);
        //ImageView ivIcon = (ImageView) convertView.findViewById(R.id.row_icon);
        tvName.setText(dog.getBreed());
       // ivIcon.setImageResource(dog.drawable);
        if (position % 2 == 0)
            convertView.setBackgroundColor(getContext().getColor(R.color.cardview_shadow_end_color));
        else
            convertView.setBackgroundColor(getContext().getColor(R.color.cardview_light_background));
        return convertView;
    }}