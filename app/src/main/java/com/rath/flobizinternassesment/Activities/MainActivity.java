package com.rath.flobizinternassesment.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.rath.flobizinternassesment.Adapters.CityAdapter;
import com.rath.flobizinternassesment.Classes.CityList;
import com.rath.flobizinternassesment.ViewModels.CityViewModel;
import com.rath.flobizinternassesment.R;
import com.rath.flobizinternassesment.Services.RetrofitService;
import com.rath.flobizinternassesment.Classes.Weather;
import com.rath.flobizinternassesment.APIs.WeatherAPI;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private CityViewModel cityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        WeatherAPI weatherAPI = RetrofitService.cteateServiceWeather(WeatherAPI.class);
//        Call<Weather> call = weatherAPI.getMain("London","b6907d289e10d714a6e88b30761fae22");
//        call.enqueue(new Callback<Weather>() {
//            @Override
//            public void onResponse(Call<Weather> call, Response<Weather> response) {
//                Object res = response.body().getMain();
//                Map<String,Float> r = (Map<String, Float>) res;
//
//                Log.i("responsewea", String.valueOf(r.get("temp")) + String.valueOf(r.get("temp_min")) + String.valueOf(r.get("pressure")) + String.valueOf(r.get("humidity")) );
//            }
//
//            @Override
//            public void onFailure(Call<Weather> call, Throwable t) {
//
//            }
//        });





        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final CityAdapter adapter = new CityAdapter();
        recyclerView.setAdapter(adapter);

        cityViewModel = ViewModelProviders.of(this).get(CityViewModel.class);
        cityViewModel.getAllCities().observe(this, new Observer<CityList>() {
            @Override
            public void onChanged(CityList cities) {
                Log.i("Cities",cities.getCities().get(0).getName());
                adapter.setCities(cities.getCities());
            }
        });


    }
}
