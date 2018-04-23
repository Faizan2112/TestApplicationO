package com.example.root.testapplicationo.retrotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.root.testapplicationo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroTest extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro_test);
        listView = findViewById(R.id.listViewHeroes);
        getHerosList();

    }

    private void getHerosList() {
     Retrofit retrofit = new Retrofit.Builder()
             .baseUrl(Api.BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build();

     Api api = retrofit.create(Api.class);
        Call<List<Heros>> call = api.getListCall();
        call.enqueue(new Callback<List<Heros>>() {
            @Override
            public void onResponse(Call<List<Heros>> call, Response<List<Heros>> response) {
                List<Heros> herosList = response.body();
                String [] heroes = new String [herosList.size()];
              for(int i = 0 ; i<herosList.size();i++)
              {
                  heroes[i] = herosList.get(i).getName();

              }
                listView.setAdapter(new ArrayAdapter<String>(getApplication(),android.R.layout.simple_list_item_1, heroes));
            }

            @Override
            public void onFailure(Call<List<Heros>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
