package com.learner.transaction.controller;

import com.learner.transaction.dto.OrderRequest;
import com.learner.transaction.dto.OrderResponse;
import com.learner.transaction.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //http://localhost://8080/api/v1/orders
    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }

}
