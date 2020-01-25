package com.rath.flobizinternassesment.APIs;

import com.rath.flobizinternassesment.Classes.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("weather")
    Call<Weather> getMain(@Query("q") String a,
                          @Query("appid") String b);


}
