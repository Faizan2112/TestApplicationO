package com.example.root.testapplicationo.fabmenu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.root.testapplicationo.R;

public class FabTestActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_test);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        showXmlFragment();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_xml) {
            showXmlFragment();
            return true;
        } else if (id == R.id.nav_code) {
            showCodeFragment();
            return true;
        } else if (id == R.id.nav_custom) {
           // Intent intent = new Intent(FabTestActivity.this, ScrollingActivity.class);
            //startActivity(intent);
            return true;
        }
        return false;
    }

    private void showXmlFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DemoXmlFragment()).commit();
    }

    private void showCodeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DemoCodeFragment()).commit();
    }

}
