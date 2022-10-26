package com.example.shop_online.service.impl;

import com.example.shop_online.config.MapperUtil;
import com.example.shop_online.exception.ResourceNotFoundException;
import com.example.shop_online.models.entity.Order;
import com.example.shop_online.models.entity.OrderDetail;
import com.example.shop_online.models.entity.Product;
import com.example.shop_online.models.request.OrderDto;
import com.example.shop_online.models.response.MessageResponse;
import com.example.shop_online.repository.OrderDetailRepository;
import com.example.shop_online.repository.OrderRepository;
import com.example.shop_online.repository.ProductRepository;
import com.example.shop_online.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public MessageResponse add(OrderDto orderDto){
        Order order = MapperUtil.map(orderDto, Order.class);
        List<OrderDetail> lstOrderDetail = order.getLstOrderDetail();

        int total = 0;
        for (OrderDetail orDe: lstOrderDetail) {
            Product product = productRepository.findById(orDe.getProduct().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "id", orDe.getProduct().getId()));

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
        order.setTotal((double) total);
        order.setOrderAt(LocalDateTime.now());
        Order saveOrder = orderRepository.save(order);

        for (OrderDetail orDe: lstOrderDetail) {
            orDe.setOrder(saveOrder);
            orderDetailRepository.save(orDe);
        }

        return new MessageResponse(200, "Add order successfully");
    }


    @Override
    public MessageResponse update(OrderDto orderDto, int id){
        Order existOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

       orderDetailRepository.deleteByOrder(existOrder.getId());
        return add(orderDto);
    }
    @Override
    public MessageResponse deleteOrder(int id){
        Order existOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        existOrder.setIsDeleted(true);
        orderRepository.save(existOrder);
        for (OrderDetail orDe: existOrder.getLstOrderDetail()) {
            Product product = productRepository.findById(orDe.getProduct().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "id", orDe.getProduct().getId()));

            // update product quantity
            product.setQuantity(orDe.getProduct().getQuantity() + orDe.getQuantity());
            productRepository.save(product);
        }
        return new MessageResponse(200, "Delete order successfully");
    }
}
