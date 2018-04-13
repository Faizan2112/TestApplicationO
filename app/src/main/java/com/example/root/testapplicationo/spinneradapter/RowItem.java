package com.example.root.testapplicationo.spinneradapter;

/**
 * Created by root on 2/24/18.
 */
public class RowItem {


    public String getCat_ids() {
        return cat_ids;
    }

    public void setCat_ids(String cat_ids) {
        this.cat_ids = cat_ids;
    }

    public String getCat_names() {
        return cat_names;
    }

    public void setCat_names(String cat_names) {
        this.cat_names = cat_names;
    }

    private String cat_ids;
    private String cat_names;

    public RowItem(String cat_ids, String cat_names) {
        this.cat_ids = cat_ids;
        this.cat_names = cat_names;
    }
}