package com.rath.flobizinternassesment.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rath.flobizinternassesment.APIs.CityAPI;
import com.rath.flobizinternassesment.Classes.CityList;
import com.rath.flobizinternassesment.Services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityRepository {
    private static CityRepository cityRepository;

    public static CityRepository getInstance(){
        if (cityRepository == null){
            cityRepository = new CityRepository();
        }
        return cityRepository;
    }
    private CityAPI cityAPI;
    public CityRepository(){
        cityAPI = RetrofitService.cteateService(CityAPI.class);
    }
    public LiveData<CityList> getAllCities() {
        final MutableLiveData<CityList> data = new MutableLiveData<>();
        Call<CityList> call = cityAPI.getCities();

        call.enqueue(new Callback<CityList>() {
            @Override
            public void onResponse(Call<CityList> call, Response<CityList> response) {

                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    Log.i("Error", String.valueOf(response.code()));
                    data.setValue(null);
                    return;
                }

                CityList city = response.body();
                data.setValue(city);
                Log.i("response", city.getCities().get(0).getName());


            }

            @Override
            public void onFailure(Call<CityList> call, Throwable t) {
                Log.i("Failure", String.valueOf(t.getMessage()));
                data.setValue(null);
            }
        });
        return data;
    }
//      Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.myjson.com/bins/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        CityAPI cityAPI = retrofit.create(CityAPI.class);
//        Call<CityList> call = cityAPI.getCities();
//
//        call.enqueue(new Callback<CityList>() {
//            @Override
//            public void onResponse(Call<CityList> call, Response<CityList> response) {
//
//                if (!response.isSuccessful()) {
//                    //textViewResult.setText("Code: " + response.code());
//                    Log.i("Error", String.valueOf(response.code()));
//                    return;
//                }
//
//                CityList city = response.body();
//                Log.i("response", city.getCities().get(0).getName());
//
//
//            }
//
//            @Override
//            public void onFailure(Call<CityList> call, Throwable t) {
//                Log.i("Failure", String.valueOf(t.getMessage()));
//            }
//        });
}
