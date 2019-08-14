package com.panshi.h5api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class H5ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(H5ApiApplication.class, args);
    }

}
