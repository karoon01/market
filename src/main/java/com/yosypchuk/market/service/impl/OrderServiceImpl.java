package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.mapper.OrderMapper;
import com.yosypchuk.market.model.dto.OrderDTO;
import com.yosypchuk.market.model.entity.Order;
import com.yosypchuk.market.model.entity.OrderStatus;
import com.yosypchuk.market.repository.OrderRepository;
import com.yosypchuk.market.repository.UserRepository;
import com.yosypchuk.market.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        log.info("Create order");
        Order order = OrderMapper.INSTANCE.mapOrder(orderDTO);
        order.setStatus(OrderStatus.PENDING);

        orderRepository.save(order);

        return OrderMapper.INSTANCE.mapOrderDto(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        log.info("Get all orders");
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper.INSTANCE::mapOrderDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<OrderDTO> getAllUserOrders(Long userId) {
        log.info("Trying to get user with id: {}", userId);
        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User doesn't exist!"));

        log.info("Get all orders for user with id: {}", userId);
        return orderRepository.getAllOrdersByUserId(userId)
                .stream()
                .map(OrderMapper.INSTANCE::mapOrderDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteOrder(Long orderId) {
        log.info("Get order by id: {}", orderId);
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order doesn't exist"));

        log.info("Delete order with id: {}", orderId);
        orderRepository.delete(order);
    }

    @Transactional
    @Override
    public void rejectOrder(Long orderId) {
        log.info("Trying to get order with id: {}", orderId);
        orderRepository.findById(orderId)
                        .orElseThrow(() -> new EntityNotFoundException("Order doesn't exist"));

        log.info("Reject order with id: {}", orderId);
        orderRepository.updateOrderStatus(orderId, OrderStatus.REJECTED);
    }
}
