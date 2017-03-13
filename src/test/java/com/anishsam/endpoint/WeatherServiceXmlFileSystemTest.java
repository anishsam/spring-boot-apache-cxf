package com.anishsam.endpoint;

import com.anishsam.SimpleBootCxfSystemTestApplication;
import com.anishsam.namespace.weatherservice.WeatherException;
import com.anishsam.namespace.weatherservice.WeatherService;
import com.anishsam.namespace.weatherservice.general.ForecastReturn;
import com.anishsam.namespace.weatherservice.general.GetCityForecastByZIP;
import com.anishsam.utils.XmlUtils;
import com.anishsam.utils.XmlUtilsException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = {"server.port=8090"}, classes = SimpleBootCxfSystemTestApplication.class)
public class WeatherServiceXmlFileSystemTest {
    @Autowired
    private WeatherService weatherServiceSystemTestClient;

    @Value(value="classpath:requests/GetCityForecastByZIPTest.xml")
    private Resource getCityForecastByZIPTestXml;

    @Test
    public void getCityForecastByZIP() throws WeatherException, XmlUtilsException, IOException {
        // Given
        GetCityForecastByZIP getCityForecastByZIP = XmlUtils.readSoapMessageFromStreamAndUnmarshallBody2Object(getCityForecastByZIPTestXml.getInputStream(), GetCityForecastByZIP.class);

        // When
        ForecastReturn forecastReturn = weatherServiceSystemTestClient.getCityForecastByZIP(getCityForecastByZIP.getForecastRequest());

        // Then
        Assert.assertNotNull(forecastReturn);
        Assert.assertEquals(true, forecastReturn.isSuccess());
        Assert.assertEquals("Weimar", forecastReturn.getCity());
        Assert.assertEquals("22%", forecastReturn.getForecastResult().getForecast().get(0).getProbabilityOfPrecipiation().getDaytime());
    }
}
