package com.example.shop_online.models.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Integer id;
    private String username;
    private String email;
    private String phone;
}
