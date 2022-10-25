package com.example.shop_online.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
public class ProductRequest {
    private int id;
    private String name;
    private float price;
    private int quantity;


}
