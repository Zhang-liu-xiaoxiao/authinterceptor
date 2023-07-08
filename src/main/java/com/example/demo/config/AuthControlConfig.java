package com.example.demo.config;

import com.example.demo.interceptor.AuthControlAcceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthControlConfig implements WebMvcConfigurer {

    @Bean
    public AuthControlAcceptor setBean2() {
        System.out.println("注入了Auth handler");
        return new AuthControlAcceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(setBean2());
    }
}
