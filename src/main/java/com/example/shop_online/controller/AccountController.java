package com.example.shop_online.controller;

import com.example.shop_online.models.request.LoginRequest;

import com.example.shop_online.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;


}
