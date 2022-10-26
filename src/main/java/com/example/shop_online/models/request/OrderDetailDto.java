package com.example.shop_online.models.request;

import com.example.shop_online.models.entity.Product;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetailDto {
    private Integer id;
    private Product product;
    private Double price;
    private Double quantity;
    private Double total;
}
