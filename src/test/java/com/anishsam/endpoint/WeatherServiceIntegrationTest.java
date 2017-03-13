package com.anishsam.endpoint;

import com.anishsam.configuration.WebServiceIntegrationTestConfiguration;
import com.anishsam.namespace.weatherservice.WeatherException;
import com.anishsam.namespace.weatherservice.WeatherService;
import com.anishsam.namespace.weatherservice.general.ForecastRequest;
import com.anishsam.namespace.weatherservice.general.ForecastReturn;
import com.anishsam.utils.TestHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= WebServiceIntegrationTestConfiguration.class)
public class WeatherServiceIntegrationTest {

    @Autowired
    public WeatherService weatherServiceIntegrationTestClient;

    @Test
    public void getCityForecastByZIP() throws WeatherException {
        // Given
        ForecastRequest forecastRequest = TestHelper.generateDummyRequest();

        // When
        ForecastReturn forecastReturn = weatherServiceIntegrationTestClient.getCityForecastByZIP(forecastRequest);

        // Then
        Assert.assertNotNull(forecastReturn);
        Assert.assertEquals("22%", forecastReturn.getForecastResult().getForecast().get(0).getProbabilityOfPrecipiation().getDaytime());
    }

}
