package com.example.shop_online.controller;

import com.example.shop_online.models.request.OrderDto;
import com.example.shop_online.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.add(orderDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrder(@RequestBody OrderDto orderDto, @PathVariable("id") int id){
        return ResponseEntity.ok(orderService.update(orderDto, id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") int id){
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
}
