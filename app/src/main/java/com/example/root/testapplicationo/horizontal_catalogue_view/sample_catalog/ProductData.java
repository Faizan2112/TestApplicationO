package com.example.root.testapplicationo.horizontal_catalogue_view.sample_catalog;

import java.util.Arrays;
import java.util.List;

public class ProductData {

    public ProductData() {
    }

    public static ProductData get()
    {
        return new ProductData();
    }

    public List<CatalogModel> getForecasts() {
        return Arrays.asList(
                new CatalogModel("Granduer","http://image10.bizrate-images.com/resize?sq=60&uid=2216744464", "http://freshupproducts.com/exotica/p25", ProductBackGround.PARTLY_CLOUDY),
                new CatalogModel("Granduer1","http://image10.bizrate-images.com/resize?sq=60&uid=2216744464", "http://freshupproducts.com/boost-up/p30", ProductBackGround.CLOUDY),
                new CatalogModel("Granduer2","http://image10.bizrate-images.com/resize?sq=60&uid=2216744464", "http://freshupproducts.com/loosen-up-eurotop/p33", ProductBackGround.MOSTLY_CLOUDY),
                new CatalogModel("Granduer3","http://image10.bizrate-images.com/resize?sq=60&uid=2216744464", "http://freshupproducts.com/exotica/p25", ProductBackGround.PERIODIC_CLOUDS)

                );
    }
}
