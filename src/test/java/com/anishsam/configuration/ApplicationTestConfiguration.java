package com.anishsam.configuration;

import com.anishsam.endpoint.WeatherServiceEndpoint;
import com.anishsam.namespace.weatherservice.WeatherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by if993744 on 3/11/2017.
 */
@Configuration
@Import(ApplicationConfiguration.class)
public class ApplicationTestConfiguration {

    @Bean
    public WeatherService weatherService() {
        return new WeatherServiceEndpoint();
    }
}
