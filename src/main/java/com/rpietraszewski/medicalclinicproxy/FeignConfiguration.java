package com.rpietraszewski.medicalclinicproxy;

import feign.Feign;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    @Bean
    public OkHttpClient client() {
        return new feign.okhttp.OkHttpClient();
    }

    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder().client(client());
    }
}
