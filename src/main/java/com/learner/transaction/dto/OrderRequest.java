package com.learner.transaction.dto;

public class OrderRequest {

    private OrderDto orderDto;
    private PaymentDto paymentDto;

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    public PaymentDto getPaymentDto() {
        return paymentDto;
    }

    public void setPaymentDto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderDto=" + orderDto +
                ", paymentDto=" + paymentDto +
                '}';
    }
}
