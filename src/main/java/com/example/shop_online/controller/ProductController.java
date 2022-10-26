package com.example.shop_online.controller;

import com.example.shop_online.models.request.ProductDto;
import com.example.shop_online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.add(productDto));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") int id){
        return ResponseEntity.ok(productService.update(productDto, id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id){
        return ResponseEntity.ok(productService.delete(id));
    }

}
