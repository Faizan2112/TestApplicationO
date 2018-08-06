package com.example.root.testapplicationo.custom_text_field;

import android.widget.Filter;

import com.example.root.testapplicationo.autodropdown.AutoCompleteDogsAdapter;
import com.example.root.testapplicationo.autodropdown.Dog;

import java.util.ArrayList;
import java.util.List;

public class LenthFilter extends Filter {
    LengthAdapters adapter;
    List<Length> originalList;
    List<Length> filteredList;

    public LenthFilter(LengthAdapters adapter, ArrayList<Length> originalList) {
        this.adapter = adapter;
        this.originalList = originalList;
        this.filteredList = new ArrayList<>();
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        int val = Integer.parseInt(String.valueOf(charSequence));
        filteredList.clear();
        final FilterResults results = new FilterResults();

        if (charSequence == null || charSequence.length() == 0) {
            filteredList.addAll(originalList);
        }
   /*     else if(!originalList.contains(val))
        {
            int show = val ;
            Length l = new Length("","add "+ String.valueOf(val));
            originalList.add(l);
            filteredList.addAll(originalList);


        }*/
        else {
            final String filterPattern = charSequence.toString().toLowerCase().trim();

            // Your filtering logic goes in here
            for (final Length dog : originalList) {
                if (dog.getLabel().toLowerCase().contains(filterPattern)) {
                    filteredList.add(dog);
                }
            }
        }
        results.values = filteredList;
        results.count = filteredList.size();
        return results;
    }


    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        adapter.filteredDogs.clear();
        adapter.filteredDogs.addAll((List) filterResults.values);
        adapter.notifyDataSetChanged();
    }
}

/*
public class LenthFilter extends Filter {
    LengthAdapters adapter;
    List<Length> originalList;
    List<Length> filteredList;

    public LenthFilter(LengthAdapters  adapter, ArrayList<Length> originalList) {
        this.adapter = adapter;
        this.originalList = originalList;
        this.filteredList = new ArrayList<>();
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        filteredList.clear();
        final FilterResults results = new FilterResults();

        if (charSequence == null || charSequence.length() == 0) {
            filteredList.addAll(originalList);
        }
        //else if{}
        else {
            final String filterPattern = charSequence.toString().toLowerCase().trim();

            // Your filtering logic goes in here
            for (final Length dog : originalList) {
                if (dog.getLabel().toLowerCase().contains(filterPattern)) {
                    filteredList.add(dog);
                }
            }
        }
        results.values = filteredList;
        results.count = filteredList.size();
        return results;
    }


    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        adapter.filteredDogs.clear();
        adapter.filteredDogs.addAll((List) filterResults.values);
        adapter.notifyDataSetChanged();
    }
}
*/
