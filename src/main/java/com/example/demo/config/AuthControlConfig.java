package com.example.demo.config;

import com.example.demo.interceptor.AuthControlInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthControlConfig implements WebMvcConfigurer {

    @Bean
    public AuthControlInterceptor setAuthControlInterceptor() {
        System.out.println("注入了Auth handler");
        return new AuthControlInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(setAuthControlInterceptor());
    }
}
