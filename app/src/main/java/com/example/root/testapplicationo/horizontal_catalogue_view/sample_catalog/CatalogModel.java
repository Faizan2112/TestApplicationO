package com.example.root.testapplicationo.horizontal_catalogue_view.sample_catalog;

public class CatalogModel {
    private final String productName;
    private final String productIcon;
    private final String WebUrl;
    private final ProductBackGround productBackGround;

    public CatalogModel(String productName, String productIcon, String webUrl, ProductBackGround productBackGround) {
        this.productName = productName;
        this.productIcon = productIcon;
        WebUrl = webUrl;
        this.productBackGround = productBackGround;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public String getWebUrl() {
        return WebUrl;
    }

    public ProductBackGround getProductBackGround() {
        return productBackGround;
    }




   /* public Forecast(String cityName, int cityIcon, String temperature, Weather weather) {
        this.cityName = cityName;
        this.cityIcon = cityIcon;
        this.temperature = temperature;
        this.weather = weather;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCityIcon() {
        return cityIcon;
    }

    public String getTemperature() {
        return temperature;
    }

    public Weather getWeather() {
        return weather;
    }*/

}
