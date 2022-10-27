package com.example.shop_online.service;

import com.example.shop_online.models.entity.Order;
import com.example.shop_online.models.request.OrderDto;
import com.example.shop_online.models.response.MessageResponse;

import java.util.List;

public interface OrderService {
     MessageResponse add(OrderDto orderDto);
     MessageResponse update(OrderDto orderDto, int id);
     MessageResponse deleteOrder(int id);
}
