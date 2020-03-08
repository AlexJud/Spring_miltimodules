package com.my4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {
        "com.my",
        "com.my4",
        "com.my3"
})
public class RestFlux {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestFlux.class, args);

    }
}
