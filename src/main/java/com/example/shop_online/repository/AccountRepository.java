package com.example.shop_online.repository;

import com.example.shop_online.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByUsernameOrEmail(String username, String email);
}
