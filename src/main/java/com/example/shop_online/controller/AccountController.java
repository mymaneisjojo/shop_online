package com.example.shop_online.controller;

import com.example.shop_online.models.request.LoginDto;

import com.example.shop_online.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){

        return ResponseEntity.ok(accountService.login(loginDto));

    }
}
