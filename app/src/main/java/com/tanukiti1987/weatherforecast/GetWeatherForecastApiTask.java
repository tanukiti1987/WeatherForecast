package com.tanukiti1987.weatherforecast;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by tanukiti1987 on 2015/01/12.
 */
public class GetWeatherForecastApiTask extends AsyncTask<String, Void, WeatherForecast>{
    private final Context context;
    Exception exception;

    public GetWeatherForecastApiTask(Context context) {
        this.context = context;
    }

    @Override
    protected WeatherForecast doInBackground(String... params) {
        try {
            return WeatherApi.getWeather(context, params[0]);
        } catch (IOException e) {
            exception = e;
        } catch (JSONException e) {
            exception = e;
        }
        return null;
    }
}
