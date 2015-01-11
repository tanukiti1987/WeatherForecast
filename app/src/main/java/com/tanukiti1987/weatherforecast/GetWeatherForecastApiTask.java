package com.tanukiti1987.weatherforecast;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by tanukiti1987 on 2015/01/12.
 */
public class GetWeatherForecastApiTask extends AsyncTask<String, Void, String>{
    private final Context context;
    Exception exception;

    public GetWeatherForecastApiTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            return WeatherApi.getWeather(context, params[0]);
        } catch (IOException e) {
            exception = e;
        }
        return null;
    }
}
