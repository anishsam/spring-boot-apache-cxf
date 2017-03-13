package com.anishsam.configuration;

import com.anishsam.namespace.weatherservice.WeatherService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceSystemTestConfiguration {

    @Bean
    public WeatherService weatherServiceSystemTestClient() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(WeatherService.class);
        jaxWsProxyFactoryBean.setAddress("http://localhost:8090" + WebServiceConfiguration.BASE_URL + WebServiceConfiguration.SERVICE_URL);
        return (WeatherService)jaxWsProxyFactoryBean.create();
    }
}
