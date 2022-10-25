package com.example.shop_online.models.request;

import com.example.shop_online.models.entity.Account;
import com.example.shop_online.models.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRequest {
    private String note;
    private LocalDateTime orderAt;
    private AccountDto account;
    private List<OrderDetailDto> lstOrderDetail;
}
