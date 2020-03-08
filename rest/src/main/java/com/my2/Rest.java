package com.my2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.my",
        "com.my2",
        "com.my3",
        "com.nec.process"
})
//@PropertySource("classpath:application.properties")

public class Rest {
    public static void main(String[] args) {
        SpringApplication.run(Rest.class, args);
    }
}
