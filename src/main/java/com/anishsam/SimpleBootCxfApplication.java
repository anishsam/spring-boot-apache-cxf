package com.anishsam;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by if993744 on 3/8/2017.
 */
@SpringBootApplication
public class SimpleBootCxfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleBootCxfApplication.class, args);
    }

//    @Bean
//    public ServletRegistrationBean dispatcherBean() {
//        return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
//    }

//    @Bean(name= Bus.DEFAULT_BUS_ID)
//    public SpringBus springBus() {
//        return new SpringBus();
//    }
}
