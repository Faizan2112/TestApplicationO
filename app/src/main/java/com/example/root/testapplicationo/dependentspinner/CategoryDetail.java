package com.example.root.testapplicationo.dependentspinner;

import java.util.List;

/**
 * Created by root on 2/23/18.
 */

public class CategoryDetail {
    private String cat_id ;
    private String cat_name ;

    public CategoryDetail(String cat_id, String cat_name) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
}
