package com.example.root.testapplicationo.custom_text_field;

/**
 * Created by root on 2/28/18.
 */

public class ColorModel {
    private String value;
    private String label;

    public ColorModel(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
