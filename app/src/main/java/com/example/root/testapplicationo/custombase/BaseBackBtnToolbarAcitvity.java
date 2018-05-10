package com.example.root.testapplicationo.custombase;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

public class BaseBackBtnToolbarAcitvity extends AppCompatActivity {
    Toolbar mToolbar;
    TextView tvToolbarTitle;
    FrameLayout mBaseFrameLayout ;
    public String APP_FONT = "Lato-Regular.ttf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_back_btn_toolbar_acitvity);
        findViewsIds();
        setBaseToolbar();
        setBaseActivityFonts();
    }
    private void setBaseActivityFonts() {
        tvToolbarTitle.setTypeface(Typeface.createFromAsset(getAssets(),APP_FONT));
        tvToolbarTitle.setTextSize(20f);
        tvToolbarTitle.setTextSize(Color.WHITE);

    }

    private void setBaseToolbar() {

    }

    private void findViewsIds() {

        mToolbar = findViewById(R.id.base_toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back_arrow));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tvToolbarTitle = findViewById(R.id.base_toolbar_title);
        mBaseFrameLayout = findViewById(R.id.base_frame_layout);
    }


    public void setView (int layout ,String name)
    {
        //  LayoutInflater layoutInflater = LayoutInflater.from(Context.GET)
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View activityView = layoutInflater.inflate(layout,null,false);
        mBaseFrameLayout.addView(activityView);
        tvToolbarTitle.setText(name);

    }

}
