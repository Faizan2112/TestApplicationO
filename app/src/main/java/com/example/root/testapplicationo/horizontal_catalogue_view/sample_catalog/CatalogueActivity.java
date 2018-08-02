package com.example.root.testapplicationo.horizontal_catalogue_view.sample_catalog;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.custom_text_field.CategoryAdapter;
import com.example.root.testapplicationo.horizontal_recycler_view.DiscreteScrollView;
import com.example.root.testapplicationo.horizontal_recycler_view.DiscreteScrollViewOptions;
import com.example.root.testapplicationo.horizontal_recycler_view.transform.ScaleTransformer;

import java.util.List;

public class CatalogueActivity extends AppCompatActivity implements
        DiscreteScrollView.OnItemChangedListener<CatalogAdapter.ViewHolder>,
        DiscreteScrollView.ScrollStateChangeListener<CatalogAdapter.ViewHolder> {
    private List<CatalogModel> forecasts;

    private CatalogueView forecastView;
    private DiscreteScrollView cityPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);
        forecastView =  findViewById(R.id.forecast_view);
        forecasts = ProductData.get().getForecasts();

        cityPicker = (DiscreteScrollView) findViewById(R.id.forecast_city_picker);
        cityPicker.setSlideOnFling(true);
        cityPicker.setAdapter(new CatalogAdapter(forecasts));
        cityPicker.addOnItemChangedListener(this);
        cityPicker.addScrollStateChangeListener(this);
        cityPicker.scrollToPosition(2);
        cityPicker.setItemTransitionTimeMillis(150);
        cityPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        forecastView.setWebView(forecasts.get(0));
    }


    @Override
    public void onScrollStart(@NonNull CatalogAdapter.ViewHolder holder, int adapterPosition) {
        holder.hideText();

    }

    @Override
    public void onScrollEnd(@NonNull CatalogAdapter.ViewHolder currentItemHolder, int adapterPosition) {

    }

    @Override
    public void onScroll(float scrollPosition, int currentPosition, int newIndex, @Nullable CatalogAdapter.ViewHolder currentHolder, @Nullable CatalogAdapter.ViewHolder newCurrent) {
        CatalogModel current = forecasts.get(currentPosition);
        if (newIndex >= 0 && newIndex < cityPicker.getAdapter().getItemCount()) {
            CatalogModel next = forecasts.get(newIndex);
            forecastView.onScroll(1f - Math.abs(scrollPosition), current, next);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCurrentItemChanged(@Nullable CatalogAdapter.ViewHolder holder, int position) {
        if (holder != null) {
            forecastView.setWebView(forecasts.get(position));
            holder.showText();
        }
    }
}
