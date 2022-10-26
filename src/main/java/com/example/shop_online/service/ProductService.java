package com.example.shop_online.service;

import com.example.shop_online.models.entity.Product;
import com.example.shop_online.models.request.ProductDto;
import com.example.shop_online.models.response.MessageResponse;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public MessageResponse add(ProductDto productDto);
    public MessageResponse update(ProductDto productDto, int id);
    public MessageResponse delete(int id);
}
