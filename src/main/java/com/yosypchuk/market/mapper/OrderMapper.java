package com.yosypchuk.market.mapper;

import com.yosypchuk.market.model.dto.OrderDTO;
import com.yosypchuk.market.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrder(OrderDTO orderDTO);
    OrderDTO mapOrderDto(Order order);
}
