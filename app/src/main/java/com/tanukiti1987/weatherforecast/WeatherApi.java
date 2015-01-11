package com.tanukiti1987.weatherforecast;

import android.content.Context;
import android.net.http.AndroidHttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tanukiti1987 on 2015/01/12.
 */
public class WeatherApi {
    private static final String USER_AGENT = "WheatherForecasts Sample";
    private static final String URL =
            "http://weather.livedoor.com/forecast/webservice/json/v1?city=";

    public static WeatherForecast getWeather(Context context, String pointId) throws IOException, JSONException {
        AndroidHttpClient client = AndroidHttpClient.newInstance(USER_AGENT, context);
        HttpGet get = new HttpGet(URL + pointId);

        StringBuilder sb = new StringBuilder();

        try {
            HttpResponse response = client.execute(get);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            client.close();
        }

        return new WeatherForecast(new JSONObject(sb.toString()));
    }
}
