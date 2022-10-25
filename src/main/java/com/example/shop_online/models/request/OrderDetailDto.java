package com.example.shop_online.models.request;

import com.example.shop_online.models.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailDto {
    private Long id;
    private Product product;
    private Double price;
    private Double quantity;
    private Double total;
}
