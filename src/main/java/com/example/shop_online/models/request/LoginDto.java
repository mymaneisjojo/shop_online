package com.example.shop_online.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {
    @NotNull(message = "Username or email cannot be null")
    private String usernameOrEmail;
    @NotNull(message = "Password cannot be null")
    private String password;
}
