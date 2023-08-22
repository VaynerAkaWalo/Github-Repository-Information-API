package com.example.githubapiproxy.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.githubapiproxy.proxy")
public class ApplicationConfig {
}
