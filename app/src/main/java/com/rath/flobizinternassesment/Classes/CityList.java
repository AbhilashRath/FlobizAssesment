package com.rath.flobizinternassesment.Classes;

import com.google.gson.annotations.SerializedName;
import com.rath.flobizinternassesment.Classes.City;

import java.util.List;

public class CityList {
    @SerializedName("cities")
    private List<City> cities;

    public CityList(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
