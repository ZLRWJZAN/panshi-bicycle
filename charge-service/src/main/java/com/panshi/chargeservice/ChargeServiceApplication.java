package com.panshi.chargeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ChargeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChargeServiceApplication.class, args);
    }

}
