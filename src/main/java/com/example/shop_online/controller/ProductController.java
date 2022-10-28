package com.example.shop_online.controller;

import com.example.shop_online.models.request.ProductDto;
import com.example.shop_online.models.response.MessageResponse;
import com.example.shop_online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
//
//    @GetMapping("/all")
//    public ResponseEntity<?> getAll(){
//        return ResponseEntity.ok(productService.getAll());
//    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.add(productDto));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable("id") int id){
        return ResponseEntity.ok(productService.update(productDto, id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id){
        productService.delete(id);
        return ResponseEntity.ok(new MessageResponse(200, "Delete successfully"));
    }

}
