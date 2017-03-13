package com.anishsam.endpoint;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import com.anishsam.configuration.ApplicationTestConfiguration;
import com.anishsam.namespace.weatherservice.WeatherException;
import com.anishsam.namespace.weatherservice.WeatherService;
import com.anishsam.namespace.weatherservice.general.ForecastRequest;
import com.anishsam.namespace.weatherservice.general.ForecastReturn;
import com.anishsam.utils.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationTestConfiguration.class)
public class WeatherServiceTest {

    @Autowired
    private WeatherServiceEndpoint weatherServiceEndpoint;

    @Test
    public void getCityForecastByZip() throws WeatherException {
        // Given
        ForecastRequest forecastRequest = TestHelper.generateDummyRequest();

        // When
        ForecastReturn forecastReturn = weatherServiceEndpoint.getCityForecastByZIP(forecastRequest);

        // Then
        assertNotNull(forecastReturn);
        assertEquals(true, forecastReturn.isSuccess());
        assertEquals("Weimar", forecastReturn.getCity());
        assertEquals("22%", forecastReturn.getForecastResult().getForecast().get(0).getProbabilityOfPrecipiation().getDaytime());
    }


}
