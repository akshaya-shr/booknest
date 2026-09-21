package com.booknest;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {

        order.setOrderDate(LocalDateTime.now());

        return orderRepository.save(order);
    }
}