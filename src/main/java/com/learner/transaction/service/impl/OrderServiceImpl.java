package com.learner.transaction.service.impl;

import com.learner.transaction.dto.OrderDto;
import com.learner.transaction.dto.OrderRequest;
import com.learner.transaction.dto.OrderResponse;
import com.learner.transaction.dto.PaymentDto;
import com.learner.transaction.entity.Order;
import com.learner.transaction.entity.Payment;
import com.learner.transaction.exception.PaymentException;
import com.learner.transaction.mapper.OrderMapper;
import com.learner.transaction.mapper.PaymentMapper;
import com.learner.transaction.repository.OrderRepository;
import com.learner.transaction.repository.PaymentRepository;
import com.learner.transaction.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final OrderMapper orderMapper;
    private final PaymentMapper paymentMapper;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository,
                            OrderMapper orderMapper, PaymentMapper paymentMapper) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.orderMapper = orderMapper;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        //Transaction 1 - Save the order details
        final OrderDto orderDto = orderRequest.getOrderDto();
        orderDto.setStatus("In Progress");
        orderDto.setOrderTrackingNumber(UUID.randomUUID().toString());
        Order savedOrder = orderRepository.save(orderMapper.convertToEntity(orderDto));
        OrderDto savedoOrderDto = orderMapper.convertToDto(savedOrder);

        //Transaction 2 - Save the payment details
        final PaymentDto paymentDto = orderRequest.getPaymentDto();

        if(!paymentDto.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type does not supported.");
        }

        paymentDto.setOrderId(savedoOrderDto.getId());
        Payment savedPayment = paymentRepository.save(paymentMapper.convertToEntity(paymentDto));

        final OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(savedoOrderDto.getOrderTrackingNumber());
        orderResponse.setStatus(savedoOrderDto.getStatus());
        orderResponse.setMessage("Success");

        return orderResponse;
    }
}
