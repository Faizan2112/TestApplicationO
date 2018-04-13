/*
package com.example.root.testapplicationo.section_recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

*/
/**
 * Created by root on 3/12/18.
 *//*


public class RecyclerItemAdapter extends RecyclerView.Adapter {

    List items = new ArrayList<>();
    RecyclerItemAdapter(){
        setHasStableIds(true);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public void add(ItemModel object) {
        items.add(object);
        notifyDataSetChanged();
    }

    public void add(int index, ItemModel object) {
        items.add(index, object);
        notifyDataSetChanged();
    }

    public void addAll(Collection collection) {
        if (collection != null) {
            items.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public void addAll(ItemModel... items) {
        addAll(Arrays.asList(items));
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void remove(ItemModel object) {
        items.remove(object);
        notifyDataSetChanged();
    }

}*/
