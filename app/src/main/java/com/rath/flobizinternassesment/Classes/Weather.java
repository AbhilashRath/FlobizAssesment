package com.rath.flobizinternassesment.Classes;

import org.json.JSONObject;

import java.util.*;

//import java.util.*;
public class Weather {
    private Object main;
    private String name;
    private Object wind;

    public Weather(Object main, String name, Object wind) {
        this.main = main;
        this.name = name;
        this.wind = wind;
    }

    public Object getMain() {
        return main;
    }

    public String getName() {
        return name;
    }

    public Object getWind() {
        return wind;
    }
}
