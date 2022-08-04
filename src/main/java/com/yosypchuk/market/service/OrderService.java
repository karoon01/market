package com.yosypchuk.market.service;

import com.yosypchuk.market.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getAllUserOrders(Long userId);

    void deleteOrder(Long orderId);

    void rejectOrder(Long orderId);
}
