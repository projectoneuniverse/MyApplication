package com.alphalearning.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.alphalearning.myapplication1.model.ResponseMovies;
import com.alphalearning.myapplication1.model.ResultsItem;

import com.alphalearning.myapplication1.retrofit.RetrofitConfig;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class  MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = findViewById(R.id.tabsID);
        viewPager = findViewById(R.id.viewPagerID);
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), MainActivity.this);
        adapter.AddFragment(new FragmentHome(), "Movies");
        adapter.AddFragment(new FragmentHome2(), "TV Show");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_movies);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tvshow);

        getSupportActionBar().setElevation(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_action_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}
//
//        rvID = findViewById(R.id.rv_Id);
//        //buat layout movies
////        //buat Model Data
////        modelData movies1 = new modelData();
////        movies1.setJudulMovies("judulMovies");
////        movies1.setPosterMovies("https://ecs7.tokopedia.net/img/cache/700/product-1/2019/5/23/23897862/23897862_b3f7a5a8-f0ed-4b7e-bf87-62deb3603eff_700_700");
////        for (int i = 0; i <20 ; i++) {
////            dataMovie.add(movies1);
////        }\
//        getDataOnline();
//
//
//
//        //buat adapter
//        MoviesAdapter adapter = new MoviesAdapter(MainActivity.this, dataMovie);
//        //buat layout grid
//      //  rvID.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//        rvID.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        rvID.setAdapter(adapter);
//
//    }
//
//    private void getDataOnline() {
//        Call<ResponseMovies> request = RetrofitConfig.getApiService().ambilDataMovie("0dba618ff29f0045d49a78d2f5d2a314");
//        request.enqueue(new Callback<ResponseMovies>() {
//            @Override
//            public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
//                if (response.isSuccessful()) {
//                    dataMovie = response.body().getResults();
//                    MoviesAdapter adapter = new MoviesAdapter(MainActivity.this, dataMovie);
//                    rvID.setAdapter(adapter);
//                } else {
//                    Toast.makeText(MainActivity.this, "Request Not Succses", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseMovies> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Request FAilure", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }

