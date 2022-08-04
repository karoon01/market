package com.yosypchuk.market.controller;

import com.yosypchuk.market.api.OrderApi;
import com.yosypchuk.market.model.dto.OrderDTO;
import com.yosypchuk.market.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @Override
    public List<OrderDTO> getAllUserOrders(Long userId) {
        return orderService.getAllUserOrders(userId);
    }

    @Override
    public ResponseEntity<Void> removeOrder(Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
