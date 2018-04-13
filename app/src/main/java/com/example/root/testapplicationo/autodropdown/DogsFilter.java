package com.example.root.testapplicationo.autodropdown;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/10/18.
 */

public class DogsFilter extends Filter {

    AutoCompleteDogsAdapter adapter;
    List<Dog> originalList;
    List<Dog> filteredList;

    public DogsFilter(AutoCompleteDogsAdapter adapter, List<Dog> originalList) {
        super();
        this.adapter = adapter;
        this.originalList = originalList;
        this.filteredList = new ArrayList<>();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        filteredList.clear();
        final FilterResults results = new FilterResults();

        if (constraint == null || constraint.length() == 0) {
            filteredList.addAll(originalList);
        } else {
            final String filterPattern = constraint.toString().toLowerCase().trim();

            // Your filtering logic goes in here
            for (final Dog dog : originalList) {
                if (dog.getBreed().toLowerCase().contains(filterPattern)) {
                    filteredList.add(dog);
                }
            }
        }
        results.values = filteredList;
        results.count = filteredList.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.filteredDogs.clear();
        adapter.filteredDogs.addAll((List) results.values);
        adapter.notifyDataSetChanged();
    }
}