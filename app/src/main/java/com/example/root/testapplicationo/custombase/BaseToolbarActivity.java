package com.example.root.testapplicationo.custombase;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import android.support.v7.widget.Toolbar;

import com.example.root.testapplicationo.R;

public abstract class BaseToolbarActivity extends AppCompatActivity {
    Toolbar mToolbar;
    TextView tvToolbarTitle;
    FrameLayout mBaseFrameLayout;
    public String APP_FONT = "Lato-Regular.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_toolbar);
        findViewsIds();
        setBaseToolbar();
        setBaseActivityFonts();


    }

    private void setBaseActivityFonts() {
        tvToolbarTitle.setTypeface(Typeface.createFromAsset(getAssets(), APP_FONT));
        tvToolbarTitle.setTextSize(20f);
        tvToolbarTitle.setTextSize(Color.WHITE);

    }

    private void setBaseToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    private void findViewsIds() {

        mToolbar = findViewById(R.id.base_toolbar);
        tvToolbarTitle = findViewById(R.id.base_toolbar_title);
        mBaseFrameLayout = findViewById(R.id.base_frame_layout);
    }


    public void setView(int layout, String name) {
        //  LayoutInflater layoutInflater = LayoutInflater.from(Context.GET)
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View activityView = layoutInflater.inflate(layout, null, false);
        mBaseFrameLayout.addView(activityView);
        tvToolbarTitle.setText(name);

    }

    public abstract void initViews();

    public abstract void setFonts();

}
