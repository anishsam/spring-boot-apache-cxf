package com.anishsam.endpoint;

import com.anishsam.SimpleBootCxfSystemTestApplication;
import com.anishsam.configuration.WebServiceSystemTestConfiguration;
import com.anishsam.namespace.weatherservice.WeatherException;
import com.anishsam.namespace.weatherservice.WeatherService;
import com.anishsam.namespace.weatherservice.general.ForecastRequest;
import com.anishsam.namespace.weatherservice.general.ForecastReturn;
import com.anishsam.utils.TestHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = {"server.port=8090"}, classes = SimpleBootCxfSystemTestApplication.class)
public class WeatherServiceSystemTest {

    @Autowired
    private WeatherService weatherServiceSystemTestClient;

    @Test
    public void getCityForecastByZIP() throws WeatherException {
        // Given
        ForecastRequest forecastRequest = TestHelper.generateDummyRequest();

        // When
        ForecastReturn forecastReturn = weatherServiceSystemTestClient.getCityForecastByZIP(forecastRequest);

        // Then
        Assert.assertNotNull(forecastReturn);
        Assert.assertEquals(true, forecastReturn.isSuccess());
        Assert.assertEquals("Weimar", forecastReturn.getCity());
        Assert.assertEquals("22%", forecastReturn.getForecastResult().getForecast().get(0).getProbabilityOfPrecipiation().getDaytime());
    }

}
