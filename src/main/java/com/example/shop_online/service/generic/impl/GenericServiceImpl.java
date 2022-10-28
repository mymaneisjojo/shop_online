package com.example.shop_online.service.generic.impl;

import com.example.shop_online.exception.ResourceNotFoundException;
import com.example.shop_online.repository.generic.GenericRepository;
import com.example.shop_online.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenericServiceImpl<T> implements GenericService<T> {
    @Autowired
    private GenericRepository<T> genericRepository;

    @Override
    public void save(T entity) {
        genericRepository.save(entity);
    }

    @Override
    public Optional<T> findById(Integer id) {
        return genericRepository.findById(id);
    }


}
