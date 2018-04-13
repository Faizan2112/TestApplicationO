/*
package com.example.root.testapplicationo.spinneradapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

import java.util.List;

*/
/**
 * Created by root on 2/24/18.
 *//*


public class CustomAdapter extends ArrayAdapter<RowItem> {

    LayoutInflater flater;

    public CustomAdapter(Activity context, int resouceId, List<RowItem> list){

        super(context,resouceId, list);
        flater = context.getLayoutInflater();
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return rowview(convertView,position);
    }

    private View rowview(View convertView , int position){

        RowItem rowItem = getItem(position);

        viewHolder holder ;
        View rowview = convertView;
        if (rowview==null) {

            holder = new viewHolder();
            flater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = flater.inflate(R.layout.display_item, null, false);

          //  holder.cName = (TextView) rowview.findViewById(R.id.cat_id);
        //    holder.cId = (TextView) rowview.findViewById(R.id.cat_name);

            rowview.setTag(holder);
        }else{
            holder = (viewHolder) rowview.getTag();
        }
       // holder.imageView.setImageResource(rowItem.getImageId());
        holder.cName.setText(rowItem.getCat_names());
        holder.cId.setText(rowItem.getCat_names());

        return rowview;
    }

    private class viewHolder{
        TextView cName;
        TextView cId;
    }

   */
/* @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = flater.inflate(R.layout.display_item,parent, false);
        }

        RowItem rowItem = getItem(position);

        View rowview = flater.inflate(R.layout.display_item,null,true);

        TextView cat_id = (TextView) rowview.findViewById(R.id.cat_id);
        TextView cat_name = (TextView) rowview.findViewById(R.id.cat_name);
        cat_id.setText(rowItem.getCat_ids());
        cat_name.setText(rowItem.getCat_names());



        return rowview;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }*//*

}

*/
