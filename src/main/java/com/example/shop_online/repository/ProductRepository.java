package com.example.shop_online.repository;

import com.example.shop_online.models.entity.Product;
import com.example.shop_online.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GenericRepository<Product> {
}
