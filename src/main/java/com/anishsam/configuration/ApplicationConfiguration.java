package com.anishsam.configuration;

import com.anishsam.controller.WeatherServiceController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public WeatherServiceController weatherServiceController() {
        return new WeatherServiceController();
    }
}
