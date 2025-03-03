package com.practice.docker_compose.orders.controller;

import com.practice.docker_compose.orders.model.Order;
import com.practice.docker_compose.orders.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private List<Order> orders = new ArrayList<Order>();
    private RestTemplate restTemplate = new RestTemplate();
    @Value("${payment.server.url}")
    private String paymentServerUrl;

    @PostMapping
    public Order createOrder(@RequestParam String user,@RequestParam String address) {
        ResponseEntity<Payment> paymentResponseEntity = restTemplate.getForEntity(paymentServerUrl, Payment.class);
        Payment payment = paymentResponseEntity.getBody();
        Order order = new Order(user, address, payment);
        orders.add(order);
        return order;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orders;
    }
}
