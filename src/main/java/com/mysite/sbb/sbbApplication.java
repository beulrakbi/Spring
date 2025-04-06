package com.mysite.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.mysite.sbb")
public class sbbApplication {
    public static void main(String[] args) {
        SpringApplication.run(sbbApplication.class, args);
    }
}
