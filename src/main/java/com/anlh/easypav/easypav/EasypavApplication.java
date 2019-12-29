package com.anlh.easypav.easypav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class EasypavApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasypavApplication.class, args);
    }

}
