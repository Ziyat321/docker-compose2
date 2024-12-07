package controller;

import model.Order;
import model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {
    private List<Order> orders = new ArrayList<Order>();
    private RestTemplate restTemplate = new RestTemplate();
    private String paymentServerUrl = "http://payment:9009/payment";

    @PostMapping
    public Order createOrder(String user, String address) {
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
