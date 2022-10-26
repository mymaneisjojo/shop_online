package com.example.shop_online.service.impl;

import com.example.shop_online.config.MapperUtil;
import com.example.shop_online.exception.ResourceNotFoundException;
import com.example.shop_online.models.entity.Product;
import com.example.shop_online.models.request.ProductDto;
import com.example.shop_online.models.response.MessageResponse;
import com.example.shop_online.repository.ProductRepository;
import com.example.shop_online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    @Override
    public MessageResponse add(ProductDto productDto){
        Product product = MapperUtil.map(productDto, Product.class);
        productRepository.save(product);
        return new MessageResponse(200, "Add product successfully");
    }
    @Override
    public MessageResponse update(ProductDto productDto, int id){
        Product existProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        Product product = MapperUtil.map(productDto, Product.class);
        productRepository.save(product);
        return new MessageResponse(200, "Update product successfully");
    }
    @Override
    public MessageResponse delete(int id){
        Product existProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        existProduct.setIsDeleted(true);
        productRepository.save(existProduct);
        return new MessageResponse(200, "Delete product successfully");
    }
}
