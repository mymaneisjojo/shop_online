package com.example.shop_online.service;

import com.example.shop_online.models.entity.Product;
import com.example.shop_online.models.request.ProductDto;
import com.example.shop_online.models.response.MessageResponse;
import com.example.shop_online.service.generic.GenericService;

import java.util.List;

public interface ProductService extends GenericService<Product> {

     MessageResponse add(ProductDto productDto);
     MessageResponse update(ProductDto productDto, int id);
     void delete(Integer id);

}
