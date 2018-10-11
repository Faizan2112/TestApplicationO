package com.example.root.testapplicationo.custom_text_field;

import android.content.Context;
import android.util.AttributeSet;

import com.example.root.testapplicationo.R;

import fr.ganfra.materialspinner.MaterialSpinner;

public class EditMaterialSpinner extends MaterialSpinner {
    public EditMaterialSpinner(Context context) {
        super(context);
    }

    public EditMaterialSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditMaterialSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init() {
        setBackgroundResource(R.drawable.search_background);
    }

}
