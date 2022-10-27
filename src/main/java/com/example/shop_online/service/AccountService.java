package com.example.shop_online.service;

import com.example.shop_online.models.request.LoginDto;
import com.example.shop_online.models.response.MessageResponse;

public interface AccountService {
     MessageResponse login(LoginDto loginDto);
}
