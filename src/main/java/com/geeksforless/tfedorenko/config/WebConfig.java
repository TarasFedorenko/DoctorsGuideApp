package com.geeksforless.tfedorenko.config;

import com.geeksforless.tfedorenko.util.StringToDateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import java.util.Date;


@Configuration
public class WebConfig {

    @Bean
    public Formatter<Date> dateFormatter() {
        return new StringToDateConverter();
    }
}
