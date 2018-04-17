package com.example.root.testapplicationo.custom_text_field;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by root on 4/13/18.
 */

@SuppressLint("AppCompatCustomView")
public class CustomAutoCompleteTextViews extends AutoCompleteTextView {

    public CustomAutoCompleteTextViews(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /** Returns the country name corresponding to the selected item */
    @Override
    protected CharSequence convertSelectionToString(Object selectedItem) {
        /** Each item in the autocompetetextview suggestion list is a hashmap object */
       // ArrayList<HashMap<String,Length>> hs = new ArrayList<HashMap<String, Length>>();
        HashMap<String, Length> hm = (HashMap<String, Length>) selectedItem;
      // HashMap<String, Length> pos = hs.get((Integer) selectedItem);
        // return hm.get(""+selectedItem).getLabel();
        return hm.get("name").getLabel();
    }
}