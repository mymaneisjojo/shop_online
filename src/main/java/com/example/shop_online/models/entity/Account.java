package com.example.shop_online.models.entity;

import lombok.*;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Order> lstOrder;
}
