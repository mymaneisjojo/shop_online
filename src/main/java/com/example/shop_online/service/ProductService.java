package com.example.shop_online.service;

import com.example.shop_online.config.MapperUtil;
import com.example.shop_online.models.entity.Product;
import com.example.shop_online.models.request.ProductRequest;
import com.example.shop_online.models.response.MessageResponse;
import com.example.shop_online.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public MessageResponse add(ProductRequest productRequest){
        Product product = MapperUtil.map(productRequest, Product.class);
        productRepository.save(product);
        return new MessageResponse(200, "Add product successfully");
    }

    public MessageResponse update(ProductRequest productRequest, int id){
        Product existProduct = productRepository.findById(id).orElse(null);
        Product product = MapperUtil.map(productRequest, Product.class);
        productRepository.save(product);
        return new MessageResponse(200, "Update product successfully");
    }

    public MessageResponse delete(int id){
        Product existProduct = productRepository.findById(id).orElse(null);
        existProduct.setDeleted(true);
        productRepository.save(existProduct);
        return new MessageResponse(200, "Delete product successfully");
    }
}
