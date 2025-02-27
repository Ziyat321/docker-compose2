package com.practice.docker_compose.payments.controller;

import com.practice.docker_compose.payments.model.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PaymentController {
    @GetMapping("/payment")
    public Payment getPayment() {
        return new Payment(true, LocalDateTime.now());
    }
}
