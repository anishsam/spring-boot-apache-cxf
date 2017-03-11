package com.anishsam.endpoint;

import com.anishsam.namespace.weatherservice.WeatherException;
import com.anishsam.namespace.weatherservice.general.ForecastRequest;
import com.anishsam.namespace.weatherservice.general.ForecastReturn;
import com.anishsam.namespace.weatherservice.general.WeatherInformationReturn;
import com.anishsam.namespace.weatherservice.general.WeatherReturn;

/**
 * Created by if993744 on 3/10/2017.
 */
public class WeatherServiceEndpoint implements com.anishsam.namespace.weatherservice.WeatherService {

    @Override
    public WeatherInformationReturn getWeatherInformation(String zip) throws WeatherException {
        return null;
    }

    @Override
    public ForecastReturn getCityForecastByZIP(ForecastRequest forecastRequest) throws WeatherException {
        return null;
    }

    @Override
    public WeatherReturn getCityWeatherByZIP(ForecastRequest forecastRequest) throws WeatherException {
        return null;
    }
}
