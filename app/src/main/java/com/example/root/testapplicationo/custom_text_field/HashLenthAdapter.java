package com.example.root.testapplicationo.custom_text_field;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by root on 4/13/18.
 */

public class HashLenthAdapter extends ArrayAdapter<HashMap<String,Length>> {
    private Context context;
    private int resources;
    private ArrayList<HashMap<String, Length>> objects;
    private Length length ;
    LayoutInflater inflter ;

    private ArrayList<HashMap<String, Length>> objectsAll;
    private ArrayList<HashMap<String, Length>> suggestions;

    public HashLenthAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<HashMap<String, Length>> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resources = resource;
        this.objects = objects;
        this.objectsAll = (ArrayList<HashMap<String, Length>>) objects.clone();
        this.suggestions = new ArrayList<>();
        this.inflter = (LayoutInflater.from(context));
    }
//TX-TLTEST
    @Override
    public int getCount() {
        return objects.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflter.inflate(R.layout.category_list_view, null);
        TextView adapterName = (TextView) convertView.findViewById(R.id.category_cat_name);
        //View row = convertView;
        try{
            /*if (row == null) {
               // LayoutInflater inflater = (LayoutInflater) ((Activity) context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LayoutInflater inflater = (LayoutInflater) (context.getApplicationContext()).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(resources, parent, false);


            }*/
            HashMap<String, Length> data = objects.get(position);
            String val = data.get("name").getLabel();

            // TextView adapterPhone = (TextView) row.findViewById(R.id.adapterPhone);
            adapterName.setText(val);
            // adapterPhone.setText(data.get("phone"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
//            String name = ((HashMap<String, String>) resultValue).get("name");
          String name = objectsAll.get((Integer) resultValue).get("cat").getLabel();

            return name;
        }

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            if(charSequence != null) {
                suggestions.clear();
                for (HashMap<String, Length> data : objectsAll) {
                   /* if(data.get("name").getValue.t(charSequence.toString().toLowerCase())){ // Filter list on the basis of name
                        suggestions.add(data);
                    }*/

                    if(data.get("name").getValue().toLowerCase().startsWith(charSequence.toString().toLowerCase())) { // Filter list on the basis of name
                        suggestions.add(data);
                    }

                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                FilterResults filter = new FilterResults();
                filter.values = objectsAll;
                filter.count = objectsAll.size();
                return filter;
            }
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            ArrayList<HashMap<String, Length>> filtered = (ArrayList<HashMap<String, Length>>) results.values;
            if(results != null && results.count > 0) {
                clear();
                for (HashMap<String,Length> c : filtered) {
                    add(c);
                }
                notifyDataSetChanged();
            }
        }
    };
}

