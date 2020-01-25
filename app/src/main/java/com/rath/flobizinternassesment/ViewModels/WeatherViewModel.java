package com.rath.flobizinternassesment.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rath.flobizinternassesment.Classes.Weather;
import com.rath.flobizinternassesment.Repositories.WeatherRepository;

public class WeatherViewModel extends AndroidViewModel {

    private LiveData<Weather> weatherLiveData;
    private WeatherRepository weatherRepository;
    public WeatherViewModel(@NonNull Application application) {
        super(application);
        weatherRepository = new WeatherRepository();
        this.weatherLiveData = weatherRepository.getWeather();


    }
    public LiveData<Weather> getWeatherLiveData() {
        return weatherLiveData;
    }
}
