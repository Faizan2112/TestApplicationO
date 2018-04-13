package com.example.root.testapplicationo.custom_text_field;

import java.util.List;

/**
 * Created by root on 2/27/18.
 */

public class DimentionModel {
    public DimentionModel(List<Length> lengths, List<Width> widths, List<Height> heights) {
        this.lengths = lengths;
        this.widths = widths;
        this.heights = heights;
    }

    public List<Length> getLengths() {
        return lengths;
    }

    public void setLengths(List<Length> lengths) {
        this.lengths = lengths;
    }

    public List<Width> getWidths() {
        return widths;
    }

    public void setWidths(List<Width> widths) {
        this.widths = widths;
    }

    public List<Height> getHeights() {
        return heights;
    }

    public void setHeights(List<Height> heights) {
        this.heights = heights;
    }

    List<Length> lengths;
    List<Width> widths;
    List<Height> heights;


}

/*class Length {
    private String value;
    private String label;

    public Length(String value, String label) {
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

class Width {

    private String value;
    private String label;

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

    public Width(String value, String label) {
        this.value = value;
        this.label = label;
    }
}

public class Height {
    private String value;
    private String label;

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

    public Height(String value, String label) {
        this.value = value;
        this.label = label;
    }*/

