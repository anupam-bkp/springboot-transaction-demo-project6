package com.learner.transaction.mapper;

import com.learner.transaction.dto.PaymentDto;
import com.learner.transaction.entity.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    private ModelMapper mapper = new ModelMapper();

    public Payment convertToEntity(PaymentDto paymentDto){
        return mapper.map(paymentDto, Payment.class);
    }

    public PaymentDto convertToDto(Payment payment){
        return mapper.map(payment, PaymentDto.class);
    }

}
