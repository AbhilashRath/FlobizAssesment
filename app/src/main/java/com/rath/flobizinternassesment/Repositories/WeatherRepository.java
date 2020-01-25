package com.rath.flobizinternassesment.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rath.flobizinternassesment.APIs.WeatherAPI;
import com.rath.flobizinternassesment.Activities.WeatherActivity;
import com.rath.flobizinternassesment.Adapters.CityAdapter;
import com.rath.flobizinternassesment.Classes.Weather;
import com.rath.flobizinternassesment.Services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
    private static WeatherRepository weatherRepository;

    public static WeatherRepository getInstance(){
        if (weatherRepository == null){
            weatherRepository = new WeatherRepository();
        }
        return weatherRepository;
    }
    private WeatherAPI weatherAPI;
    public WeatherRepository(){
        weatherAPI = RetrofitService.cteateServiceWeather(WeatherAPI.class);
    }
    public LiveData<Weather> getWeather() {
        final MutableLiveData<Weather> data = new MutableLiveData<>();
        Call<Weather> call = weatherAPI.getMain(WeatherActivity.name,"b19f23d6304b17aaad167dcc2167f210");

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    Log.i("Error", String.valueOf(response.code()));
                    data.setValue(null);
                    return;
                }

                data.setValue(response.body());



            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.i("Failure", String.valueOf(t.getMessage()));
                data.setValue(null);
            }
        });

        return data;
    }

}
