package com.example.shop_online.controller;

import com.example.shop_online.models.entity.Account;
import com.example.shop_online.models.request.OrderRequest;
import com.example.shop_online.service.OrderService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("add")
    public ResponseEntity<?> addOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.add(orderRequest));
    }
}
