package com.rath.flobizinternassesment.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.rath.flobizinternassesment.Classes.Weather;
import com.rath.flobizinternassesment.R;
import com.rath.flobizinternassesment.ViewModels.WeatherViewModel;

import java.util.Map;

public class WeatherActivity extends AppCompatActivity {
    private WeatherViewModel weatherViewModel;
    private TextView tv;
    public static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Intent i = getIntent();
        name = i.getStringExtra("name");

        tv = findViewById(R.id.weather);
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        weatherViewModel.getWeatherLiveData().observe(this, new Observer<Weather>() {
            @Override
            public void onChanged(Weather weather) {
                Object main = weather.getMain();
                Map<String,Float> m = (Map<String, Float>) main;
                Object wind = weather.getWind();
                Map<String,Float> w = (Map<String, Float>) wind;
                String s = weather.getName() + "\n" + "\n"+ "Temperature: " + m.get("temp")+ "\n" + "\n"+
                        "Pressure: " + m.get("pressure")+ "\n"+ "\n" +
                        "Humidity: " + m.get("humidity") + "\n"+ "\n" +
                        "Wind Speed: " + w.get("speed");
                tv.setText(s);

            }
        });


    }
}
