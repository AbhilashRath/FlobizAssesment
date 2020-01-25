package com.rath.flobizinternassesment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rath.flobizinternassesment.Activities.WeatherActivity;
import com.rath.flobizinternassesment.Classes.City;
import com.rath.flobizinternassesment.Classes.Weather;
import com.rath.flobizinternassesment.R;

import java.util.ArrayList;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityHolder> {
    private List<City> cities = new ArrayList<>();
    private Context context;


    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_item, parent, false);
        context = parent.getContext();
        return new CityHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CityHolder holder, int position) {
        final City currentCity = cities.get(position);
        holder.textViewCity.setText(currentCity.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, WeatherActivity.class);
                i.putExtra("name", currentCity.getName());
//                myIntent.putExtra("key", value); //Optional parameters
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
        notifyDataSetChanged();
    }

    class CityHolder extends RecyclerView.ViewHolder {
        private TextView textViewCity;


        public CityHolder(View itemView) {
            super(itemView);
            textViewCity = itemView.findViewById(R.id.text_view_city);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Log.i("Click","Click");
//                }
//            });
;
        }
    }
}
