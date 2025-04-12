package com.learner.transaction.mapper;

import com.learner.transaction.dto.OrderDto;
import com.learner.transaction.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private ModelMapper mapper = new ModelMapper();

    public Order convertToEntity(OrderDto orderDto){
        return mapper.map(orderDto, Order.class);
    }

    public OrderDto convertToDto(Order order){
        return mapper.map(order, OrderDto.class);
    }

}
