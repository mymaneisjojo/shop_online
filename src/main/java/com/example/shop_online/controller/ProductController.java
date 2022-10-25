package com.example.shop_online.controller;

import com.example.shop_online.models.request.ProductRequest;
import com.example.shop_online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productService.add(productRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductRequest productRequest, @PathVariable("id") int id){
        return ResponseEntity.ok(productService.update(productRequest, id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id){
        return ResponseEntity.ok(productService.delete(id));
    }

}
