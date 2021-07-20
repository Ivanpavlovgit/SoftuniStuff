package com.example.exc_xml.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class AppBeanConfiguration {
    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper ();
    }

    @Bean
    public BufferedReader bufferedReader () {
        return new BufferedReader (new InputStreamReader (System.in));
    }
}

