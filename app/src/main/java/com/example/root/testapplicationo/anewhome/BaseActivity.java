package com.example.root.testapplicationo.anewhome;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import com.example.root.testapplicationo.R;

import java.util.Map;

public class BaseActivity extends AppCompatActivity {

    /*public DrawerLayout drawerLayout;
    public ListView drawerList;
    public String[] layers;
    Toolbar mToolbar ;
    private ActionBarDrawerToggle drawerToggle;
    private Map map;

    @SuppressLint("ResourceType")
   // protected void onCreate(Bundle savedInstanceState) {
    protected void onCreateDrawer() {
        // R.id.drawer_layout should be in every activity with exactly the same id.
        // super.onCreateDrawer();

        mToolbar = findViewById(R.layout.toolbar_layout);
      //  drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        drawerToggle = new ActionBarDrawerToggle((Activity) this, drawerLayout, mToolbar, 0, 0) {
            public void onDrawerClosed(View view) {
              //  getActionBar().setTitle(R.string.app_name);
                getSupportActionBar().setTitle(R.string.app_name);
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(R.string.menu);
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        layers = getResources().getStringArray(R.array.layers_array);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        View header = getLayoutInflater().inflate(R.layout.drawer_list_header, null);
        drawerList.addHeaderView(header, null, false);
        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, android.R.id.text1,
                layers));
        View footerView = ((LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(
                R.layout.drawer_list_footer, null, false);
        drawerList.addFooterView(footerView);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
              //  map.drawerClickEvent(pos);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }*/
}
