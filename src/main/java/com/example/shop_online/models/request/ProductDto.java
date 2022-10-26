package com.example.shop_online.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Price cannot be null")
    private Float price;
    @NotNull(message = "Quantity cannot be null")
    private Integer quantity;


}
