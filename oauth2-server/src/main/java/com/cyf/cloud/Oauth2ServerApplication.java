package com.cyf.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class Oauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerApplication.class, args);
    }

}
