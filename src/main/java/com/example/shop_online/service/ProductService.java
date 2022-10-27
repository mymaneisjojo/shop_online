package com.example.shop_online.service;

import com.example.shop_online.models.entity.Product;
import com.example.shop_online.models.request.ProductDto;
import com.example.shop_online.models.response.MessageResponse;

import java.util.List;

public interface ProductService {
     List<Product> getAll();
     MessageResponse add(ProductDto productDto);
     MessageResponse update(ProductDto productDto, int id);
     MessageResponse delete(int id);
}
