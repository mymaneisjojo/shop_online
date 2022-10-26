package com.example.shop_online.service.impl;

import com.example.shop_online.models.entity.Account;
import com.example.shop_online.models.request.LoginDto;
import com.example.shop_online.models.response.MessageResponse;
import com.example.shop_online.repository.AccountRepository;
import com.example.shop_online.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public MessageResponse login(LoginDto loginDto){
        Account account = accountRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail()).orElse(null);
        if(account.getPassword().equals(loginDto.getPassword())){
            return new MessageResponse(200, "Login successfully");
        }
        return new MessageResponse(200, "Login fail");

    }
}
