package com.example.root.testapplicationo.custombase;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.root.testapplicationo.R;

public class CommonBottomAndToolBarActivity extends AppCompatActivity {
    private FrameLayout mCommonMenuActivityFrameLayoutFrameLayout;
    private BottomNavigationView mNavigationBottomNavigationView;
    private ListView mDrawerListView;
    private DrawerLayout mDrawerLayout;
    private TextView mToolbarTitleTextView;

    public String APP_FONT = "Lato-Regular.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_bottom_and_tool_bar);
        initView();
        setBaseActivityFonts();

    }

    private void initView() {
        //  mBottomMenuTitle = (TextView) findViewById(R.id.message);
        mToolbarTitleTextView = (TextView) findViewById(R.id.toolbar_title);
           //  getSupportActionBar().setDisplayShowTitleEnabled(false);
        mCommonMenuActivityFrameLayoutFrameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationBottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
           mNavigationBottomNavigationView = findViewById(R.id.navigation);
        BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {

                    case R.id.navigation_dashboard:
                      fragment = new NotificationFragment();
                        break;

                    case R.id.navigation_meetUp:
                        fragment = new MeetUpFragment();
                        break;
                    case R.id.navigation_logo:
                        fragment = new LogoFragment();
                        break;
                    case R.id.navigation_home:
                        fragment = new HomeFragment();

                        break;

                }

                return loadFragment(fragment);
            }
        };
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);



    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private void setBaseActivityFonts() {
        mToolbarTitleTextView.setTypeface(Typeface.createFromAsset(getAssets(), APP_FONT));
        mToolbarTitleTextView.setTextSize(20f);
        mToolbarTitleTextView.setTextColor(Color.WHITE);
    }

    public void setView(int viewLayout, String activityTitle) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View activityView = layoutInflater.inflate(viewLayout, null, false);
        mCommonMenuActivityFrameLayoutFrameLayout.addView(activityView);
        mToolbarTitleTextView.setText(activityTitle);
    }
}
