package com.cyf.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author by cyf
 * @date 2020/7/27.
 */
@SpringBootApplication
@EnableEurekaClient
public class RibbonServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonServiceApplication.class, args);
    }
}
