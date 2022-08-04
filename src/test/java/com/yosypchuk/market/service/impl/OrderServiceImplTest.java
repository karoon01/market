package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {
    @InjectMocks
    private OrderServiceImpl orderService;
    @Mock
    private OrderRepository orderRepository;

    @Test
    void testCreateOrder() {
        //given
        //when
        //then
    }

    @Test
    void testGetAllOrders() {
        //given
        //when
        //then
    }

    @Test
    void testGetAllUserOrders() {
        //given
        //when
        //then
    }

    @Test
    void testDeleteOrder() {
        //given
        //when
        //then
    }

    @Test
    void testRejectOrder() {
        //given
        //when
        //then
    }
}
