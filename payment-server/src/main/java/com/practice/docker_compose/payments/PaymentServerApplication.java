package com.practice.docker_compose.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServerApplication.class, args);
    }
}
