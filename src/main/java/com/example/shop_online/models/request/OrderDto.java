package com.example.shop_online.models.request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto {
    private Integer id;
    private String note;
    private LocalDateTime orderAt;
    private Double total;
    private AccountDto account;
    private List<OrderDetailDto> lstOrderDetail;
}
