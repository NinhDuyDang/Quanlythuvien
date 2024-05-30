package com.example.managerlibrary.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "cutomer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)

    private Integer customerId;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;

    public Customer(Integer customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }
    public Customer() {
    }
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = this.phone;
    }
}
