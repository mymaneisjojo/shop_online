package com.example.shop_online.service.generic;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

    void save(T entity);

    Optional<T> findById(Integer id);

}
