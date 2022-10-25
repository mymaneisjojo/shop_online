package com.example.shop_online.service;

import com.example.shop_online.config.MapperUtil;
import com.example.shop_online.models.entity.Account;
import com.example.shop_online.models.entity.Order;
import com.example.shop_online.models.entity.OrderDetail;
import com.example.shop_online.models.entity.Product;
import com.example.shop_online.models.request.OrderRequest;
import com.example.shop_online.models.response.MessageResponse;
import com.example.shop_online.repository.OrderDetailRepository;
import com.example.shop_online.repository.OrderRepository;
import com.example.shop_online.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;

    public MessageResponse add(OrderRequest orderRequest){
        Order order = MapperUtil.map(orderRequest, Order.class);
        List<OrderDetail> lstOrderDetail = order.getLstOrderDetail();


        int total = 0;
        for (OrderDetail orDe: lstOrderDetail) {
            Product product = productRepository.findById(orDe.getProduct().getId()).orElse(null);

            if(orDe.getQuantity() > product.getQuantity()){
                return new MessageResponse(400, "quantity have to smaller quantity of product");
            }
            orDe.setPrice(product.getPrice());
            orDe.setTotal((double) (product.getPrice() * orDe.getQuantity()));
            total += orDe.getTotal();

            orderDetailRepository.save(orDe);

            // update product quantity
            product.setQuantity(orDe.getProduct().getQuantity() - orDe.getQuantity());
            productRepository.save(product);

        }

        order.setOrderAt(LocalDateTime.now());
        Order saveOrder = orderRepository.save(order);

        for (OrderDetail orDe: lstOrderDetail) {
            orDe.setOrder(saveOrder);
        }

        return new MessageResponse(200, "Add order successfully");
    }


//
//    public MessageResponse update(OrderRequest orderRequest, int id){
//        Order order = orderRepository.findById(id).orElse(null);
//
//
//    }
}
