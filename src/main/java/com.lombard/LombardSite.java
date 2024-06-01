package com.lombard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LombardSite {
    public static void main(String[] args) {
        SpringApplication.run(LombardSite.class);
    }
}
