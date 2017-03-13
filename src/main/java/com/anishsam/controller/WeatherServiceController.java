package com.anishsam.controller;

import com.anishsam.namespace.weatherservice.WeatherException;
import com.anishsam.namespace.weatherservice.general.ForecastRequest;
import com.anishsam.namespace.weatherservice.general.ForecastReturn;
import com.anishsam.namespace.weatherservice.general.WeatherInformationReturn;
import com.anishsam.namespace.weatherservice.general.WeatherReturn;
import com.anishsam.transformation.GetCityForecastByZIPOutMapper;
import org.springframework.stereotype.Component;

/*
 *  Example-Controller:
 *  This Class would be responsible for Mapping from Request to internal Datamodel (and backwards),
 *  for calling Backend-Services and handling Backend-Exceptions
 *  So it decouples the WSDL-generated Classes from the internal Classes - for when the former changes,
 *  nothing or only the mapping has to be changed
 */
@Component
public class WeatherServiceController {

    public ForecastReturn getCityForecastByZIP(ForecastRequest forecastRequest) {
        return GetCityForecastByZIPOutMapper.mapGeneralOutlook2Forecast();
    }

    public WeatherInformationReturn getWeatherInformation(String zip) throws WeatherException {
        return null;
    }

    public WeatherReturn getCityWeatherByZIP(ForecastRequest forecastRequest) throws WeatherException {
        return null;
    }

}
