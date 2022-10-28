package com.example.shop_online.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GenericRepository<T> extends JpaRepository<T, Integer> {
}
