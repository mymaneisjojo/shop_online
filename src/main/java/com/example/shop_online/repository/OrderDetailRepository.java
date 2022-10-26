package com.example.shop_online.repository;

import com.example.shop_online.models.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {


    @Modifying
    @Query("DELETE FROM OrderDetail ol WHERE ol.order.id = ?1")
    void deleteByOrder(Integer orderId);
}
