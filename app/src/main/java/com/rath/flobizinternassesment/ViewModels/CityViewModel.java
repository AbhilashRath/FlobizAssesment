package com.rath.flobizinternassesment.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rath.flobizinternassesment.Classes.CityList;
import com.rath.flobizinternassesment.Repositories.CityRepository;


public class CityViewModel extends AndroidViewModel {
    private LiveData<CityList> allCities;
    private CityRepository cityRepository;
    public CityViewModel(@NonNull Application application) {
        super(application);
        cityRepository = new CityRepository();
        this.allCities = cityRepository.getAllCities();


    }
    public LiveData<CityList> getAllCities() {
        return allCities;
    }
}
