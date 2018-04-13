package com.example.root.testapplicationo.dependentspinner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/23/18.
 */

public class SpinnerAdapter extends ArrayAdapter<CategoryDetail> {
    private List<CategoryDetail> catPos = new ArrayList<>();
    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List<CategoryDetail> catDetails) {
        super(context, resource, catDetails);


    }


    public CategoryDetail getItem(int position)
    {

        return catPos.get(position);

    }

    private View initView(int position) {
        CategoryDetail catPos = getItem(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.spinner_category_layout, null);
        TextView textView =  v.findViewById(R.id.home_spinner_categories);
        textView.setText(catPos.getCat_name());
        return v;

    }

}
