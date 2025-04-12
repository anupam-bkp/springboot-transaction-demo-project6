package com.learner.transaction.service;

import com.learner.transaction.dto.OrderRequest;
import com.learner.transaction.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);

}
