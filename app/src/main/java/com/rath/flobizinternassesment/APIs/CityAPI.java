package com.rath.flobizinternassesment.APIs;
import com.rath.flobizinternassesment.Classes.CityList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CityAPI {
    @GET("lw9qf")
    Call<CityList> getCities();
}