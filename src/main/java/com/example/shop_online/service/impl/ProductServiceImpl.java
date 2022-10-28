package com.example.shop_online.service.impl;

import com.example.shop_online.config.MapperUtil;
import com.example.shop_online.exception.ResourceNotFoundException;
import com.example.shop_online.models.entity.Product;
import com.example.shop_online.models.request.ProductDto;
import com.example.shop_online.models.response.MessageResponse;
import com.example.shop_online.repository.ProductRepository;
import com.example.shop_online.service.ProductService;
import com.example.shop_online.service.generic.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService {

    @Override
    public MessageResponse add(ProductDto productDto){
        Product product = MapperUtil.map(productDto, Product.class);
        save(product);
        return new MessageResponse(200, "successfully");
    }
    @Override
    public MessageResponse update(ProductDto productDto, int id){
        findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        Product product = MapperUtil.map(productDto, Product.class);
        save(product);
        return new MessageResponse(200, "Update product successfully");
    }


    @Override
    public void delete(Integer id){
        Product existProduct = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        existProduct.setIsDeleted(true);
        save(existProduct);

    }


}
