package com.example.root.testapplicationo.horizontal_catalogue_view.sample_catalog;

enum  ProductBackGround {

    PERIODIC_CLOUDS("Periodic Clouds"),
    CLOUDY("Cloudy"),
    MOSTLY_CLOUDY("Mostly Cloudy"),
    PARTLY_CLOUDY("Partly Cloudy"),
    CLEAR("Clear");

    private String displayName;

    ProductBackGround(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
